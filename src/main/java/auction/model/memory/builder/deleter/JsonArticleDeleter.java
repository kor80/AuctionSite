package auction.model.memory.builder.deleter;

import org.json.simple.JSONObject;

/**
 * <h1>Json Article Deleter</h1>
 * This class specifies how to delete an article
 * from a JSON database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class JsonArticleDeleter extends AbstractJSONMemoryDeleter
{
    public JsonArticleDeleter(String path){super(path);}

    @Override
    public void delete(int id) {
        for( int i=0; i< rootObjectsList.size(); i++ ){
            JSONObject jsonArticle = (JSONObject) rootObjectsList.get(i);
            JSONObject info = (JSONObject)jsonArticle.get("info");
            if( ((Long) info.get("id")).intValue() != id ) newObjectList.add(jsonArticle);
        }
    }//delete
}//JsonArticleDeleter
