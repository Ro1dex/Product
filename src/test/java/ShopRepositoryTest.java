import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new  Product( 1, "TShirt", 1000);
    Product product2 = new  Product( 33, "Book", 750);
    Product product3 = new  Product( 78, "Ball", 2300);



    @Test
    public void shouldAddProducts(){
        ShopRepository products = new ShopRepository();
        products.save(product1);
        products.save(product2);
        products.save(product3);
        Product[] exp = { product1, product2, product3};
        Product[] act = products.findAll();
        Assertions.assertArrayEquals(exp,act);

    }
    @Test
    public void shouldDelProducts(){
        ShopRepository products = new ShopRepository();
        products.save(product1);
        products.save(product2);
        products.save(product3);
        products.removeById(1);
        Product[] exp = {product2, product3};
        Product[] act = products.findAll();
        Assertions.assertArrayEquals(exp,act);

    }
    @Test
    public void shouldNotDelProducts(){
        ShopRepository products = new ShopRepository();
        products.save(product1);
        products.save(product2);
        products.save(product3);
        Assertions.assertThrows(NotFoundException.class,() -> {products.removeById(100);} );

    }
}
