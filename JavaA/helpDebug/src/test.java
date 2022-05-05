import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        System.out.println(isValid(2));
    }
    public static boolean isValid(int x){
        return (4 + x < 7) & (4 - x > 0);
    }
}
