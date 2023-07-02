package auction.model.memory.builder.deleter;

public interface MemoryDeleter
{
    void openMemory();
    void delete(int id);
    void closeMemory();
}//MemoryDeleter
