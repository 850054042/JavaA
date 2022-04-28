import java.util.EnumSet;
import java.util.Scanner;

public class PhoneModelTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int budget = input.nextInt();
        for(PhoneModel phoneModel: PhoneModel.values()){
            if(phoneModel.getPrice() < budget){
                System.out.printf("%-10s",phoneModel);
                System.out.printf("price:");
                System.out.printf("%d\n",phoneModel.getPrice());
            }
        }
    }
}
