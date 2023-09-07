package API_Testing;

import BaseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingdatesPojo;
import pojos.HerokuappExpectedDataPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Post_Pojo extends BaseUrlHerOkuApp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){
        specHerOkuApp.pathParam("pp1","booking");

        BookingdatesPojo bookingdates=new BookingdatesPojo("2021-06-01","2021-06-10");
        BookingPojo reqBody=new BookingPojo("Ali","Bak",500,false,bookingdates,"wi-fi");

        HerokuappExpectedDataPojo expData=new HerokuappExpectedDataPojo(24,reqBody);

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        HerokuappExpectedDataPojo resPojo=response.as(HerokuappExpectedDataPojo.class);

        assertEquals(expData.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        assertEquals(expData.getBooking().getLastname(),resPojo.getBooking().getLastname());
        assertEquals(expData.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        assertEquals(expData.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        assertEquals(expData.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expData.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expData.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());








    }



}