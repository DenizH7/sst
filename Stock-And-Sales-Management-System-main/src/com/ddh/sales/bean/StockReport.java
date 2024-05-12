package com.ddh.sales.bean;
import java.util.Date;


public class StockReport {
    private String salesID;
    private Date salesDate;
    private String productID;
    private String productName;
    private int quantitySold;
    private double productUnitPrice;
    private double salesPricePerUnit;
    private double profitAmount;
    private int quantityonHand;
    private int reorderLevel;
    
    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    
    public void setQuantityonHand(int quantityonHand) {
    	this.quantityonHand = quantityonHand;
    }
    
    public int getQuantityonHand() {
    	return quantityonHand;
    }
    
    public void setReorderLevel(int reorderLevel) {
    	this.reorderLevel = reorderLevel;
    }
    
    public int getReorderLevel() {
    	return reorderLevel;
    }
    
    public int getQuantitySold() {
        return quantitySold;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setSalesPricePerUnit(double salesPricePerUnit) {
        this.salesPricePerUnit = salesPricePerUnit;
    }

    public double getSalesPricePerUnit() {
        return salesPricePerUnit;
    }

    public void setProfitAmount(double profitAmount) {
        this.profitAmount = profitAmount;
    }

    public double getProfitAmount() {
        return profitAmount;
    }
}