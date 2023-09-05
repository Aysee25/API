package API_Testing;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
Response body : (expectedData)
{
“userId”: 3,
“id”: 22,
“title”: “dolor sint quo a velit explicabo quia nam”,
“body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse”
}
     */

    @Test
    public void expectedData(){
        //1-EndPoint
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2-Expected Data Hazırlama
        JSONObject expData=new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //System.out.println("expData = " + expData);

        //3-Response kaydetme
        Response response=given().when().get(url);

        // Karsılastırma islemi yapabilmek icin kodlarımıza response verilerini okutmamız gerekir
        //Bunun icin response'la donen verileri okuyacak bir obje olustururuz
        //Bunu da JsonPath ile yapabiliriz
        JsonPath resJP=response.jsonPath();
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("body"),resJP.get("body"));









    }


}
