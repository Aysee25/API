package API_Testing;

import BaseUrl.BaseUrl_JSONHolder;
import pojos.JsonPlacePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Put_PojoClass extends BaseUrl_JSONHolder {
    /*
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body'e sahip bir PUT request yolladigimizda donen response'in
 response body'sinin asagida verilen ile ayni oldugunu test ediniz

 Request Body

{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}

Expected Body

{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
 */
    @Test
    public void put01() {
        specJSONHolder.pathParams("pp1","posts","pp2",70);

        JsonPlacePojo reqBody =new JsonPlacePojo("Ahmet","Merhaba",10,70);

        JsonPlacePojo expData=new JsonPlacePojo("Ahmet","Merhaba",10,70);

        Response response=given().spec(specJSONHolder).contentType(ContentType.JSON)
                .when().body(reqBody).put("/{pp1}/{pp2}");

        JsonPlacePojo resPojo=response.as(JsonPlacePojo.class);

        assertEquals(expData.getTitle(),resPojo.getTitle());
        assertEquals(expData.getBody(),resPojo.getBody());
        assertEquals(expData.getId(),resPojo.getId());
        assertEquals(expData.getUserId(),resPojo.getUserId());
    }


}
