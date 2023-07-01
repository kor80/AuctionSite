package auction.service;

import auction.model.memory.MemoryManager;
import io.grpc.ServerBuilder;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;
import java.util.logging.Logger;

public class ArticleServer
{
    private static final Logger logger = Logger.getLogger(ArticleServer.class.getName());
    private final int port;
    private final Server server;

    public ArticleServer(int port){
        this(ServerBuilder.forPort(port), port);
    }

    public ArticleServer(ServerBuilder serverBuilder, int port){
        this.port = port;
        ArticleService articleService = new ArticleService();
        server = serverBuilder.addService(articleService)
                .addService(ProtoReflectionService.newInstance())
                .build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("server started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("shut down gRPC server because JVM shuts down");
                try {
                    ArticleServer.this.stop();
                    MemoryManager memoryManager = MemoryManager.getInstance();
                    memoryManager.saveAllArticles();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("server shut down");
            }
        });
    }//start

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown();//.awaitTermination(30, TimeUnit.SECONDS);
        }
    }//stop

    private void blockUntilShutdown() throws InterruptedException{
        if (server != null) {
            server.awaitTermination();
        }
    }//blockUntilShutdown

    public static void main(String[] args) throws InterruptedException,IOException {
        ArticleServer server = new ArticleServer(8080);
        server.start();
        //(new Stopper(server)).start();
        server.blockUntilShutdown();
    }//main

    private static class Stopper extends Thread{
        ArticleServer server;
        public Stopper(ArticleServer server){
            this.server = server;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(30_000);
                server.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//run
    }//Stopper
}//ArticleServer
