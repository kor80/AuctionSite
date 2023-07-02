package auction.model.memory.builder.deleter;

import org.json.simple.JSONObject;

public class JsonArticleDeleter extends AbstractMemoryDeleter
{
    public JsonArticleDeleter(String path){super(path);}

    @Override
    public void delete(int id) {
        for( int i=0; i< rootObjectsList.size(); i++ ){
            JSONObject jsonArticle = (JSONObject) rootObjectsList.get(i);
            JSONObject info = (JSONObject)jsonArticle.get("info");
            if( ((Long) info.get("id")).intValue() == id ) rootObjectsList.remove(i);
        }
    }//delete
}//JsonArticleDeleter
