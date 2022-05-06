import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        int initAngle = 0;
        for(int i = 0;i < 8;i ++){
            double a = Math.cos(i * 0.7854);
            System.out.println(a);
            int angle = Math.abs(a) > 0.1 ?( a > 0? (int) Math.floor(Math.cos(i * 0.7854) * 1.6):(int)Math.ceil(Math.cos(i * 0.7854) * 1.6)) : 0;
            System.out.println(angle);
        }
    }
}
