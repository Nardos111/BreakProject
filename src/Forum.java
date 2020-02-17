import java.util.ArrayList;
import java.util.List;

public class Forum {
    private String title;
    private long id;
    private String description;
    private List<String> comments;

    Forum(String title, long id, String description, List<String> comments){
        this.title = title;
        this.id = id;
        this.description = description;
        this.comments = new ArrayList<String>();
    }

    public void method(){}

}
