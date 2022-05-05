import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<BigBinary> bigBinaries = new ArrayList<>();
        bigBinaries.add(new BigBinary(new int[]{1,1,1},true));
        bigBinaries.add(new BigBinary(new int[]{1,1,1},false));
        ArrayList<BigBinary> bigBinaries1 = bigBinaries;
        bigBinaries1.remove(0);
        for(BigBinary bigBinary:bigBinaries)
            System.out.println(bigBinary);
    }
}
