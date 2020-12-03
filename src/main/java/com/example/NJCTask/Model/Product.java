package com.example.NJCTask.Model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int productId;

    @Column(name = "product")
    String productName;

    @Column(name = "brand")
    String brandName;

    @Column(name = "price")
    double price;

    public Product(int productId, String productName, String brandName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
    }

    public Product() {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

