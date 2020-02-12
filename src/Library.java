import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Note> audiosList;

    public Library(){
        audiosList = new ArrayList<>();
    }

    public void addAudio(String title, String note, String time){
        audiosList.add(new Note(title, note, time ));
    }
    public void display(){
        // TODO: implement display method for library
    }


}
