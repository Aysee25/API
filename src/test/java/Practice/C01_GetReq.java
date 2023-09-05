package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetReq {
   @Test
    public void test01(){
         /*
        url : https://reqres.in/api/users/
        get request
        dönrn response yazdırın
         */

       // api'den dönen cevap response objesi icine kaydolur
       Response response=given().when().get("url : https://reqres.in/api/users/");

       //api den donen cevabı yazdıralım
       response.prettyPrint();




   }
}
