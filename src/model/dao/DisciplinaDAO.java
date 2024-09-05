/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import model.Disciplina;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.exceptions.AlunoException;
import view.FrDisciplina;


/**
 *
 * @author joaos
 */
public class DisciplinaDAO {
    private List<Disciplina> listaDisciplinas; // Lista de disciplinas

    public DisciplinaDAO() {
        this.listaDisciplinas = new ArrayList<>(); // Inicializa a lista
    }

    public boolean save(Disciplina disciplina) {
        return listaDisciplinas.add(disciplina); // Adiciona uma nova disciplina
    }

    public boolean update(String nomeOriginal, Disciplina disciplinaAtualizada) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getNome().equals(nomeOriginal)) {
                d.copiar(disciplinaAtualizada); // Atualiza os dados da disciplina
                return true;
            }
        }
        return false;
    }

    public Disciplina findByNome(String nome) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getNome().equals(nome)) {
                return d; // Retorna a disciplina com o nome correspondente
            }
        }
        return null;
    }

    public boolean delete(Disciplina disciplina) {
        return listaDisciplinas.remove(disciplina); // Remove a disciplina da lista
    }

    public List<Disciplina> findAll() {
        return listaDisciplinas; // Retorna a lista de todas as disciplinas
    }
}
