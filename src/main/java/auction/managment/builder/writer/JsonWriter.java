package auction.managment.builder.writer;

import auction.managment.ArticleType;
import auction.managment.Date;
import auction.managment.Time;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonWriter implements MemoryWriter
{
    private JSONParser parser;
    private JSONArray articlesList;
    private JSONObject jArticle;
    private JSONObject info;

    private final String path;

    public JsonWriter(String path){ this.path=path;}

    @Override
    public void openMemory() {
        jArticle = new JSONObject();
        File json = new File(path);
        if( !json.exists() ) createFile(path);
        else openFile(path);
    }//openMemory

    private void createFile(String path){
        try {
            FileWriter fw = new FileWriter(path);
            articlesList = new JSONArray();
            fw.write(articlesList.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//createFile

    private void openFile(String path){
        try {
            FileReader fr = new FileReader(path);
            parser = new JSONParser();
            Object obj = parser.parse(fr);
            articlesList = (JSONArray) obj;
            fr.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }//openFile

    @Override
    public void saveUser(String user) {
        jArticle.put("user",user);
    }//saveUser

    @Override
    public void addInfo() {
        info = new JSONObject();
        jArticle.put("info",info);
    }//addInfo

    @Override
    public void saveName(String name) {
        info.put("name",name);
    }//saveName

    @Override
    public void saveStartingDate(Date date) {
        JSONObject startingDate = new JSONObject();
        startingDate.put("year",date.getYear());
        startingDate.put("month",date.getMonth());
        startingDate.put("day",date.getDay());
        info.put("startingDate",startingDate);
    }//saveStartingDate

    @Override
    public void saveEndingDate(Date date) {
        JSONObject endingDate = new JSONObject();
        endingDate.put("year",date.getYear());
        endingDate.put("month",date.getMonth());
        endingDate.put("day",date.getDay());
        info.put("endingDate",endingDate);
    }//saveEndingDate

    @Override
    public void saveStartingTime(Time time) {
        JSONObject startingTime = new JSONObject();
        startingTime.put("hour",time.getHour());
        startingTime.put("minutes",time.getMinutes());
        info.put("startingTime",startingTime);
    }//saveStartingTime

    @Override
    public void saveEndingTime(Time time) {
        JSONObject endingTime = new JSONObject();
        endingTime.put("hour",time.getHour());
        endingTime.put("minutes",time.getMinutes());
        info.put("endingTime",endingTime);
    }//saveEndingTime

    @Override
    public void saveStartingPrice(double price) {
        info.put("startingPrice",price);
    }//saveStartingPrice

    @Override
    public void saveBuyNowPrice( double price ){ info.put("buyNowPrice",price);}//saveBuyNowPrice

    @Override
    public void saveType(ArticleType type) {
        info.put("type",type.getNumber());
    }//saveType

    @Override
    public void saveDescription(String description) {
        info.put("description",description);
    }//saveDescription

    @Override
    public void saveId(int id){ info.put("id",id); }//saveId

    @Override
    public void closeMemory() {
        articlesList.add(jArticle);
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(articlesList.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//closeMemory
}
