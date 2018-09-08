/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

//
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author mateo
 */
public class SimpleDataSource {
    
        private static final String URL = "jdbc:mysql://localhost/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
      private static final String USER = "root";
      private static final String PASSWORD = "admin";
    
    
      public SimpleDataSource() {

        System.out.println("Setting up data source.");
        DataSource dataSource = setupDataSource("jdbc:mysql://localhost/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        System.out.println("Done.");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            System.out.println("Creating connection.");
            conn = dataSource.getConnection();
            System.out.println("Creating statement.");
            stmt = conn.createStatement();
            System.out.println("Executing statement.");
            rset = stmt.executeQuery("select name, login, password, email from users");
            System.out.println("Results:");
            System.out.println("Results:-------------------------");
            int numcols = rset.getMetaData().getColumnCount();
             System.out.println("Columns--------------------------:"+numcols);
            while(rset.next()) {
                for(int i=1;i<=numcols;i++) {
                    System.out.print("\t" + rset.getString(i));
                }
                System.out.println("");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
        }
    }
      
      public static DataSource setupDataSource() {
           return setupDataSource(URL, USER, PASSWORD);
    }

    public static DataSource setupDataSource(String connectURI, String user, String pass) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(connectURI);
        ds.setUsername(user);
        ds.setPassword(pass);
        return ds;
    }

    public static void printDataSourceStats(DataSource ds) {
        BasicDataSource bds = (BasicDataSource) ds;
        System.out.println("NumActive: " + bds.getNumActive());
        System.out.println("NumIdle: " + bds.getNumIdle());
    }

    public static void shutdownDataSource(DataSource ds) throws SQLException {
        BasicDataSource bds = (BasicDataSource) ds;
        bds.close();
    }
    
}
