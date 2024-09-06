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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author gabri
 */
public class DAOAlunoBanco extends BDIntegrator implements IDAO {
    String tableName = "Aluno";
    String Rows = "(aluno_id, nome, sexo, idade, matricula, ingresso)";
    
    ResultSet rs;
    @Override
    public void save( ){
    String tableName = "Aluno";
    getData();
    super.save();
    }
    
    
    @Override
    public void update(int matricula){
        int x = getId(matricula);
        String tableName = "Aluno";
        super.update(x);
    }
    
    
    @Override
    public void delete(int matricula){
        int x = getId(matricula);
        String tableName = "Aluno";
        super.delete(x);
    }
    
    @Override
    public void find( ){
        String tableName = "Aluno";
        super.find();
    }
    
    @Override
    public void findAll(){
        String tableName = "Aluno";
        super.findAll();
    }
    
    @Override
    public void imprimeResultadoBD(){
        try {
            String format = rs.getInt("aluno_id") + "   " + rs.getString("nome") +
                    "   " + rs.getString("sexo") + "   " + rs.getInt("idade") +"   " +
                    rs.getInt("matricula" + "   " + rs.getInt("ingresso") );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        super.imprimeResultadoBD();
    }
    
    
    public String getData(int id,String nome, String sexo, String idade, String matricula, String ingresso){
        data = "("+nome +","+sexo+","+idade+","+matricula+","+ingresso+")";
        return data;
    }
    
    public int getId(int matricula){
        command = "SELECT aluno_id FROM Aluno WHERE matricula = "+matricula;
        conexaoBD();
        try {
            return rs.getInt("aluno_id");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
}
