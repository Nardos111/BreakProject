import java.time.LocalDateTime;

public class BPTProfile {
    LocalDateTime dateCreated;
    boolean active;
    String profileName;
    long profileID;
    LocalDateTime startDate;
    int[] notificationHours;

    public BPTProfile(String profileName, long profileID, LocalDateTime startDate, int[] notificationHours) {
        this.profileName = profileName;
        this.profileID = profileID;
        this.startDate = startDate;
        this.dateCreated = LocalDateTime.now();
        this.notificationHours = notificationHours;

    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public boolean isActive() {
        return active;
    }

    public String getProfileName() {
        return profileName;
    }

    public long getProfileID() {
        return profileID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int[] getNotificationHours() {
        return notificationHours;
    }

    public void removeProfile() {
        //TODO Database code here
    }

    public void startRecording() {
        this.active = true;

    }

    public void notifyUser() {

        LocalDateTime[] notificationList = new LocalDateTime[168];
        int index = 0;
        LocalDateTime time = null;
        for (int i = 0; i < 7; i++) {
            for (int j : notificationHours) {
                time = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), j, 00);
                notificationList[index] = time;
                index++;
            }
            time.plusDays(1);
        }
        //TODO JavaFX code here
    }
}
