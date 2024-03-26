package pl.Sniezgoda.ecomerce.katalog;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pl.Sniezgoda.ecomerce.katalog.Product;
import pl.Sniezgoda.ecomerce.katalog.ProductCatalog;

import java.math.BigDecimal;
import java.util.List;


public class ProductKatalogTest {
    @Test
    void itListsProducts(){
        ProductCatalog catalog = new ProductCatalog();

        List<Product> productList = catalog.allProducts();

        assert productList.isEmpty();

    }

    @Test
    void itAllowsToAddProducts(){
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Kod na 1000 smoczych monet","nice one");
        List<Product>  productList = catalog.allProducts();
        assertThat(productList).hasSize(1);
    }

    @Test
    void itLoadsProductDetails(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Kod na 1000 smoczych monet","Nice one");

        Product loadedProduct = catalog.getProductBy(id);
        assertThat(id).isEqualTo(loadedProduct.getID());
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Kod na 1000 smoczych monet","Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loadedProduct = catalog.getProductBy(id);
        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loadedProduct.getPrice());

    }
}
