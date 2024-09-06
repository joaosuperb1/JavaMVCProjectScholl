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
import javax.swing.JTable;
import model.Disciplina;
import model.dao.DisciplinaDAO;
import model.exceptions.DisciplinaException;

public class DisciplinaController {

    private final DisciplinaDAO repositorio;

    public DisciplinaController() {
        this.repositorio = new DisciplinaDAO();
    }

    public boolean cadastrarDisciplina(String nome, int semestre, String horario, int codigoDisciplina, String CPFProfessor) {
        Disciplina novaDisciplina = validarDisciplina(nome, semestre, horario, codigoDisciplina, CPFProfessor);

        if (repositorio.findByNome(nome) == null) {
            return repositorio.save(novaDisciplina);
        } else {
            throw new DisciplinaException("Error - Já existe uma disciplina com este 'Nome'.");
        }
    }

    public void atualizarDisciplina(String nomeOriginal, String nome, int semestre, String horario) {
        Disciplina disciplinaAtualizada = validarDisciplina(nome, semestre, horario);
        repositorio.update(nomeOriginal, disciplinaAtualizada);
    }

    public Disciplina buscarDisciplina(String nome) {
        return repositorio.findByNome(nome);
    }

    public List<Disciplina> listarDisciplinas() {
        return repositorio.findAll();
    }

    public void excluirDisciplina(String nome) {
        Disciplina disc = repositorio.findByNome(nome);
        if (disc != null) {
            repositorio.delete(disc);
        } else {
            throw new DisciplinaException("Error - Disciplina inexistente.");
        }
    }

    private Disciplina validarDisciplina(String nome, int semestre, String horario) {
        if (nome.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'nome'.");
        }
        if (semestre <= 0) {
            throw new DisciplinaException("Error - Semestre inválido.");
        }
        if (horario.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'horário'.");
        }

        return new Disciplina(nome, semestre, horario, ministrante, codigoDisciplina);
    }

    private Disciplina validarDisciplina(String nome, int semestre, String horario, int codigoDisciplina, String CPFProfessor) {
        Disciplina disciplina = validarDisciplina(nome, semestre, horario);
        disciplina.setCodigoDisciplina(codigoDisciplina);
        disciplina.setCPFProfessor(CPFProfessor);
        return disciplina;
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMCadDisciplina(repositorio.findAll()), null);
    }
}

