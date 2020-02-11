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
        this.longBreakTimeInMins = longBreakTimeInMins;
        this.alarmSound = alarmSound;
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

    public void setLongBreakTimeInMins(int longBreakTimeInMins) {
        this.longBreakTimeInMins = longBreakTimeInMins;
    }

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
}
