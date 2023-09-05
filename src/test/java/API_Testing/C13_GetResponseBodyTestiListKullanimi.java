package API_Testing;


import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_GetResponseBodyTestiListKullanimi {
       /*
               http://dummy.restapiexample.com/api/v1/employees url’ine bir GET request yolladigimizda
donen Response’in
status code’unun 200,
ve content type’inin Aplication.JSON, ve response body’sindeki
employees sayisinin 24
ve employee’lerden birinin “Ashton Cox”
	ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin test edin.
         */
    @Test
    public void listKullanimi(){
        //1-Endpoint hazırlama
        String url="http://dummy.restapiexample.com/api/v1/employees";
        Response response=given().when().get(url);
        response.prettyPrint();
        // Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id",hasSize(24))
                .body("data.employee_name",hasItem("Ashton Cox"))
                .body("data.employee_age",hasItems(66,21,35));
    }
}
