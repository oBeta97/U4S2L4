package org.epicode.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = hashCode();
        setStatus(status);
        setOrderDate(orderDate);
        setDeliveryDate(deliveryDate);
        setProducts(products);
        setCustomer(customer);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n\tid=" + id +
                "\n\tstatus='" + status + '\'' +
                "\n\torderDate=" + orderDate +
                "\n\tdeliveryDate=" + deliveryDate +
                "\n\tproducts=\n" + products +
                "\n\tcustomer=\n" + customer +
                "\n}";
    }
}
