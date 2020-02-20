import java.time.LocalDateTime;
import java.util.UUID;

public class Pomodoro {
    String id;
    Profile profile;
    LocalDateTime dateCreated;
    LocalDateTime timeStarted;
    LocalDateTime timeEnded;
    LocalDateTime breakTimeStarted;
    LocalDateTime breakTimeEnded;



    public Pomodoro(Profile profile) {
        this.id = UUID.randomUUID().toString();
        this.profile = profile;
        this.dateCreated = LocalDateTime.now();
    }

    public Pomodoro() {
        this.id = UUID.randomUUID().toString();
        this.profile = new Profile();
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


}

