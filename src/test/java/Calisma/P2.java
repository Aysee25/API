package Calisma;

import org.json.JSONObject;
import org.junit.Test;

public class P2 {
            /*
          Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
        “title”:“Ahmet”,
        “body”:“Merhaba”,
        “userId”:1
        }
             */

    @Test
    public void test01(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println("jsonObject = " + jsonObject);
        //jsonObject = {"title":"Ahmet","body":"Merhaba","userId":1}

    }



}
