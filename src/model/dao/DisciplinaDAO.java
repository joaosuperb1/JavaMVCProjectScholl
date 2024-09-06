/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import model.Disciplina;
import model.Aluno;
import model.exceptions.DisciplinaException;
import view.FrDisciplina;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author joaos
 */
public class DisciplinaDAO extends DAO {

    private List<Disciplina> listaDisciplinas;

    public DisciplinaDAO() {
        super("ListagemDisciplinas.csv");
        this.listaDisciplinas = new ArrayList<>();
    }

    public boolean save(Disciplina disciplina) {
        this.listaDisciplinas.add(disciplina);
        atualizarArquivo();
        return true;
    }

    public Disciplina findByNome(String nome) {
        return this.listaDisciplinas.stream()
                .filter(d -> d.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Object find(Object obj) {
        return this.listaDisciplinas.stream()
                .filter(d -> d.equals(obj))
                .findFirst()
                .orElse(null);
    }

    public void update(String nomeOriginal, Disciplina disciplinaAtualizada) {
        Disciplina disciplinaOriginal = findByNome(nomeOriginal);
        if (disciplinaOriginal == null) {
            throw new DisciplinaException("Error update - Disciplina inexistente.");
        }
        disciplinaOriginal.copiar(disciplinaAtualizada);
        atualizarArquivo();
    }

    @Override
    public boolean delete(Object obj) {
        boolean removed = this.listaDisciplinas.removeIf(d -> d.equals(obj));
        if (removed) {
            atualizarArquivo();
        }
        return removed;
    }

    public List<Disciplina> findAll() {
        this.listaDisciplinas = loadArquivo();
        return this.listaDisciplinas != null ? this.listaDisciplinas : new ArrayList<>();
    }

    private void atualizarArquivo() {
        String texto = lstDisciplinaToCSV();
        super.save(texto);
    }

    private String lstDisciplinaToCSV() {
        StringBuilder texto = new StringBuilder();
        texto.append(new Disciplina().cabecalho());
        this.listaDisciplinas.forEach(d -> texto.append(d.atributoToCSV()));
        return texto.toString();
    }

    private List<Disciplina> loadArquivo() {
        try (FileReader f = new FileReader(this.pathArquivo);
             Scanner arquivoLido = new Scanner(f)) {
            arquivoLido.useDelimiter("\n");
            List<Disciplina> lista = new ArrayList<>();
            if (arquivoLido.hasNext()) {
                arquivoLido.next(); // Skip header
            }
            while (arquivoLido.hasNext()) {
                String linhaLida = arquivoLido.next();
                Disciplina disciplina = new Disciplina();
                disciplina.CSVToAtributo(linhaLida);
                lista.add(disciplina);
            }
            return lista;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}