package sistemafaculdade;

public class Curso {

    private String nome;
    private String modalidade;
    private String turno;
    private String coordenador;
    private int cargaHoraria;
    private int vagas;

    public Curso(String nome, String modalidade, String turno,
                  String coordenador, int cargaHoraria, int vagas) {

        this.nome = nome;
        this.modalidade = modalidade;
        this.turno = turno;
        this.coordenador = coordenador;
        this.cargaHoraria = cargaHoraria;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getTurno() {
        return turno;
    }

    public String getCoordenador() {
        return coordenador;
    }

    // CORRIGIDO
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getVagas() {
        return vagas;
    }

    @Override
    public String toString() {
        return nome;
    }
}