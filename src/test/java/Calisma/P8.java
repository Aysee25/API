package Calisma;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class P8 {
        /*
                C10_Get_ResponseBodyTestiListKullanimi
                http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
                donen Response'in
                                    status code'unun 200,
                                    ve content type'inin application/json,
                ve response body'sindeki
                                    employees sayisinin 24
                                    ve employee'lerden birinin "Ashton Cox"
                                    ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin
                                    test edin.

                                    ----------
         {
            "id": 3,
            "employee_name": "Ashton Cox",
            "employee_salary": 86000,
            "employee_age": 66,
            "profile_image": ""
        },
         */

    @Test
    public void test08(){
        Response response=given().when().get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data[2].id",hasSize(3))
                .body("data[2].employee_name",hasItem("Ashton Cox"))
                .body("data[2].employee_age",hasItems(66,21,35));






    }



    }
