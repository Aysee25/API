package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.runner.Request;
import org.testng.annotations.BeforeTest;

public class BaseUrl_JSONHolder {

    //BaseURL oluştururken RequestSpecification interfac'inden bir specobje oluşturdurk
    protected RequestSpecification specJSONHolder;

    @Before
    public void setUp(){
        specJSONHolder =new RequestSpecBuilder()
                                .setBaseUri("https://jsonplaceholder.typicode.com")
                                .build();



    }



}
