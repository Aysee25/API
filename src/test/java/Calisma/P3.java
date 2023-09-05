package Calisma;

import org.json.JSONObject;
import org.junit.Test;

public class P3 {
        /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        “firstname”:“Jim”,
        “additionalneeds”:“Breakfast”,
        “bookingdates”:{
                                    “checkin”:“2018-01-01”,
                                    “checkout”:“2019-01-01”
                                     },
    “totalprice”:111,
    “depositpaid”:true,
    “lastname”:“Brown”
    }
     */
    @Test
    public void test03(){
        JSONObject ilkJson=new JSONObject();
        ilkJson.put("checkin","2018-01-01");
        ilkJson.put("checkout","2019-01-01");

        JSONObject ikinciJson=new JSONObject();
        ikinciJson.put("firstname","Jim");
        ikinciJson.put("additionalneeds","Breakfast");
        ikinciJson.put("bookingdates",ilkJson);
        ikinciJson.put("totalprice",111);
        ikinciJson.put("depositpaid",true);
        ikinciJson.put("lastname","Brown");

        System.out.println("ikinciJson = " + ikinciJson);
        //ikinciJson = {"firstname":"Jim","additionalneeds":"Breakfast","bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"totalprice":111,"depositpaid":true,"lastname":"Brown"}






    }
}
