/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.DAO_Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author gabri
 */
public class BDIntegrator implements IDAO {
    public String tableName = null;
    public String Rows = null;
    public String data = null;
    public ResultSet rs;
    public String format = null;
    public String command = null;
    @Override
    public void save(){
        String command ="INSERT INTO " +tableName +Rows +" VALUES " +data;
        conexaoBD();
        imprimeResultadoBD();
    }
    
    @Override
    public void update(int x){
       String command ="UPDATE " +tableName +"\n"
       +"SET ";
       
    }
    //Executa o código da subclasse dentro de update.
    
    
    @Override
    public void delete(int x){
        String command ="DELETE * FROM " +tableName +" WHERE id = " +x;
        conexaoBD();
        imprimeResultadoBD();
    }
    
    @Override
    public void find(){
        String command = "SELECT * FROM " +tableName +" WHERE id = x";
        conexaoBD();
        imprimeResultadoBD();
    }
    
    @Override
    public void findAll( ){
        String command = "SELECT * FROM " +tableName;
        conexaoBD();
        imprimeResultadoBD();
    }

    //Realiza a conexão com o banco de dados e executa um comando.
    @Override
    public void conexaoBD() {
        Connection conn = null;
        try {
            //Chama função de conexão, define query e guarda o resultado.
            String url = "jdbc:sqlite:.\\ProjetoEscola.db"; 
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to db has been established");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(command);
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
    
    @Override
    public void imprimeResultadoBD(){ 
        try {
            while(rs.next()){
                System.out.println(format);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String getData() {
        
        return data;
    }

    @Override
    public int getID() {
        return -1;
    }
    
    

    
    
}
