package ex2;

import org.epicode.entities.Order;
import org.epicode.entities.Product;
import org.epicode.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
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

//            AtomicReference<Double> totale = new AtomicReference<>(0.0);
//
//            orders
//                .forEach(order1 -> {
//                    totale.updateAndGet(v ->(v + order1.getProducts().stream().mapToDouble(Product::getPrice).sum()));
//                })
//            ;

            double bill =
                orders.stream()
                    .mapToDouble(o ->
                            o.getProducts().stream()
                                    .mapToDouble(Product::getPrice)
                                    .sum()
                    )
                    .sum()
            ;

            System.out.println(bill);

//            System.out.println(totale.get());
            System.out.println("*************" + index +"*****************************************************************");
            index.getAndIncrement();
        });

    }
}
