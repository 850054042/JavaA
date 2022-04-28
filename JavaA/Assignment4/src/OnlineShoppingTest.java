public class OnlineShoppingTest {
    public static void main(String[] args) {
        Product product = new Product("asdf",10442.22f);
        product.setRating(4);
        product.setRating(3);
        System.out.println(product);
        Product product1 = new Product("asd2f",104423.2243f);
        product1.setRating(6);
        product1.setRating(3);
        System.out.println(product1);
    }
}
