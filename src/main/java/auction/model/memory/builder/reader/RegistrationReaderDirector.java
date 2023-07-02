package auction.model.memory.builder.reader;

import auction.model.auctions.RegistrationInfo;

import java.util.Collection;
import java.util.LinkedList;

/**
 * <h1>Registration Reader Director</h1>
 * This class specifies the right instructions
 * for reading a registration from the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class RegistrationReaderDirector
{
    private ArrayReader builder;

    public RegistrationReaderDirector(ArrayReader builder){
        this.builder = builder;
    }

    public Collection<RegistrationInfo> buildMemory(){
        LinkedList<RegistrationInfo> ret = new LinkedList<>();
        int numRegistrations = builder.openMemory();
        for( int i=0; i<numRegistrations; i++){
            ret.add(builder.readRegistration(i));
        }
        return ret;
    }//buildMemory
}//RegistrationReaderDirector
