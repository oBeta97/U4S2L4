package org.epicode.entities;

public class Product {
    private final long id;
    private String name;
    private String category;
    private double price;

    public Product (String _name, String _category, double _price){
        this.id = hashCode();
        setName(_name);
        setCategory(_category);
        setPrice(_price);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                    "\n\tid=" + id +
                    "\n\tname='" + name + '\'' +
                    "\n\tcategory='" + category + '\'' +
                    "\n\tprice=" + price +
                "\n}";
    }
}
