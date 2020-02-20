import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ProfileMaker {
    Profile profile;
    @FXML public Stage profileWindow;
    @FXML public TextField profileName;
    @FXML public TextField sesstionTime;
    @FXML public TextField breakTime;
    @FXML public ComboBox<String> profileColor;
    @FXML
    Button save, cancel;


    public Profile displayWindow() throws Exception {
        profileWindow =  new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        profileWindow.setTitle("Make New Profile");
        profileWindow.setScene(new Scene(root, 400, 400));
        Font.loadFont(getClass().getResourceAsStream("Raleway-Regular.tff"), 50);
        profileWindow.setResizable(false);
        profileWindow.initModality(Modality.APPLICATION_MODAL);


        profileWindow.showAndWait();


        return this.profile;
    }
    public void saveProfile() throws SQLException {
        profile = new Profile();
        profile.setProfileName(profileName.getText());
        profile.setSessionTimeInMins(Integer.parseInt(sesstionTime.getText()));
        profile.setBreakTimeInMins(Integer.parseInt(breakTime.getText()));
        profile.setProfileColor(profileColor.getValue());
        PomodoroDatabase x = new PomodoroDatabase();
        System.out.println(profile.toString());
        x.insertProfile(profile);
        ((Stage) save.getScene().getWindow()).close();
    }

    public void cancelProfile(){
        ((Stage) cancel.getScene().getWindow()).close();
    }
}
