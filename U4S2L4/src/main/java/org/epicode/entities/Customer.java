package org.epicode.entities;

public class Customer {
    private final long id;
    private String name;
    private String tier;

    public Customer(String name, String tier) {
        this.id = hashCode();
        setName(name);
        setTier(tier);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\ttier='" + tier + '\'' +
                "\n}";
    }
}
