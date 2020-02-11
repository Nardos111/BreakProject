
public class AlarmSound {
    private final String DEFAULT_1 = "1.mp3";
    private final String DEFAULT_2 = "2.mp3";
    private final String DEFAULT_3 = "3.mp3";
    private String sound;

    AlarmSound(){
        sound = DEFAULT_1;
    }
    AlarmSound(String sound){
        this.sound = sound;
    }
    public void changeSound(String sound){
        this.sound = sound;
    }
    public void ring(){
        //TODO JavaFX code here
    }

}
