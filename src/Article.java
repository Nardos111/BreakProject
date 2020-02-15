import java.util.Date;

public class Article {
    private String header;
    private Sources Source;
    private Date publishedDate;

    public Article(String header, Sources Source, Date publishedDate){
        this.header = header;
        this.Source = Source;
        this.publishedDate = publishedDate;
    }

    public void share(String e){

    }

    public void addToFavorite(){

    }
}
