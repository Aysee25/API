package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetReqTest {
    @Test
    public void test02(){
        /*
         get request
        url :  https://reqres.in/api/users/2
        test edilecekler :
                                status code : 200
                                The content type : application/json; charset=utf-8
                                Server isimli header : cloudflare
                                status line : HTTP/1.1 200 OK
         */

        Response response=given().when().get("https://reqres.in/api/users/2");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");




    }
}
