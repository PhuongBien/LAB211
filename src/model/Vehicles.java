package model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CHI TRANG
 */
public class Vehicles implements Serializable {

    private String id;
    private String name;
    private String color;
    private double price;
    private String brand;
    private String type;
    private String productYear;

    public Vehicles() {
    }

    public Vehicles(String id, String name, String color, double price, String brand, String type, String productYear) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.productYear = productYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + name + " - " + color + " - " + price + " - " + brand + " - " + type + " - " + productYear;
    }

}
