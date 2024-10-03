package ex4;

import org.epicode.entities.Order;
import org.epicode.entities.Product;
import org.epicode.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Order> randomOrders = Utils.getRandomListOfOrder(20);

        System.out.println(randomOrders);

        Double avg = randomOrders.stream()
            .collect(
                    Collectors.averagingDouble(order ->
                        order
                            .getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()
                    )
            )
        ;

        System.out.println(avg);
    }
}
