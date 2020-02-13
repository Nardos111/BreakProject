import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.io.*;
public class Pomodoro {
    String id;
    Profile profile;
    LocalDateTime dateCreated;
    LocalDateTime timeStarted;
    LocalDateTime timeEnded;
    LocalDateTime breakTimeStarted;
    LocalDateTime breakTimeEnded;
    Timer timer = new Timer();
    TimerTask task = new WorkHelper(this);
    TimerTask taskBreak = new BreakHelper(this);


    public Pomodoro(Profile profile) {
        this.id = UUID.randomUUID().toString();
        this.profile = profile;
        this.dateCreated = LocalDateTime.now();
    }

    public String getId() {
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getBreakTimeStarted() {
        return breakTimeStarted;
    }

    public LocalDateTime getBreakTimeEnded() {
        return breakTimeEnded;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void startWork() throws InterruptedException {
        this.timeStarted = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timeStarted.format(format);
        int sessionTime = 1000 * 60 * profile.getSessionTimeInMins();
        timer.schedule(task, sessionTime);


    }

    public void stopWork() {
        timer.cancel();
        this.timeEnded = LocalDateTime.now();

    }

    public void startBreak() throws InterruptedException {
        this.breakTimeStarted = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timeStarted.format(format);
        int breakTime = 1000 * 60 * profile.getBreakTimeInMins();
        timer.schedule(taskBreak, breakTime);

    }

    public void endBreak() {
        timer.cancel();
        this.breakTimeEnded = LocalDateTime.now();
    }


//    public void continueWork(){
//
//
//    }
//    public void continueBreak(){
//
//    }

}

class WorkHelper extends TimerTask {
    Pomodoro pomodoro;

    @Override
    public void run() {
        pomodoro.timeEnded = LocalDateTime.now();

    }

    WorkHelper(Pomodoro p) {
        this.pomodoro = p;
    }
}

class BreakHelper extends TimerTask {
    Pomodoro pomodoro;

    @Override
    public void run() {
        pomodoro.breakTimeEnded = LocalDateTime.now();
    }

    public BreakHelper(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }
}


