package com.ddh.sales.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
        public static Connection getDBConnection(){
            Connection con=null;
            try {
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER01;databaseName=SalesStock;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

            }
            catch (Exception e){
                e.printStackTrace();

            }
            return con;
        }
}
