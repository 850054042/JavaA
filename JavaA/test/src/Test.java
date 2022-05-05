import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        char c = 'c';
        System.out.println(Character.toUpperCase(c));
        System.out.println(c);
    }
    public static int[] strToInt(String str){
        int a[] = new int[str.length()];
        a[0] = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) != '-')
                a[i] = str.charAt(i) - 48;
        }
        return a;
    }
}
