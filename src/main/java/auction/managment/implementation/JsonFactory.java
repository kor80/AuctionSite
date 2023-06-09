package auction.managment.implementation;

public class JsonFactory implements MemoryImplFactory {
    @Override
    public MemoryImplementation createMemoryImplementation() {
        return new JsonImplementation();
    }
}
