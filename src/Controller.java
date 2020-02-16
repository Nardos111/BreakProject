import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javax.naming.Binding;
import java.text.SimpleDateFormat;


public class Controller{
    public Button button;
    public static Timeline timeline = new Timeline();
    public static Timeline timeline1 = new Timeline();

    public Label timerLabelS;
    public Label timerLabel;

    public static int j = 100;
    public static IntegerProperty num1 = new SimpleIntegerProperty(j);
    private static int i = 25;
    public static IntegerProperty num = new SimpleIntegerProperty(i);
    public void buttonHandle(){
        SimpleDateFormat t = new SimpleDateFormat("mm ss");
        String k = t.format(num.asString());
        timerLabel.textProperty().bind(num.asString("%02d"));
        timerLabelS.textProperty().bind(num1.asString("%02d"));
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(j), new KeyValue(num, 0)));
        timeline1.getKeyFrames().add(new KeyFrame(Duration.seconds(j), new KeyValue(num1, 0)));
        timeline.playFromStart();
        timeline1.setCycleCount(i * j);
        timeline1.playFromStart();



    }
    public void pauseButtonHandler(){
        timeline.pause();
    }
    //TODO: Labels and Progress Bar

}