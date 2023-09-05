package Calisma;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P9 {
     /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
    request gonderdigimizde
    {
                “firstname” : “Ahmet”,
                “lastname” : “Bulut”,
                “totalprice” : 500,
                “depositpaid” : false,
                “bookingdates” : {
                                            “checkin” : “2021-06-01”,
                                            “checkout” : “2021-06-10”
                                              },
                “additionalneeds” : “wi-fi”
    }
    donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                “firstname”in,“Ahmet”,
                ve “lastname”in, “Bulut”,
                ve “totalprice”in,500,
                ve “depositpaid”in,false,
                ve “checkin” tarihinin 2021-06-01 ve
                “checkout” tarihinin 2021-06-10 ve
                “additionalneeds”in,“wi-fi” olduğunu test edin (edited)
         */

    @Test
    public void test09(){
        String url=" https://restful-booker.herokuapp.com/booking";

        JSONObject icJson=new JSONObject();
        icJson.put("checkin","2021-06-01");
        icJson.put("checkout","2021-06-10");

        JSONObject disJson=new JSONObject();
        disJson.put("firstname","Ahmet");
        disJson.put("lastname","Bulut");
        disJson.put("totalprice" ,500);
        disJson.put("depositpaid",false);
        disJson.put("bookingdates",icJson);
        disJson.put("additionalneeds","wi-fi");

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(disJson.toString()).post(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));

    }

}
