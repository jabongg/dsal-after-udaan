package com.java.interview.airtelafrica;

public class Product {

    private int productId;
    private String productName;
    private Color color;
    private Size size;

    public Product(int productId, String productName, Color color, Size size) {
        this.productId = productId;
        this.productName = productName;
        this.color = color;
        this.size = size;
    }

    public Product(Color color, Size size) {
        this.color = color;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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
}
