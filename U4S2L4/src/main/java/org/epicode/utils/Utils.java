package org.epicode.utils;

import org.epicode.entities.Customer;
import org.epicode.entities.Order;
import org.epicode.entities.Product;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static ArrayList<Product> getRandomProducts (int listLength){
        ArrayList<Product> res = new ArrayList<>();

        for (int i = 0; i < listLength; i++) {
            Faker f = new Faker(Locale.ITALY);
            Product randomProduct = new Product(f.lordOfTheRings().character(), getRandomCategory(),getRandomPrice());

            res.add(randomProduct);
        }

        return res;
    }

    public static List<Product> getRandomProductsByCategory (String cat, int listLength){

        String category = cat.isEmpty() ? getRandomCategory() : cat;

        return getRandomProducts(listLength)
                .stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    public static List<Order> getRandomListOfOrder (int listLength) {

        List<Order> res = new ArrayList<>();

        Faker f = new Faker(Locale.ITALY);

        for (int i = 0; i < listLength; i++) {
            Customer c = new Customer(f.leagueOfLegends().champion(), f.leagueOfLegends().rank());

            Order order = new Order(getRandomStatus(), getRandomDate(),getRandomDate(), getRandomProductsByCategory("",20), c);

            res.add(order);
        }

        return res;
    }

    public static String getRandomCategory (){
        String[] categories = new String[]{"Book", "Film", "Manga", "TV Series"};

        Random r = new Random();

        return categories[r.nextInt(categories.length)];
    }

    private static LocalDate getRandomDate() {
        // Data di inizio (1 gennaio 2020)
        LocalDate startDate = LocalDate.of(2020, 1, 1);

        // Data attuale
        LocalDate endDate = LocalDate.now();

        // Numero di giorni tra le due date
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        // Numero casuale di giorni da aggiungere a startDate
        long randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween + 1);

        // Ritorna la data casuale
        return startDate.plusDays(randomDays);
    }

    private static String getRandomStatus (){
        String[] categories = new String[]{"Ricevuto", "Spedito", "Consegnato", "Annullato"};

        Random r = new Random();

        return categories[r.nextInt(categories.length)];
    }

    private static double getRandomPrice () {
        Random r = new Random();
        return r.nextDouble(15.0, 200.1);
    }

}
