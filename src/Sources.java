import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sources {
    private String sourceTitle;
    private String websiteURL;
    private String category;
    private List<Article> listOfArticles;

    public Sources(){
        this.sourceTitle = "Empty Title";
        this.websiteURL = "Empty Website";
        this.category = "None";
        this.listOfArticles = new ArrayList<>();
    }

    public Sources(String sourceTitle, String websiteURL, String category, List<Article> listOfArticles){
        this.sourceTitle = sourceTitle;
        this.websiteURL = websiteURL;
        this.category = category;
        this.listOfArticles = new ArrayList<>();
    }
    public String getSourceTitle(){
        return sourceTitle;
    }
    public void refresh(){}
    public String getWebsiteURL(){
        return websiteURL;
    }
    public List<Article> getListOfArticle(){
        return listOfArticles;
    }
    public String getCategory(){
        return category;
    }
}
