import java.awt.*;

public class Profile {
    long profileID;
    String profileName;
    Color profileColor;
    int sessionTimeInMins;
    int breakTimeInMins;
    int longBreakTimeInMins;
    AlarmSound alarmSound;

    Profile(String profileName, Color profileColor, int sessionTimeInMins, int breakTimeInMins, int longBreakTimeInMins){

    }

    public Profile(String profileName, Color profileColor, int sessionTimeInMins, int breakTimeInMins, int longBreakTimeInMins, AlarmSound alarmSound) {
        this.profileName = profileName;
        this.profileColor = profileColor;
        this.sessionTimeInMins = sessionTimeInMins;
        this.breakTimeInMins = breakTimeInMins;
//        this.longBreakTimeInMins = longBreakTimeInMins;
        this.alarmSound = alarmSound;
    }

    public Profile() {
        this.profileName = "Default";
        this.profileColor = Color.red;
        this.sessionTimeInMins = 25;
        this.breakTimeInMins = 5;
//        this.longBreakTimeInMins = longBreakTimeInMins;
        this.alarmSound = null;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setProfileColor(Color profileColor) {
        this.profileColor = profileColor;
    }

    public void setSessionTimeInMins(int sessionTimeInMins) {
        this.sessionTimeInMins = sessionTimeInMins;
    }

    public void setBreakTimeInMins(int breakTimeInMins) {
        this.breakTimeInMins = breakTimeInMins;
    }
//TODO Long Break Time integration
//    public void setLongBreakTimeInMins(int longBreakTimeInMins) {
//        this.longBreakTimeInMins = longBreakTimeInMins;
//    }

    public void setAlarmSound(AlarmSound alarmSound) {
        this.alarmSound = alarmSound;
    }

    public String getProfileName() {
        return profileName;
    }

    public Color getProfileColor() {
        return profileColor;
    }

    public int getSessionTimeInMins() {
        return sessionTimeInMins;
    }

    public int getBreakTimeInMins() {
        return breakTimeInMins;
    }

    public int getLongBreakTimeInMins() {
        return longBreakTimeInMins;
    }

    public AlarmSound getAlarmSound() {
        return alarmSound;
    }


    public static void main(String[] args) throws InterruptedException {
        Profile profile = new Profile("Work", Color.CYAN, 1, 1, 15, new AlarmSound());
        Pomodoro pomodoro = new Pomodoro(profile);
        pomodoro.startWork();
        pomodoro.startBreak();


    }
}