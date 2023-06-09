package com.gitlab.techschool.pcbook.service;

import com.gitlab.techschool.pcbook.pb.*;
import com.gitlab.techschool.pcbook.sample.Generator;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.jupiter.api.*;
import org.junit.Rule;


import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LaptopServerTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule(); // automatic graceful shutdown channel at the end of test

    private LaptopStore laptopStore;
    //private ImageStore imageStore;
    private RatingStore ratingStore;

    private LaptopServer server;
    private ManagedChannel channel;

    @BeforeAll
    public void setUp() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(serverName).directExecutor();

        laptopStore = new InMemoryLaptopStore();
        //imageStore = new DiskImageStore("tmp");
        ratingStore = new InMemoryRatingStore();

        server = new LaptopServer(serverBuilder, 0, laptopStore, ratingStore);//, imageStore, ratingStore);
        server.start();

        channel = grpcCleanup.register(
                InProcessChannelBuilder.forName(serverName).directExecutor().build()
        );
    }

    @AfterAll
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void createLaptopWithAValidID() {
        Generator generator = new Generator();
        Laptop laptop = generator.NewLaptop();
        CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

        LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
        CreateLaptopResponse response = stub.createLaptop(request);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(laptop.getId(), response.getId());

        //Laptop found = laptopStore.Find(response.getId());
        //assertNotNull(found);
    }

    @Test
    public void createLaptopWithAnEmptyID() {
        Generator generator = new Generator();
        Laptop laptop = generator.NewLaptop().toBuilder().setId("").build();
        CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

        LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
        CreateLaptopResponse response = stub.createLaptop(request);
        assertNotNull(response);
        assertFalse(response.getId().isEmpty());

        //Laptop found = laptopStore.Find(response.getId());
        //assertNotNull(found);
    }

    @Test
    public void createLaptopWithAnInvalidID() {
        Assertions.assertThrows(StatusRuntimeException.class, ()-> {
                Generator generator = new Generator();
                Laptop laptop = generator.NewLaptop().toBuilder().setId("invalid").build();
                CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

                LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
                CreateLaptopResponse response = stub.createLaptop(request);
        });
    }

    @Test
    public void createLaptopWithAnAlreadyExistsID() throws Exception {
        Assertions.assertThrows(StatusRuntimeException.class, ()-> {
            Generator generator = new Generator();
            Laptop laptop = generator.NewLaptop();
            laptopStore.Save(laptop);
            CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

            LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
            CreateLaptopResponse response = stub.createLaptop(request);
        });
    }

    @Test
    public void rateLaptop() throws Exception {
        Generator generator = new Generator();
        Laptop laptop = generator.NewLaptop();
        laptopStore.Save(laptop);

        LaptopServiceGrpc.LaptopServiceStub stub = LaptopServiceGrpc.newStub(channel);
        RateLaptopResponseStreamObserver responseObserver = new RateLaptopResponseStreamObserver();
        StreamObserver<RateLaptopRequest> requestObserver = stub.rateLaptop(responseObserver);

        double[] scores = {8, 7.5, 10};
        double[] averages = {8, 7.75, 8.5};
        int n = scores.length;

        for (int i = 0; i < n; i++) {
            RateLaptopRequest request = RateLaptopRequest.newBuilder()
                    .setLaptopId(laptop.getId())
                    .setScore(scores[i])
                    .build();
            requestObserver.onNext(request);
        }

        requestObserver.onCompleted();
        Assertions.assertNull(responseObserver.err);
        Assertions.assertTrue(responseObserver.completed);
        Assertions.assertEquals(n, responseObserver.responses.size());

        int idx = 0;
        for (RateLaptopResponse response : responseObserver.responses) {
            Assertions.assertEquals(laptop.getId(), response.getLaptopId());
            Assertions.assertEquals(idx + 1, response.getRatedCount());
            Assertions.assertEquals(averages[idx], response.getAverageScore(), 1e-9);
            idx++;
        }
    }

    private class RateLaptopResponseStreamObserver implements StreamObserver<RateLaptopResponse> {
        public List<RateLaptopResponse> responses;
        public Throwable err;
        public boolean completed;

        public RateLaptopResponseStreamObserver() {
            responses = new LinkedList<>();
        }

        @Override
        public void onNext(RateLaptopResponse response) {
            responses.add(response);
        }

        @Override
        public void onError(Throwable t) {
            err = t;
        }

        @Override
        public void onCompleted() {
            completed = true;
        }
    }
}