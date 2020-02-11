import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {
    long id;
    Profile profile;
    LocalDateTime dateCreated;
    LocalDateTime timeStarted;
    LocalDateTime timeEnded;
    LocalDateTime breakTimeStarted;
    LocalDateTime breakTimeEnded;


    public Pomodoro(Profile profile, LocalDateTime dateCreated) {
        this.profile = profile;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public LocalDateTime getTimeStarted() {
        return timeStarted;
    }

    public LocalDateTime getTimeEnded() {
        return timeEnded;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public void startWork() throws InterruptedException {
        this.timeStarted = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timeStarted.format(format);

        Timer timer = new Timer();
        int sessionTime = 1000 * 60 * profile.getSessionTimeInMins();


        this.timeEnded = LocalDateTime.now();

    }
    public void stopWork(){

        this.timeEnded = LocalDateTime.now();

    }
    public void startBreak() throws InterruptedException {
        this.breakTimeStarted = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timeStarted.format(format);

        Timer timer = new Timer();
        int breakTime = 1000 * 60 * profile.getBreakTimeInMins();
        timer.wait(breakTime);

        this.breakTimeEnded = LocalDateTime.now();

    }
    public void endBreak(){
        this.breakTimeEnded = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timeStarted.format(format);

        //TODO break the thread in startBreak
    }
//    public void continueWork(){
//
//
//    }
//    public void continueBreak(){
//
//    }

}


