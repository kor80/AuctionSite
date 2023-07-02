package auction.model.memory.builder.deleter;

import org.json.simple.JSONObject;

public class JsonRegistrationDeleter extends AbstractMemoryDeleter
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
