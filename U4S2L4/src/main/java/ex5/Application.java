package ex5;

import org.epicode.entities.Product;
import org.epicode.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Product> randomProducts = Utils.getRandomProducts(20);

        Map<String, Double> billCategory =
            randomProducts
                .stream()
                .collect(
                    Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)
                    )
                )
        ;

        billCategory.forEach((cat, imports) -> System.out.println("Categoria: " + cat + " - totale: " + imports));

    }
}
