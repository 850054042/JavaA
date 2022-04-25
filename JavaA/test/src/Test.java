public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("00000000000001001");
        StringBuilder stringBuilder1 = new StringBuilder("11000011001100001");
        System.out.println(stringBuilder.toString().compareTo(stringBuilder1.toString()));
    }
}
