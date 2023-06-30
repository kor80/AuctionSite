package auction.managment.memory.builder.reader;

import auction.managment.auctions.AuctionInfo;
import auction.managment.auctions.RegistrationInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonArrayReader implements ArrayReader
{
    private JSONArray jArray;

    private final String path;

    public JsonArrayReader(String path){
        this.path = path;
    }

    @Override
    public int openMemory() {
        JSONParser parser = new JSONParser();
        File jsonFile = new File(path);
        if( !jsonFile.exists() ) return 0;

        try (FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            jArray = (JSONArray) obj;
            reader.close();
            return jArray.size();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }//openMemory

    @Override
    public RegistrationInfo readRegistration(int index) {
        JSONObject registration = (JSONObject) jArray.get(index);
        String user = (String) registration.get("user");
        int id = ((Long) registration.get("id")).intValue();
        int port = ((Long) registration.get("port")).intValue();
        String ip = (String) registration.get("ip");
        return RegistrationInfo.newBuilder().setUser(user).setArticleId(id).setUserIP(ip).setUserPort(port).build();
    }//readRegistration

    @Override
    public AuctionInfo readClosedAuction(int index) {
        JSONObject closedAuction = (JSONObject) jArray.get(index);
        int id = ((Long) closedAuction.get("id")).intValue();
        String winner = (String) closedAuction.get("winner");
        double endingPrice = (double) closedAuction.get("endingPrice");
        return AuctionInfo.newBuilder()
                .setArticleId(id)
                .setCurrentWinner(winner)
                .setCurrentOffer(endingPrice)
                .build();
    }//readClosedAuction


}//JsonArrayReader
