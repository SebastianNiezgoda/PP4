package pl.Sniezgoda.ecomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.Sniezgoda.ecomerce.katalog.ProductCatalog;

@SpringBootApplication

public class App {
    public static void main(String[] args){
        System.out.println("Elop");
        SpringApplication.run(App.class,args);
    }
    @Bean
    ProductCatalog createMyCatalog(){
        var catalog = new ProductCatalog();
        catalog.addProduct("100 smow","kox");
        catalog.addProduct("200 smow","giga kox");
        return catalog;
    }
}
