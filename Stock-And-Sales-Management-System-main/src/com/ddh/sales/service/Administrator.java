package com.ddh.sales.service;

import com.ddh.sales.bean.Product;
import com.ddh.sales.bean.Sales;
import com.ddh.sales.bean.SalesReport;
import com.ddh.sales.bean.StockReport;
import com.ddh.sales.dao.SalesDao;
import com.ddh.sales.dao.StockDao;

import java.util.ArrayList;
import java.util.Date;

public class Administrator {
    private StockDao stockDao=new StockDao();
    private SalesDao salesDao=new SalesDao();
    public String insertStock(Product productobj){
        if((productobj!=null) && (productobj.getProductName().length()>=2)){
            String productID=stockDao.generateProductId(productobj.getProductName());
            productobj.setProductID(productID);
            if(stockDao.insertStock(productobj)==1)
                return productID;
            else
                return "Girdi Eklemeye Uygun Değil";
        }
        else
            return "Girdi Eklemeye Uygun Değil";

    }
    public String deleteStock(String ProductID){
        if(stockDao.deleteStock(ProductID)==1)
            return "Silindi";
        else
            return "Kayıt Silinemez";
    }
    public String incrementStock(String productID, int quantityToAdd) {
    	if(stockDao.incrementStock(productID, quantityToAdd)==1)
    		return "Stok Eklendi";
    	else
    		return "Stok Değiştirilemedi";
    }
    public String insertSales(Sales salesObj){
        if(salesObj==null)
            return "Eklemeye Uygun Değil";
        if(stockDao.getStock(salesObj.getProductId())==null)
            return "Bilinmeyen Ürün";
        if(stockDao.getStock(salesObj.getProductId()).getQuantityonHand() < salesObj.getQuantitySold())
            return "Satış İçin Yeterli Stok Yok";

        if(salesObj.getSalesDate().after(new Date()))
            return "Geçersiz Tarih";
        String SalesId=salesDao.generateSalesID(salesObj.getSalesDate());
        salesObj.setSalesID(SalesId);

        if(salesDao.insertSales(salesObj)==1){
            if(stockDao.updateStock(salesObj.getProductId(),salesObj.getQuantitySold())==1)
                return "Satış Kaydı Eklendi";
            else{
                return "HATA";
            }
        }
        else
            return "HATA";

    }
    public ArrayList<SalesReport> getSalesReport(){
        return salesDao.getSalesReport();

    }
    public ArrayList<StockReport> getStockReport(){
        return stockDao.getStockReport();
    }
}