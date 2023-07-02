package auction.model.memory.builder.deleter;

public class DeleterDirector
{
    private MemoryDeleter deleterBuilder;

    public DeleterDirector(MemoryDeleter deleterBuilder){ this.deleterBuilder = deleterBuilder; }

    public void delete(int id){
        deleterBuilder.openMemory();
        deleterBuilder.delete(id);
        deleterBuilder.closeMemory();
    }//delete

}//DeleterDirector
