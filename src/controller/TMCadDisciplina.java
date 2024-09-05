/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author joaos
 */

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Disciplina;

public class TMCadDisciplina extends AbstractTableModel {

    private List<Disciplina> lista;
    
    // Constantes das colunas
    private final int COL_NOME = 0;
    private final int COL_SEMESTRE = 1;
    private final int COL_HORARIO = 2;
    private final int COL_MINISTRANTE = 3;

    public TMCadDisciplina(List<Disciplina> lstDisciplinas) {
        lista = lstDisciplinas;
    }

    @Override
    public int getRowCount() {
        return lista.size(); // Número de disciplinas
    }

    @Override
    public int getColumnCount() {
        return 4; // Nome, Semestre, Horário, Ministrante
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina aux = new Disciplina();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case COL_NOME:
                    return aux.getNome();
                case COL_SEMESTRE:
                    return aux.getSemestre();
                case COL_HORARIO:
                    return aux.getHorario();
                case COL_MINISTRANTE:
                    return aux.getMinistrante().getNome();
                default:
                    return null;
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Não permite edição
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_SEMESTRE:
                return "Semestre";
            case COL_HORARIO:
                return "Horário";
            case COL_MINISTRANTE:
                return "Ministrante";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class; // Tipo de dados exibidos na tabela
    }
}
