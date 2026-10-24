package com.example.ministore;
public class Product {
    private final String code, name;
    private final double price;
    private final int stock;
    public Product(String code, String name, double price, int stock) {
        this.code=code; this.name=name; this.price=price; this.stock=stock;
    }
    public String getCode(){return code;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
}
