package API_Testing;

import BaseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testdatas.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_DeSerialization extends BaseUrlDummy {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.

    Response Body -Expected Data
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
    @Test
    public void get01() {

        specDummy.pathParams("pp1", "api", "pp2", "v1", "pp3", "employee", "pp4", 3);

        DummyData dummyData = new DummyData();

        HashMap<String, Object> expdata = dummyData.expDataOlustur();

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        HashMap<String, Object> resMAP = response.as(HashMap.class);

        assertEquals(dummyData.statusCode, response.statusCode());
        assertEquals(dummyData.contentType, response.contentType());
        assertEquals(expdata.get("status"), resMAP.get("status"));
        assertEquals(expdata.get("message"), resMAP.get("message"));
        //expData.get("data").get("id")

        assertEquals(((Map) (expdata.get("data"))).get("id"), ((Map) (resMAP.get("data"))).get("id"));
        assertEquals(((Map) (expdata.get("data"))).get("employee_name"), ((Map) (resMAP.get("data"))).get("employee_name"));
        assertEquals(((Map) (expdata.get("data"))).get("employee_salary"), ((Map) (resMAP.get("data"))).get("employee_salary"));
        assertEquals(((Map) (expdata.get("data"))).get("employee_age"), ((Map) (resMAP.get("data"))).get("employee_age"));
        assertEquals(((Map) (expdata.get("data"))).get("profile_image"), ((Map) (resMAP.get("data"))).get("profile_image"));


    }


}




