/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao.DAO_Banco;

import model.Pessoa;

/**
 *
 * @author gabri
 */
public interface IDAO {
    void conexaoBD();
    void save();
    void update(int x);
    void delete(int x);
    void find();
    void findAll();
    void imprimeResultadoBD();
    String getData();
    int getID();
}
