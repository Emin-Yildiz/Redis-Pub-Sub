package com.example.sub.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private String productId;
    private String productName;
    private String quantity;

    public Product(String productId, String productName, String quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Product(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
