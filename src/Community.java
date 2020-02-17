import java.util.List;

public class Community {
    private String title;
    private long id;
    private String description;
    private List<Forum> listOfForums;

    public Community(String title, long id, String description, List<Forum> listOfForums) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.listOfForums = listOfForums;
    }

    public void addForum(Forum f){

    }

    public void removeForum(Forum f){
        
    }
}
