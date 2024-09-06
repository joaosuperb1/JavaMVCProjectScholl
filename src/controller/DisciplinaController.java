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

    private DisciplinaDAO repositorio;

    public DisciplinaController() {
        this.repositorio = new DisciplinaDAO(); // Inicializa o DAO
    }

    public boolean cadastrarDisciplina(String nome, int semestre, String horario, int codigoDisciplina, String CPFProfessor) {
        Disciplina novaDisciplina = validacaoVazio(nome, semestre, horario, codigoDisciplina, );

        if (repositorio.findByNome(nome) == null) {
            return repositorio.save(novaDisciplina); // Cadastra nova disciplina se não houver duplicidade
        } else {
            throw new DisciplinaException("Error - Já existe uma disciplina com este 'Nome'.");
        }
    }

    public void atualizarDisciplina(String nomeOriginal, String nome, int semestre, String horario) {
        Disciplina disciplinaAtualizada = validacaoVazio(nome, semestre, horario);
        repositorio.update(nomeOriginal, disciplinaAtualizada); // Atualiza a disciplina
    }

    public Disciplina buscarDisciplina(String nome) {
        return this.repositorio.findByNome(nome); // Busca disciplina pelo nome
    }

    public List<Disciplina> listarDisciplinas() {
        return this.repositorio.findAll(); // Lista todas as disciplinas
    }

    public void excluirDisciplina(String nome) {
        Disciplina disc = repositorio.findByNome(nome);
        if (disc != null) {
            repositorio.delete(disc); // Exclui a disciplina se ela existir
        } else {
            throw new DisciplinaException("Error - Disciplina inexistente.");
        }
    }

    private Disciplina validacaoVazio(String nome, int semestre, String horario) {
        Disciplina d = new Disciplina();

        if (nome.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'nome'.");
        }
        d.setNome(nome);

        if (semestre <= 0) {
            throw new DisciplinaException("Error - Semestre inválido.");
        }
        d.setSemestre(semestre);

        if (horario.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'horário'.");
        }
        d.setHorario(horario);

        return d;
    }
    
    public void atualizarTabela(JTable grd) {
        // Utilize o Util.jTableShow para atualizar a tabela com o novo TMCadDisciplina
        Util.jTableShow(grd, new TMCadDisciplina(repositorio.findAll()), null);
    }
    
}

