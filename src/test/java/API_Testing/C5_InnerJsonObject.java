package API_Testing;

import org.json.JSONObject;
import org.junit.Test;

public class C5_InnerJsonObject {
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
    public void innerJson() {
        // Ic ice JSON objeleri iceren bir body de once icerdeki JSON objesi olusturulur. -->"innerObje"
        JSONObject innerOjje = new JSONObject();
        innerOjje.put("checkin", "2018-01-01");
        innerOjje.put("checkout", "2019-01-01");

        //Ana JSON objesi olustururken Key Value degerleri yazılır. -->"outerObje"
        // İcinde  inner olan key'in value degeri  innerObje olacaktır. -->" outerObje.put("bookingdates", innerOjje);"
        JSONObject outerObje = new JSONObject();
        outerObje.put("firstname", "Jim");
        outerObje.put("additionalneeds", "Breakfast");
        outerObje.put("bookingdates", innerOjje);
        outerObje.put("totalprice", 111);
        outerObje.put("depositpaid", true);
        outerObje.put("lastname", "Brown");


        System.out.println("İc ice Json Objesi = " + outerObje);
        // İc ice Json Objesi = {"firstname":"Jim","additionalneeds":"Breakfast","bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"totalprice":111,"depositpaid":true,"lastname":"Brown"}


    }


}
