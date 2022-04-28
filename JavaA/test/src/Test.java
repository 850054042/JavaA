import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        boolean po1 = str1.charAt(0) == '-' ? false:true;
        boolean po2 = str2.charAt(0) == '-' ? false:true;
        int[] b1 = strToInt(str1);
        int[] b2 = strToInt(str2);

        BigBinary bigBinary1 = new BigBinary(b1, po1);
        BigBinary bigBinary2 = new BigBinary(b2, po2);

        System.out.println(BigBinary.add(bigBinary1,bigBinary2));
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
