/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdteste;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author gabri
 */

public class conexaoBD {
    public static void conexaobd(){
        Connection conn = null;
        String url = "jdbc:sqlite:C:\\VSCODE\\OO\\JavaMVCProjectScholl\\src\\bdteste\\ProjetoEscola.db";
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
    
    public static void main(String[] args){
        conexaobd();
    }
}


