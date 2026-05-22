package sistemafaculdade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaMatricula extends JFrame implements Acionavel {

    private SistemaFaculdade sistema;
    private JComboBox<Aluno> cbAlunos;
    private JComboBox<Curso> cbCursos;
    private JButton btnMatricular;
    private DefaultTableModel tableModel;
    private JTable tabela;

    public TelaMatricula(SistemaFaculdade sistema) {
        this.sistema = sistema;
        setTitle("Matricula");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        JPanel painelTopo = new JPanel(new GridLayout(3, 2, 8, 8));

        painelTopo.add(new JLabel("Aluno:"));
        cbAlunos = new JComboBox<>();
        for (Aluno a : sistema.getAlunos()) {
            cbAlunos.addItem(a);
        }
        painelTopo.add(cbAlunos);

        painelTopo.add(new JLabel("Curso:"));
        cbCursos = new JComboBox<>();
        for (Curso c : sistema.getCursos()) {
            cbCursos.addItem(c);
        }
        painelTopo.add(cbCursos);

        btnMatricular = new JButton("Matricular");
        painelTopo.add(new JLabel());
        painelTopo.add(btnMatricular);

        tableModel = new DefaultTableModel(
            new String[]{"Matricula do Aluno", "Nome do Aluno", "Curso"}, 0
        );
        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(painelTopo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnMatricular.addActionListener(e -> matricular());
        
        
    }

    
    private void matricular() {
        Aluno aluno = (Aluno) cbAlunos.getSelectedItem();
        Curso curso = (Curso) cbCursos.getSelectedItem();

        if (aluno == null || curso == null) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno e um curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Matricula matricula = new Matricula(aluno.getMatricula(), curso.getNome());
        sistema.adicionarMatricula(matricula);

        tableModel.addRow(new Object[]{
            aluno.getMatricula(),
            aluno.getNome(),
            curso.getNome()
        });

        JOptionPane.showMessageDialog(this, aluno.getNome() + " matriculado em " + curso.getNome() + " com sucesso!");
    }

    @Override
    public void executar() {
        setVisible(true);
    }
}
