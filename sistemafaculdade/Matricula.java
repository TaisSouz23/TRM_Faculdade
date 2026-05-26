/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemafaculdade;

/**
 *
 * @author taisy
 */
public class Matricula {
    private String matriculaAluno;
    private String nomeCurso;
    
    public Matricula(String matriculaAluno, String nomeCurso) {
        this.matriculaAluno = matriculaAluno;
        this.nomeCurso = nomeCurso;
    }
    
    public String getMatriculaAluno() { return matriculaAluno; }
    public String getNomeCurso() { return nomeCurso; }
}
