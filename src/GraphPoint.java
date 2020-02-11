import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class GraphPoint {
    Point coordinate;
    LocalDateTime pointTime;

    GraphPoint(int x, int y){
        this.coordinate = new Point(x, y);
        this.pointTime = LocalDateTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        time.format(this.pointTime);
    }
    public double getX(){
        return coordinate.getX();
    }

    public double getY(){
        return coordinate.getY();
    }
    public LocalDateTime getPointTime() {
        return pointTime;
    }
}
