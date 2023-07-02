package auction.model.memory.builder.deleter;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>Abstract JSON Memory Deleter</h1>
 * This class specifies the opening and closing
 * operation when deleting an object from the JSON database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public abstract class AbstractJSONMemoryDeleter implements MemoryDeleter
{
    protected JSONArray rootObjectsList;

    private final String path;

    protected AbstractJSONMemoryDeleter(String path){this.path = path;}

    @Override
    public void openMemory() {
        File json = new File(path);
        if( !json.exists() ) return;
        try {
            FileReader fr = new FileReader(path);
            JSONParser parser = new JSONParser();
            rootObjectsList = (JSONArray) parser.parse(fr);
            fr.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }//openMemory

    @Override
    public void closeMemory() {
        try {
            File f = new File(path);
            f.delete();
            FileWriter fw = new FileWriter(path);
            fw.write(rootObjectsList.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//closeMemory
}//AbstractJSONMemoryDeleter
