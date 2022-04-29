public class OnlineShoppingTest {
    public static void main(String[] args) {
        Product product = new Product("asdf",1420.22f);
        product.setRating(4);
        product.setRating(3);
        System.out.println(product);
        Product product1 = new Product("asd2f",1023.2243f);
        product1.setRating(6);
        product1.setRating(3);
        System.out.println(product1);
        Store store = new Store("13224");
        store.addProduct(product);
        store.addProduct(product1);
        Customer customer = new Customer("asdf",13264);
        customer.purchaseProduct(store,product);
        customer.purchaseProduct(store,product1);
        customer.viewShoppingCart(SortBy.Price);
    }
}
