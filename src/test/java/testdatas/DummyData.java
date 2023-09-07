package testdatas;

import java.util.HashMap;

public class DummyData {
    public int statusCode=200;
    public String contentType="application/json";
    /*
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
    public HashMap dataBodyolustur(){
        HashMap<String,Object> data=new HashMap<>();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        return data;

    }
    public HashMap expDataOlustur(){
        HashMap<String,Object> expbody=new HashMap<>();
        expbody.put("status","success");
        expbody.put("data",dataBodyolustur());
        expbody.put("message","Successfully! Record has been fetched.");
        return expbody;

    }

}
