package API_Testing;

import BaseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C19_BaseUrlQueryParam extends BaseUrlHerOkuApp {
     /*
    https://restful-booker.herokuapp.com/booking endpointine
    asagidaki body’ye sahip bir POST request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve
    “firstname” degerinin “Ahmet” oldugunu test edin
 {
    "firstname" : "Ahmet",
    "lastname" : “Bulut", "
    totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                    },
    "additionalneeds" : "wi-fi"
}
     */

    @Test
    public void post01(){
        //1- url ve Request Body hazırlama
        specHerOkuApp.pathParam("pp1","booking");

        JSONObject inner =new JSONObject();
        JSONObject reqbody=new JSONObject();

        inner.put("checkin" , "2021-06-01");
        inner.put("checkout","2021-06-10");

        reqbody.put("firstname" , "Ahmet");
        reqbody.put("lastname" , "Bulut");
        reqbody.put("totalprice" , 500);
        reqbody.put("depositpaid" , false);
        reqbody.put("bookingdates" , inner);
        reqbody.put("additionalneeds" , "wi-fi");

        //2-Expected Hazırlama


        //3-Response Kaydet
        Response response=given()
                .spec(specHerOkuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqbody.toString()).post("/{pp1}");


        //4-Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname", equalTo("Ahmet"));

    }

    @Test
    public void query01(){
        /*https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query   parametrelerini yazarak “firstname” degeri “Eric” olan
        rezervasyon oldugunu test   edecek bir GET request gonderdigimizde,
        donen response’un status code’unun 200  oldugunu ve “Eric” ismine sahip
        en az bir booking oldugunu test edin
*/
        //1-urlhazırlama
        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Eric");

        //2-Expected data
        //3-Response Kayıt
        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        // response.prettyPrint();

        //4-Assertion
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.notNullValue());





    }
}
