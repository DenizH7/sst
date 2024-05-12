package com.ddh.sales.bean;
import java.util.Date;

public class Sales {
    private String salesID;
    private Date salesDate;
    private String productId;
    private int quantitySold;
    private double salesPriceperUnit;

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

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setSalesPriceperUnit(double salesPriceperUnit) {
        this.salesPriceperUnit = salesPriceperUnit;
    }

    public double getSalesPriceperUnit() {
        return salesPriceperUnit;
    }

}
