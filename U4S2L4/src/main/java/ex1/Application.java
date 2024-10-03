package ex1;

import org.epicode.entities.Customer;
import org.epicode.entities.Order;
import org.epicode.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Order> randomOrders = Utils.getRandomListOfOrder(20);

        System.out.println(randomOrders);

        Map<String, List<Order>> g =
                randomOrders.stream()
                        .collect(Collectors.groupingBy(order -> order.getCustomer().getName()));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("*************************************** RAGGRUPPAMENTO ***************************************");
        System.out.println(" ");
        System.out.println(" ");

        AtomicInteger index = new AtomicInteger(1);

        g.forEach((customerName, orders) -> {
            System.out.println("nome cliente: " + customerName);
            System.out.println("ordine:");

            StringBuilder listaOrdini = new StringBuilder();

            orders
                .forEach(order1 -> {
                    listaOrdini.append(
                        order1.getProducts().stream().
                            map(product -> "prodotto: " + product.getName())
                            .collect(Collectors.joining(", "))
                    );
                });
            System.out.println(listaOrdini);
            System.out.println("*************" + index +"*****************************************************************");
            index.getAndIncrement();
        });
    }
}
