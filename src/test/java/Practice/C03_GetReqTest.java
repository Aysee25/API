package Practice;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C03_GetReqTest {
    @Test
    public void test03(){
        /*
          get request
        url: https://reqres.in/api/users/1
        şunları test edin:
                                Status code : 200
                                The content type : application/json; Charset=utf-8
                                email : george.bluth@reqres.in
                                first_name : George
                                last_name : Bluth
                                 avatar : https://reqres.in/img/faces/1-image.jpg
                                 url : https://reqres.in/#support-heading
                                 text : To keep ReqRes free, contributions towards server costs are appreciated!
           */

        Response response=given().when().get("https://reqres.in/api/users/1");
        response.prettyPrint();
        /*
        {
    "data": {
        "id": 1,
        "email": "george.bluth@reqres.in",
        "first_name": "George",
        "last_name": "Bluth",
        "avatar": "https://reqres.in/img/faces/1-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}

         */
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; Charset=utf-8")
                .body("data.email", equalTo("george.bluth@reqres.in"),
                            "data.first_name",equalTo("George"),
                            "data.last_name",equalTo("Bluth"),
                            "data.avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"),
                            "support.url",equalTo("https://reqres.in/#support-heading"),
                            "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
