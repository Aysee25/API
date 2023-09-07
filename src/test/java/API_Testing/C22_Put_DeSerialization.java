package API_Testing;

import BaseUrl.BaseUrl_JSONHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testdatas.JSONPlaceData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends BaseUrl_JSONHolder {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
   body’e sahip bir PUT request yolladigimizda donen response’in
   response body’sinin asagida verilen ile ayni oldugunu test ediniz

   Request Body

       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }

   Expected Data :

       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
    */
    @Test
    public void put01(){
        //1 - Url ve Request Body Hazırlama

        specJSONHolder.pathParams("pp1","posts","pp2",70);
        JSONPlaceData jsonplacedata= new JSONPlaceData();
        HashMap<String,Object> reqData=jsonplacedata.reqBodyOlusturMAP();

        HashMap<String,Object> expdata=jsonplacedata.reqBodyOlusturMAP();

        Response response=given()
                .spec(specJSONHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(reqData).put("/{pp1}/{pp2}");

        //response.prettyPrint();

        HashMap<String,Object> resMAP=response.as(HashMap.class);

        assertEquals(expdata.get("title"),resMAP.get("title"));
        assertEquals(expdata.get("body"),resMAP.get("body"));
        assertEquals(expdata.get("userId"),resMAP.get("userId"));
        assertEquals(expdata.get("id"),resMAP.get("id"));








    }
}
