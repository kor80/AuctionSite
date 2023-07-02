package auction.model.memory.builder.deleter;

import org.json.simple.JSONObject;

/**
 * <h1>Json Registration Deleter</h1>
 * This class specifies how to delete a registration
 * from a JSON database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class JsonRegistrationDeleter extends AbstractJSONMemoryDeleter
{
    public JsonRegistrationDeleter(String path){super(path);}

    @Override
    public void delete(int id) {
        for( int i=0; i< rootObjectsList.size(); i++ ){
            JSONObject jsonRegistration = (JSONObject) rootObjectsList.get(i);
            if( ((Long) jsonRegistration.get("id")).intValue() == id ) rootObjectsList.remove(i);
        }
    }//delete
}//MemoryDeleter
