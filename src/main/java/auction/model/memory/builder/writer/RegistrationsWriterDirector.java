package auction.model.memory.builder.writer;

import auction.model.auctions.RegistrationInfo;

/**
 * <h1>Registrations Writer Director</h1>
 * This class specifies the right instructions
 * for writing registration in the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class RegistrationsWriterDirector
{
    MemoryWriter builder;

    public RegistrationsWriterDirector(MemoryWriter builder){
        this.builder = builder;
    }

    public void save(RegistrationInfo registrations) {
        builder.openMemory();
        builder.saveUser(registrations.getUser());
        builder.saveRegistrationId(registrations.getArticleId());
        builder.saveIP(registrations.getUserIP());
        builder.savePort(registrations.getUserPort());
        builder.closeMemory();
    }//save
}//RegistrationsWriterDirector
