import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeTest {

    public static void main(String[] args) {
//        ------------------------
//        List<Circle> circleList = new ArrayList<>();
//        Circle.setScreenSize(14);
//        StdDraw.setScale(-Shape.getScreenSize(), Shape.getScreenSize());
//        for (int i = 0; i < Shape.getScreenSize(); i += 2) {
//            circleList.add(new Circle(i, 0, -Shape.getScreenSize()));
//        }
//        Collections.sort(circleList);
//        for (int i = 0; i < circleList.size(); i++) {
//            circleList.get(i).setColor(ShapeColor.values()[i%3]);
//            circleList.get(i).draw();
//        }
//        -----------------------------
//        List<Circle> circleList = new ArrayList<Circle>();
//        Shape.setScreenSize(14);
//        StdDraw.setScale(-Shape.getScreenSize(), Shape.getScreenSize());
//        for (int i = 1; i < Shape.getScreenSize(); i += 2) {
//            circleList.add(new Circle(i, 0, -Shape.getScreenSize()));
//        }
//        Collections.sort(circleList);
//        for (int i = 0; i < circleList.size(); i++) {
//            circleList.get(i).customizedColor(ColorScheme.RAINBOW, i);
//        }
//        -------------------------------------
        List<Circle> circleList = new ArrayList<Circle>();
        Shape.setScreenSize(9);
        StdDraw.setScale(-Shape.getScreenSize(),Shape.getScreenSize());
        for(int i = 1;i <= 9;i+=2){
            circleList.add(new Circle(i,0,i));
        }
        Collections.sort(circleList);
        for(int i = 0;i < circleList.size();i++){
            circleList.get(i).customizedColor(ColorScheme.SKY,i);
        }
    }

}
