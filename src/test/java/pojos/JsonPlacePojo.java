package pojos;

public class JsonPlacePojo {
    /*
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}

 */
    // 1- Obje icindeki tum variable'ları private olarak olusturturduk
    private  String title;
    private String body;
    private int userId;
    private int id;

    // 2- Variabllar için getter ve setter oluşturduk
    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public int getUserId() {return userId;}

    public void setUserId(int userID) {this.userId = userId;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    // 3- Parametreli Constructor oluşturduk.
    public JsonPlacePojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4 - Parametresiz Constructor oluşturduk
    public JsonPlacePojo(){

    }
    // 5- toString () metdhodu oluşturalım

    @Override
    public String toString() {
        return "JsonPlacePojo{" +
                "title='" + title + '\'' + //{title='Ahmet', body='Merhaba'........}
                ", body='" + body + '\'' +
                ", userID=" + userId +
                ", id=" + id +
                '}';
    }

}
