
package model;

public class Disciplina {
    private String nome;
    private int semestre;
    private String horario;
    private Professor ministrante;
    private int codigoDisciplina;
    private Aluno[] lstAlunos;

    public Disciplina(){
        this.nome = "";
        this.semestre = -1;
        this.horario = "0h";
        this.ministrante = new Professor();
        this.codigoDisciplina = 0;
        this.lstAlunos = new Aluno[4];
        
        for(int i=0; i<=3; i++){
            lstAlunos[i] = new Aluno();
        }
    }

    public Disciplina(String nome, int semestre, String horario, Professor ministrante, int codigoDisciplina) {
        this.nome = nome;
        this.semestre = semestre;
        this.horario = horario;
        this.ministrante = ministrante;
        this.codigoDisciplina = codigoDisciplina;
    }
    
    @Override
    public String toString(){
        String txt = "---- Dados da Disciplina ----\n"
        +"Nome: " + this.nome + "\n"
        +"Semestre: "+ this.semestre + "\n"
        +"Horario: " + this.horario + "\n"
        +"Codigo: " + this.codigoDisciplina;
        
        txt += ministrante.toString();
        for(int i=0; i<=3; i++){
            txt += lstAlunos[i].toString();
        }                
        return txt;
    }
    
    
    public void copiar(Disciplina outra){
        this.nome = outra.getNome();
        this.semestre = outra.getSemestre();
        this.horario = outra.getHorario();
        this.codigoDisciplina = outra.getCodigoDisciplina();
        
        this.ministrante.copiar(outra.getMinistrante());
        
        for(int i=0; i<=3; i++){
            this.lstAlunos[i].copiar(outra.getLstAlunos()[i]);
        }
        
    }
    
    // Novo método: Retorna o cabeçalho para o CSV
    public String cabecalho() {
        return "Nome,Semestre,Horario,Código,Ministrante\n"; // Ajuste conforme necessário
    }

    // Novo método: Converte os atributos para uma linha de CSV
    public String atributoToCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append(this.nome).append(",")
            .append(this.semestre).append(",")
            .append(this.horario).append(",")
            .append(this.codigoDisciplina).append(",")
            .append(this.ministrante.getCpf()).append("\n"); // Pode ajustar os dados do professor
            
        
        return csv.toString();
    }

    // Método para preencher os atributos a partir de uma linha CSV
    public void CSVToAtributo(String linha) {
        String[] dados = linha.split(",");
        this.nome = dados[0];
        this.semestre = Integer.parseInt(dados[1]);
        this.horario = dados[2];
        this.codigoDisciplina = Integer.parseInt(dados[3]);
        this.ministrante.setCpf(dados[4]); // Exemplo de atribuição simples
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(Professor ministrante) {
        this.ministrante = ministrante;
    }

    public Aluno[] getLstAlunos() {
        return lstAlunos;
    }

    public void setLstAlunos(Aluno[] lstAlunos) {
        this.lstAlunos = lstAlunos;
    }        

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
    
    
    
}
