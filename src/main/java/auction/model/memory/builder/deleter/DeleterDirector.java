package auction.model.memory.builder.deleter;

/**
 * <h1>Deleter Director</h1>
 * This class specifies the right instructions
 * for deleting an article from the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class DeleterDirector
{
    private MemoryDeleter deleterBuilder;

    public DeleterDirector(MemoryDeleter deleterBuilder){ this.deleterBuilder = deleterBuilder; }

    /**
     * Deletes the article with id {@param id} from the database.
     * If the id is not present it does nothing.
     *
     * @param  id  The id of the article to be deleted.
     */
    public void delete(int id){
        deleterBuilder.openMemory();
        deleterBuilder.delete(id);
        deleterBuilder.closeMemory();
    }//delete

}//DeleterDirector
