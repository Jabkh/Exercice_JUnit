import static org.junit.jupiter.api.Assertions.*;

import org.example.Product;
import org.example.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShopTest {
    @Test
    public void testQualityDecreasesByOneBeforeSellInDate() {
        Product product = new Product("normal", "normal product", 10, 20);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(9, product.getSellIn());
        assertEquals(19, product.getQuality());
    }

    @Test
    public void testQualityDecreasesTwiceAsFastAfterSellInDate() {
        Product product = new Product("normal", "normal product", 0, 20);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(-1, product.getSellIn());
        assertEquals(18, product.getQuality());
    }

    @Test
    public void testQualityNeverNegative() {
        Product product = new Product("normal", "normal product", 10, 0);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(9, product.getSellIn());
        assertEquals(0, product.getQuality());
    }

    @Test
    public void testQualityNeverMoreThanFifty() {
        Product product = new Product("brie", "aged brie", 10, 50);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(9, product.getSellIn());
        assertEquals(50, product.getQuality());
    }

    @Test
    public void testBrieIncreasesInQuality() {
        Product product = new Product("brie", "aged brie", 10, 10);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(9, product.getSellIn());
        assertEquals(11, product.getQuality());
    }

    @Test
    public void testDairyDegradesTwiceAsFast() {
        Product product = new Product("dairy", "milk", 10, 20);
        Shop shop = new Shop(List.of(product));
        shop.updateAllProducts();
        assertEquals(9, product.getSellIn());
        assertEquals(18, product.getQuality());
    }
}
