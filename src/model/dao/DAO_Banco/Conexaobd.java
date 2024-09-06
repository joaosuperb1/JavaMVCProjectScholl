/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.DAO_Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class Conexaobd implements IDAO {
    public static void conexaobd(){
        Connection conn = null;
        String url = "jdbc:sqlite:.\\ProjetoEscola.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db has been established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }
    public void findAll(){
        
        String sql = "SELECT * FROM " +tableName;
        
        try(){
            
        //}
    }
    
    
    public static void main(String[] args){
        conexaobd();
    }
}
