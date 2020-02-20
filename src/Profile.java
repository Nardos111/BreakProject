import java.awt.*;
import java.util.UUID;

public class Profile {
    String profileID;
    String profileName;
    Color profileColor;
    int sessionTimeInMins;
    int breakTimeInMins;
    int longBreakTimeInMins;
    AlarmSound alarmSound;



    public Profile(String profileName, Color profileColor, int sessionTimeInMins, int breakTimeInMins, int longBreakTimeInMins) {
        this.profileID = UUID.randomUUID().toString();
        this.profileName = profileName;
        this.profileColor = Color.getColor(String.valueOf(profileColor));
        this.sessionTimeInMins = sessionTimeInMins;
        this.breakTimeInMins = breakTimeInMins;
        this.longBreakTimeInMins = longBreakTimeInMins;
    }

    public Profile() {
        this.profileID = UUID.randomUUID().toString();
        this.profileName = "Default";
        this.profileColor = Color.red;
        this.sessionTimeInMins = 25;
        this.breakTimeInMins = 5;
        this.alarmSound = null;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setProfileColor(String profileColor) {
        this.profileColor = Color.getColor(profileColor);
    }

    public void setSessionTimeInMins(int sessionTimeInMins) {
        this.sessionTimeInMins = sessionTimeInMins;
    }

    public void setBreakTimeInMins(int breakTimeInMins) {
        this.breakTimeInMins = breakTimeInMins;
    }


    public void setAlarmSound(AlarmSound alarmSound) {
        this.alarmSound = alarmSound;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfileColor() {
        //FIXME: How do I add Colors
        return " ";
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

    @Override
    public String toString() {
        return "Profile{" +
                "profileID='" + profileID + '\'' +
                ", profileName='" + profileName + '\'' +
                ", profileColor=" + profileColor +
                ", sessionTimeInMins=" + sessionTimeInMins +
                ", breakTimeInMins=" + breakTimeInMins +
                ", longBreakTimeInMins=" + longBreakTimeInMins +
                ", alarmSound=" + alarmSound +
                '}';
    }
}

