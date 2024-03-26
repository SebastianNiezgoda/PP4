package pl.Sniezgoda.ecomerce.katalog;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id , name, description);
        products.add(newProduct);
        return newProduct.getID();
    }

    public Product getProductBy(String id) {
        return products.stream()
                .filter(product -> product.getID().equals(id))
                .findFirst()
                .get();
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product product = getProductBy(id);
        product.changePrice(newPrice);
    }
}
