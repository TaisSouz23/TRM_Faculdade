package sistemafaculdade;

public class Aluno {
    private String nome;
    private String matricula;
    private int idade;
    private String email;
    private String telefone;
    private String turno;
    private boolean bolsista;

    public Aluno(String nome, String matricula, int idade, String email,
                 String telefone, String turno, boolean bolsista) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.turno = turno;
        this.bolsista = bolsista;
    }

    public String getNome() {
        return nome; }
    public String getMatricula() 
    { return matricula; }
    public int getIdade() 
    { return idade; }
    public String getEmail() 
    { return email; }
    public String getTelefone() 
    { return telefone; }
    public String getTurno() 
    { return turno; }
    public boolean isBolsista() 
    { return bolsista; }

    public void setNome(String nome) { this.nome = nome; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setTurno(String turno) { this.turno = turno; }
    public void setBolsista(boolean bolsista) { this.bolsista = bolsista; }

    @Override
    public String toString() {
        return nome + " - Matricula: " + matricula;
    }
}
