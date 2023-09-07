package API_Testing;

import BaseUrl.BaseUrl_JSONHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testdatas.JSONPlaceData;

import static io.restassured.RestAssured.given;
public class C20_Get_TestDataClassKullanimi extends BaseUrl_JSONHolder {
/*

https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response’in status kodunun 200 ve response body’sinin
asagida verilen ile ayni oldugunutest ediniz
Response body :(Expected Data)
   {
     "userId": 3,
     "id": 22,
     "title": "dolor sint quo a velit explicabo quia nam",
     "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
  }
     */

    @Test
    public void testdata01(){
        //1- url hazırlama

        specJSONHolder.pathParams("pp1","posts","pp2",22);


        //2- Expected data

        JSONPlaceData JsonPlaceData=new JSONPlaceData();
        JSONObject expData=JsonPlaceData.expectedBodyOlusturJSON();

        //3-Response Kaydetme
        Response response=given().spec(specJSONHolder).when().get("/{pp1}/{pp2}");

        //4-Assertion

        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expData.get("id"),resJP.get("id"));
        Assert.assertEquals(expData.get("title"),resJP.get("title"));
        Assert.assertEquals(expData.get("body"),resJP.get("body"));








    }



}
