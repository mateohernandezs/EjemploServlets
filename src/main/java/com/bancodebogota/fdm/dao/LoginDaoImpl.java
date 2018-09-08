/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.dao;
import com.bancodebogota.fdm.config.SimpleDataSource;
import static com.bancodebogota.fdm.config.SimpleDataSource.setupDataSource;
import com.bancodebogota.fdm.dto.UserDto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
/**
 *
 * @author admin
 */
public class LoginDaoImpl implements LoginDao{
    
    private static LoginDaoImpl instance = null;
    
    private LoginDaoImpl(){
    
    }
    
    public static LoginDaoImpl getInstance(){
        if (instance==null) {
            instance = new LoginDaoImpl();
        }
        return instance;
    }
    
    
    public static UserDto obtenerUsuario(String name, String password){
        
        UserDto user = new UserDto();
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
            rset = stmt.executeQuery("select name, login, password, email from users where login =\""+name+"\" and password=\""+password+"\"");
            System.out.println("Results:");
            System.out.println("Results:-------------------------");
            int numcols = rset.getMetaData().getColumnCount();
            System.out.println("Columns--------------------------:"+numcols);
            
            
            if(rset.next()) {
                user.setEmail(rset.getString("email"));
                user.setLogin(rset.getString("login"));
                user.setName(rset.getString("name"));
                user.setPassword(rset.getString("password"));
                    
            }else{
                return null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
        }
        return user; 
    }

    @Override
    public UserDto obtenerUsuario(UserDto userDto) {

        String query = "select name, login, password, email from users where login = "
                + userDto.getLogin() + " and password = " + userDto.getPassword();

        DataSource dataSource = SimpleDataSource.setupDataSource();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {

            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                userDto.setEmail(rset.getString("email"));
                userDto.setName(rset.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
            } catch (Exception e) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

        return userDto;
    }

}