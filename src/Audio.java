import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Audio {
    private String name;
    private double speed = 1.0;
    private List<Note> bookmarks = new ArrayList<>();
    public Boolean playing = false;
    public String atTime = "0:0:0";
    private String location;


    public Audio(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public List<Note> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Note> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
