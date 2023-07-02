package auction.model.memory.builder.reader;

import auction.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * <h1>Json Reader</h1>
 * This class specializes the instructions
 * used to read an Article in the Json database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class JsonReader implements MemoryReader
{
    private LinkedList<Article> ret;

    private JSONArray articles;
    private JSONObject currentArticle;
    private JSONObject currentInfo;

    private Article.Builder articleBuilder;
    private ArticleInfo.Builder infoBuilder;

    private final String path;

    public JsonReader(String path){
        this.path = path;
        ret = new LinkedList<>();
    }

    @Override
    public int openMemory() {
        JSONParser parser = new JSONParser();
        File jsonFile = new File(path);
        if( !jsonFile.exists() ) return 0;

        try (FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            articles = (JSONArray) obj;
            reader.close();
            return articles.size();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }//openMemory

    @Override
    public void openArticle(int articleIndex){
        currentArticle = (JSONObject) articles.get(articleIndex);
        articleBuilder = Article.newBuilder();
    }//openArticle

    @Override
    public void readUser() {
        articleBuilder.setUser( (String) currentArticle.get("user") );
    }//readUser

    @Override
    public void addInfo() {
        infoBuilder = ArticleInfo.newBuilder();
        currentInfo = (JSONObject) currentArticle.get("info");
    }//addInfo

    @Override
    public void readName() {
        infoBuilder.setName( (String) currentInfo.get("name"));
    }//readName

    @Override
    public void readStartingDate() {
        JSONObject jsonStartingDate = (JSONObject) currentInfo.get("startingDate");
        Date startingDate = Date.newBuilder().setYear( ((Long) jsonStartingDate.get("year")).intValue() )
                .setMonth( ((Long) jsonStartingDate.get("month")).intValue() )
                .setDay( ((Long) jsonStartingDate.get("day")).intValue() )
                .build();
        infoBuilder.setStartingDate(startingDate);
    }//readStartingDate

    @Override
    public void readEndingDate() {
        JSONObject jsonEndingDate = (JSONObject) currentInfo.get("endingDate");
        Date endingDate = Date.newBuilder().setYear( ((Long) jsonEndingDate.get("year")).intValue() )
                .setMonth( ((Long) jsonEndingDate.get("month")).intValue() )
                .setDay( ((Long) jsonEndingDate.get("day")).intValue() )
                .build();
        infoBuilder.setEndingDate(endingDate);
    }//readEndingDate

    @Override
    public void readStartingTime() {
        JSONObject jsonStartingTime = (JSONObject) currentInfo.get("startingTime");
        Time startingTime = Time.newBuilder().setHour( ((Long) jsonStartingTime.get("hour")).intValue() )
                .setMinutes( ((Long) jsonStartingTime.get("minutes")).intValue() )
                .build();
        infoBuilder.setStartingTime(startingTime);
    }//readStartingTime

    @Override
    public void readEndingTime() {
        JSONObject jsonEndingTime = (JSONObject) currentInfo.get("endingTime");
        Time endingTime = Time.newBuilder().setHour( ((Long) jsonEndingTime.get("hour")).intValue() )
                .setMinutes( ((Long) jsonEndingTime.get("minutes")).intValue() )
                .build();
        infoBuilder.setEndingTime(endingTime);
    }//readEndingTime

    @Override
    public void readStartingPrice() {
        infoBuilder.setStartingPrice( (double) currentInfo.get("startingPrice"));
    }//readStartingPrice

    @Override
    public void readBuyNowPrice(){
        infoBuilder.setBuyNowPrice( (double) currentInfo.get("buyNowPrice"));
    }//readBuyNowPrice

    @Override
    public void readType() {
        infoBuilder.setType(ArticleType.forNumber( ((Long) currentInfo.get("type")).intValue() ));
    }//readType

    @Override
    public void readDescription() {
        infoBuilder.setDescription( (String) currentInfo.get("description"));
    }//readDescription

    @Override
    public void readId(){
        infoBuilder.setId( ((Long) currentInfo.get("id")).intValue() );
    }//readId

    @Override
    public void readWinner(){ infoBuilder.setWinner( (String) currentInfo.get("winner")); }//readWinner

    @Override
    public void readEndingPrice() {
        infoBuilder.setEndingPrice( (double) currentInfo.get("endingPrice"));
    }//readStartingPrice

    @Override
    public void closeArticle() {
        Article article = articleBuilder.setInfo(infoBuilder.build()).build();
        ret.add(article);
    }//closeArticle

    @Override
    public Collection<Article> getArticles(){
        return ret;
    }//getArticles
}//JsonReader
