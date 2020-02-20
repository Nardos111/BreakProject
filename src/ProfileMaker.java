import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProfileMaker {
    Stage window;


    public void displayWindow() throws Exception {
        window =  new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        window.setTitle("Make New Profile");
        window.setScene(new Scene(root, 400, 400));
        Font.loadFont(getClass().getResourceAsStream("Raleway-Regular.tff"), 50);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

}
