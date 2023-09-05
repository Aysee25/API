package API_Testing;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir
    POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
    Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
 "additionalneeds" : "wi-fi"
   }

Response Body
{
    "bookingid": 24,
"booking": { "firstname": "Ahmet",
                    "lastname": "Bulut",
                    "totalprice": 500,
                    "depositpaid": false,
                    "bookingdates": {
                                                "checkin": "2021-06-01",
                                                "checkout": "2021-06-10"
                                            },
"additionalneeds": "wi-fi" }
}


     */

    @Test
    public void expected01(){
        //1-endpoint
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject inner=new JSONObject();
        inner.put("checkin" ,"2021-06-01");
        inner.put("checkout" ,"2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", inner);
        reqBody.put("additionalneeds", "wi-fi");

        // 2-expected data
        JSONObject expData=new JSONObject();
        expData.put("firstname", "Ahmet");
        expData.put("lastname", "Bulut");
        expData.put("totalprice", 500);
        expData.put("depositpaid", false);
        expData.put("bookingdates", inner);
        expData.put("additionalneeds", "wi-fi");

        //3-Response kaydetme
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString()).post(url);

        //response.prettyPrint();
       // response.prettyPeek();

        // 4-Assertion islemi

        JsonPath resJP=response.jsonPath();
       Assert.assertEquals(expData.get("firstname"),resJP.get("booking.firstname"));
        Assert.assertEquals(expData.get("lastname"),resJP.get("booking.lastname"));
        Assert.assertEquals(expData.get("totalprice"),resJP.get("booking.totalprice"));
        Assert.assertEquals(expData.get("depositpaid"),resJP.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));





    }
}
