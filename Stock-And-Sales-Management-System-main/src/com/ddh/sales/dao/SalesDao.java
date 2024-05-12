package com.ddh.sales.dao;

import com.ddh.sales.bean.Sales;
import com.ddh.sales.bean.SalesReport;
import com.ddh.sales.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SalesDao {
    public int insertSales(Sales sales){
        try{
            PreparedStatement stmt=DBUtil.getDBConnection().prepareStatement("insert into tbl_sales values(?,?,?,?,?)");
            stmt.setString(1,sales.getSalesID());
            java.sql.Date sdate=new java.sql.Date(sales.getSalesDate().getTime());
            stmt.setDate(2, sdate);
            stmt.setString(3,sales.getProductId());
            stmt.setInt(4,sales.getQuantitySold());
            stmt.setDouble(5,(sales.getSalesPriceperUnit()));
            if(stmt.executeUpdate()==1)
                return 1;
            else
                return 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    public String generateSalesID(java.util.Date salesDate){
        try{
            Statement stmt=DBUtil.getDBConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NEXT VALUE FOR SEQ_SALES_ID");
            rs.next();
            int SEQ_SALES_ID=rs.getInt(1);
            String str=salesDate.toString().substring(salesDate.toString().length()-2);
            str=str+SEQ_SALES_ID;
            return str;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;

        }
    }
    public ArrayList<SalesReport> getSalesReport(){
        try{
            Statement stmt=DBUtil.getDBConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from V_SALES_REPORT");
            ArrayList<SalesReport> list=new ArrayList<SalesReport>();

            while(rs.next()) {
                SalesReport salesReport = new SalesReport();
                salesReport.setSalesID(rs.getString(1));
                salesReport.setSalesDate(rs.getDate(2));
                salesReport.setProductID(rs.getString(3));
                salesReport.setProductName(rs.getString(4));
                salesReport.setQuantitySold(rs.getInt(5));
                salesReport.setProductUnitPrice(rs.getDouble(6));
                salesReport.setSalesPricePerUnit(rs.getDouble(7));
                salesReport.setProfitAmount(rs.getDouble(8));
                list.add(salesReport);


            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }
}
