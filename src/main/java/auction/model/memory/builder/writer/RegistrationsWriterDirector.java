package auction.model.memory.builder.writer;

import auction.model.auctions.RegistrationInfo;

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
