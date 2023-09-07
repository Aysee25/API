package testdatas;

import org.json.JSONObject;

import java.util.HashMap;

public class JSONPlaceData {
    public int basariliStatsuCode = 200;
    public String contentType = "application/json; charset=utf-8";
    public String header = "keep-alive";


    public JSONObject expectedBodyOlusturJSON() {
        JSONObject expData = new JSONObject();

        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear" +
                "um mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        return expData;

    }

    public JSONObject requestBodyOlusturJSON() {


    /*
    {
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
     */

        JSONObject reqbody = new JSONObject();
        reqbody.put("title", "Ahmet");
        reqbody.put("body", "Merhaba");
        reqbody.put("userId", 10.0);
        reqbody.put("id", 70);

        return reqbody;
    }

    public HashMap reqBodyOlusturMAP() {

        HashMap<String, Object> reqbody = new HashMap<>();
        reqbody.put("title", "Ahmet");
        reqbody.put("body", "Merhaba");
        reqbody.put("userId", 10.0);
        reqbody.put("id", 70.0);

        return reqbody;

    }
}
