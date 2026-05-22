package sistemafaculdade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SistemaFaculdade {
    private List<Aluno> alunos;
    private List<Curso> cursos;
    private List<Matricula> matriculas;

    public SistemaFaculdade() {
        this.alunos = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Aluno pesquisarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public boolean alterarAluno(String matriculaAntiga, Aluno novoAluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matriculaAntiga)) {
                alunos.set(i, novoAluno);
                return true;
            }
        }
        return false;
    }

    public boolean excluirAluno(String matricula) {
        Iterator<Aluno> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getMatricula().equals(matricula)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Aluno> getAlunos() { return new ArrayList<>(alunos); }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public Curso pesquisarCurso(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null;
    }

    public boolean alterarCurso(String nomeAntigo, Curso novoCurso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNome().equals(nomeAntigo)) {
                cursos.set(i, novoCurso);
                return true;
            }
        }
        return false;
    }

    public boolean excluirCurso(String nome) {
        Iterator<Curso> iterator = cursos.iterator();
        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            if (curso.getNome().equals(nome)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Curso> getCursos() { return new ArrayList<>(cursos); }

    public void adicionarMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Matricula> getMatriculas() { return new ArrayList<>(matriculas); }
}
