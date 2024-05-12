package com.ddh.sales.bean;
public class Product {
    private String productID;
    private String productName ;
    private int quantityonHand ;
    private double productUnitPrice ;
    private int reorderLevel ;
    public void setProductID(String a){
        this.productID=a;
    }
    public String getProductID() {
        return productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setQuantityonHand(int quantityonHand) {
        this.quantityonHand = quantityonHand;
    }

    public int getQuantityonHand() {
        return quantityonHand;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }
    public void setReorderLevel(int reorderLevel){
        this.reorderLevel=reorderLevel;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }
}
