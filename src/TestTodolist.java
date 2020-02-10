import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TestTodolist {
    private Connection myConn;

    public void addToDatabase(){
        String user = "root";
        String password = "toortoor";
        String dburl = "jdbc:mysql://localhost:3306/menagerie";

        // connect to database
        try {
            myConn = DriverManager.getConnection(dburl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("DB connection successful to: " + dburl);
    }
    public static void main(String[] args) {
        ArrayList<Project> projects = new ArrayList<>();

        Project school = new Project("School", 1234L, Color.BLUE);
        Project chores = new Project("Chores", 1235L, Color.RED);

        projects.add(school);
        projects.add(chores);


        Task homework = new Task("S01","homework", new Date(), new Date(), false, 1, "");
        Task assignment = new Task("S02","assignment", new Date(), new Date(), false, 1, "");
        Task thesis = new Task("S03","thesis", new Date(), new Date(), false, 1, "");
        Task project = new Task("S04","project", new Date(), new Date(), false, 1, "");
        Task presentation = new Task("S05","presentation", new Date(), new Date(), false, 1, "");

        school.addTask(homework);
        school.addTask(assignment);
        school.addTask(thesis);
        school.addTask(project);
        school.addTask(presentation);

        Task washclothe = new Task("C01","washclothe", new Date(), new Date(), false, 1, "");
        Task makebed = new Task("C01","makebed", new Date(), new Date(), false, 1, "");
        Task foldclothe = new Task("S01","foldclothe", new Date(), new Date(), false, 1, "");

        chores.addTask(washclothe);
        chores.addTask(makebed);
        chores.addTask(foldclothe);

        for(Project p : projects){
            System.out.println("Project: " + p.getName());
            for(Task t : p.getTasks()){
                System.out.println("\t " + t.getName());
            }
        }

    }
}