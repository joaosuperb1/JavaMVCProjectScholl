/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author joaos
 */
import model.Professor;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TMCadProfessor extends AbstractTableModel {

    private List<Professor> lista;

    // Constantes das colunas
    private final int COL_NOME = 0;   
    private final int COL_SEXO = 1;    
    private final int COL_IDADE = 2;
    private final int COL_CPF = 3;       

    public TMCadProfessor(List<Professor> lstProfessores) {        
        lista = lstProfessores;        
    }

    @Override
    public int getRowCount() {
        return lista.size(); // Conta quantas linhas que tem
    }

    @Override
    public int getColumnCount() {
        return 4; // Número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Professor aux = new Professor();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            // O Zé usou if else. Fui de switch mesmo... me parece mais simples do que ficaar colocando else if 3 vezes...
            switch (columnIndex) {
                case COL_NOME:
                    return aux.getNome();
                case COL_SEXO:
                    return aux.getSexo();
                case COL_IDADE:
                    return aux.getIdade();
                case COL_CPF:
                    return aux.getCpf();
                default: 
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // não pode editada.
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_SEXO:
                return "Sexo";
            case COL_IDADE:
                return "Idade"; 
            case COL_CPF:
                return "CPF";
            default:
                break;
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class; 
    }
}