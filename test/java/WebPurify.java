import addToBlack.json.purify.com.AddToBlackMethodJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import check.json.purify.com.CheckMethodJson;
import removeFromBlack.json.purify.com.RemoveFromBlackMethodJson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebPurify {

    CheckMethodJson checkMethodJson;
    AddToBlackMethodJson addToBlackMethodJson;
    RemoveFromBlackMethodJson removeFromBlackMethodJson;
    String baseURL = "http://api1.webpurify.com/services/rest/?api_key=b555c4f514d7762282382990c5921e9d";
    URL jsonURL;
    ObjectMapper mapper;


    public  WebPurify()
    {
        checkMethodJson = new CheckMethodJson();
        mapper =new ObjectMapper();
    }

    public boolean Check(String text) throws IOException
    {
        text=text.replaceAll("\\s", "%20");
        jsonURL = new URL(baseURL+"&method=webpurify.live.check"+"&text="+text+"&format=json");
        checkMethodJson = mapper.readValue(jsonURL, CheckMethodJson.class);

        return checkMethodJson.getRsp().getFound().contains("1");

    }

    public boolean AddToBlack(String word) throws IOException {
        word=word.replaceAll("\\s", "%20");
        jsonURL = new URL(baseURL+"&method=webpurify.live.addtoblacklist"+"&word="+word+"&format=json");
        addToBlackMethodJson = mapper.readValue(jsonURL, AddToBlackMethodJson.class);

        return addToBlackMethodJson.getRsp().getSuccess().contains("1");
    }

    public boolean RemoveFromBlack(String word) throws IOException {
        word=word.replaceAll("\\s", "%20");
        jsonURL = new URL(baseURL+"&method=webpurify.live.removefromblacklist"+"&word="+word+"&format=json");
        removeFromBlackMethodJson = mapper.readValue(jsonURL, RemoveFromBlackMethodJson.class);

        return removeFromBlackMethodJson.getRsp().getSuccess().contains("1");
    }



}
