package ex3;

import org.epicode.entities.Product;
import org.epicode.utils.Utils;

import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Product> randomProducts = Utils.getRandomProducts(5);

        System.out.println(randomProducts);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("*************************************** ORDINAMENTO ***************************************");
        System.out.println(" ");
        System.out.println(" ");

        List<Product> expensiveProduct = randomProducts.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(3)
                .toList();

        System.out.println("I 3 prodotti più costosi sono:");
        for (Product p : expensiveProduct) System.out.println(p);

    }
}
