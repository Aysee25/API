package API_Testing;

import org.json.JSONObject;
import org.junit.Test;

public class C4_JsonObjesiOlusturma {
            /*
          Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
        “title”:“Ahmet”,
        “body”:“Merhaba”,
        “userId”:1
        }
             */
    @Test
    public void jsonObjesiOlusturma(){

        JSONObject ilkJsonObjesi=new JSONObject();
        ilkJsonObjesi.put("title","Ahmet");
        ilkJsonObjesi.put("body","Merhaba");
        ilkJsonObjesi.put("userId",1);

        System.out.println("İlk Json Oblesi :" +ilkJsonObjesi); //İlk Json Oblesi :{"title":"Ahmet","body":"Merhaba","userId":1}


    }

}
