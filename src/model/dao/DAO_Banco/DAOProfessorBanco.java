/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.DAO_Banco;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author gabri
 */
public class DAOProfessorBanco extends BDIntegrator implements IDAO {
    String tableName = "Professor";
    ResultSet rs;
    @Override
    public void save( int id){
        
    }
    
    @Override
    public void update( int id){
        
    }
    
    @Override
    public void delete( int id){
        
    }
    
    @Override
    public void find( int id){
        
    }
    
    @Override
    public void findAll(){
        
    }
    
    @Override
    public void imprimeResultadoBD(){
        try {
            String format = rs.getInt("Professor_id") + "   " + rs.getString("nome") +
                    "   " + rs.getString("sexo") + "   " + rs.getInt("idade") +"   " +
                    rs.getString("cpf" );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
