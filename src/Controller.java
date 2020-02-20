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
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static String title;
    public Button skipContinueButton;
    public Label statusLabel;
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

    ProfileMaker x = new ProfileMaker();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //To check where the status of the student is

        //TODO: Database code for retrieving all the profiles
        this.tray = new TrayNotification();
        pomodoro = new Pomodoro();
        timerLabelText = new SimpleStringProperty();
        timerLabel.textProperty().bind(timerLabelText);
        timeline = new Timeline();
        title = Title.FOCUS.getTitle();
        prepare();


    }

    public void prepare() {
        remainingTime = pomodoro.getProfile().getSessionTimeInMins() * 60;
        status = remainingTime;
        setTimerLabelText(status);
        statusLabel.setText(Title.FOCUS.getTitle());

    }

    public void profile1Handler() {
        timeline.stop();
        progressTimeline.stop();
        Profile profile = new Profile("Profile 1", Color.yellow, 45, 15, 30);
        pomodoro = new Pomodoro(profile);
        prepare();
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
        prepare();
    }

    public void addNewHandler(ActionEvent actionEvent) throws Exception {

        x.displayWindow();

    }

    public void skipContinueButtonHandler(ActionEvent actionEvent) {

        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            progressTimeline.stop();
        }
        continueSession();

    }

    public void cancelProfile(ActionEvent actionEvent) {
        x.window.close();
    }

    public void saveProfile(ActionEvent actionEvent) {

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
        this.tray.setMessage("You have finished" + statusLabel.getText());
        this.tray.setNotificationType(NotificationType.SUCCESS);

    }

}

/*TODO:
 *  Multiple Pomodoros
 *  */

