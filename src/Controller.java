import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static String title;
    public Button skipContinueButton;
    public Label statusLabel;
    public Menu profileMenu;
    int status;
    @FXML
    private Label timerLabel;
    StringProperty timerLabelText;
    int remainingTime;
    Pomodoro pomodoro;
    Timeline timeline;
    Timeline progressTimeline = new Timeline();
    @FXML
    ProgressBar progress = new ProgressBar();
    TrayNotification tray;

    ProfileMaker profileMaker = new ProfileMaker();
    private ResultSet resultSet;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //To check where the status of the student is
        PomodoroDatabase x = new PomodoroDatabase();
        try {
            x.prepareDatabase();
            resultSet = x.retrieveRows();
            Profile profile = new Profile();
            while(resultSet.next()){
                profileMenu.getItems().add(1, prepareMenuItem(profileFinderDatabase(profile, resultSet)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.tray = new TrayNotification();
        pomodoro = new Pomodoro();
        timerLabelText = new SimpleStringProperty();
        timerLabel.textProperty().bind(timerLabelText);
        timeline = new Timeline();
        title = Title.FOCUS.getTitle();
        prepare(pomodoro);


    }

    private MenuItem prepareMenuItem(Profile profile) {
        MenuItem menuItem = new MenuItem(profile.getProfileName());
        menuItem.setOnAction(e-> {
            try {
                profileHandler(menuItem.getText());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        return menuItem;

    }

    public Profile profileFinderDatabase(Profile profile, ResultSet resultSet) throws SQLException {
        profile.setProfileID(resultSet.getString(1));
        profile.setProfileName(resultSet.getString(2));
        profile.setProfileColor(resultSet.getString(3));
        profile.setSessionTimeInMins(resultSet.getInt(4));
        profile.setBreakTimeInMins(resultSet.getInt(5));
        return profile;
    }


    public void prepare(Pomodoro pomodoro) {
        remainingTime = pomodoro.getProfile().getSessionTimeInMins() * 60;
        status = remainingTime;
        setTimerLabelText(status);
        statusLabel.setText(Title.FOCUS.getTitle());

    }

    public void profileHandler(String s) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()){
            if (resultSet.getString(2).equals(s)){
                Profile profile = new Profile();
                pomodoro = new Pomodoro(profileFinderDatabase(profile, resultSet));
            }
        }
        timeline.stop();
        progressTimeline.stop();

        prepare(pomodoro);
    }

    public void setTimerLabelText(String str) {
        timerLabelText.set(str);
    }

    public void setTimerLabelText(int remainingTime) {
        int mins = remainingTime / 60;
        int secs = remainingTime % 60;
        timerLabelText.set(String.format("%02d:%02d", mins, secs));
    }

    public void playButton(ActionEvent actionEvent) throws Exception {

        if (timeline.getStatus() == Animation.Status.RUNNING) {
        } else {
            skipContinueButton.setText("Skip");
            if (timeline != null && timeline.getStatus() != Animation.Status.RUNNING) {
                timeline = new Timeline();
            }
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
                tick();
            }));

            progressTimeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                    new KeyFrame(Duration.seconds(remainingTime), e -> {
                    }, new KeyValue(progress.progressProperty(), 1))
            );
            timeline.setCycleCount(remainingTime);
            timeline.playFromStart();
            progressTimeline.playFromStart();

            timeline.setOnFinished(e -> {

                this.setTray();
                continueSession();
                this.tray.showAndWait();
            });
        }
    }

    private void tick() {
        remainingTime--;
        setTimerLabelText(remainingTime);
    }

    public void pauseButton(ActionEvent actionEvent) {
        timeline.pause();
        progressTimeline.pause();
    }

    public void defaultProfileHandler(ActionEvent actionEvent) {
        timeline.stop();
        progressTimeline.stop();
        pomodoro = new Pomodoro();
        prepare(pomodoro);
    }

    public void addNewHandler(ActionEvent actionEvent) throws Exception {
        //FIXME: append profile immediately
        Profile profile = profileMaker.displayWindow();

    }

    public void skipContinueButtonHandler(ActionEvent actionEvent) {

        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            progressTimeline.stop();
        }
        continueSession();

    }


    public void continueSession() {
        progressTimeline.stop();
        if (status == pomodoro.getProfile().getSessionTimeInMins() * 60) {
            status = pomodoro.getProfile().getBreakTimeInMins() * 60;
            remainingTime = status;
            statusLabel.setText(Title.BREAK.getTitle());
        } else if (status == pomodoro.getProfile().getBreakTimeInMins() * 60) {
            status = pomodoro.getProfile().getSessionTimeInMins() * 60;
            remainingTime = status;
            title = Title.FOCUS.getTitle();
            statusLabel.setText(Title.FOCUS.getTitle());
        }
        setTimerLabelText(status);
    }

    private void setTray() {
        this.tray.setTitle("Congratulations");
        this.tray.setMessage("You have finished " + statusLabel.getText());
        this.tray.setNotificationType(NotificationType.SUCCESS);

    }

}


