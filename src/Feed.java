import java.util.*;

public class Feed {
    private long FeedId;
    private String feedTitle;
    private Date dateCreated;
    private List<Sources> listOfSources;

    public Feed(long FeedId, String feedTitle, Date dateCreated, List<Sources> listOfSources){
        this.FeedId = FeedId;
        this.feedTitle = feedTitle;
        this.dateCreated = dateCreated;
        this.listOfSources = new ArrayList<>();
    }

    public void addContents(Sources s){

    }
    public void markAsRead(Article a){

    }

    public void rename(String n){

    }
    public void sort(){

    }
    public List<Article> filter(Sources s){
        return new ArrayList<>();
    }
    public long getFeedId(){
        return FeedId;
    }
    public String getFeedTitle(){
        return feedTitle;
    }
    public Date getDateCreated(){
        return dateCreated;
    }

    public List<Sources> getListOfSources(){
        return listOfSources;
    }
}
