package sistemafaculdade;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCurso extends JFrame
        implements Acionavel {

    private SistemaFaculdade sistema;

    private JTextField txtNome;
    private JTextField txtCargaHoraria;
    private JTextField txtTurno;
    private JTextField txtCoordenador;
    private JTextField txtVagas;

    private JComboBox<String> cbModalidade;

    private JButton btnSalvar;
    private JButton btnPesquisar;
    private JButton btnAlterar;
    private JButton btnExcluir;

    public TelaCadastroCurso(SistemaFaculdade sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Cursos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 8, 8));
        //Campo Nome
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);
        //Campo Carga Horária
        add(new JLabel("Carga Horária:"));
        txtCargaHoraria = new JTextField();
        add(txtCargaHoraria);
        //Campo Modalidade
        add(new JLabel("Modalidade:"));
        cbModalidade = new JComboBox<>(new String[]{"Presencial", "EAD", "Híbrido"});
        add(cbModalidade);
        //Campo Turno
        add(new JLabel("Turno:"));
        txtTurno = new JTextField();
        add(txtTurno);
        //Campo Coordenador
        add(new JLabel("Coordenador:"));
        txtCoordenador = new JTextField();
        add(txtCoordenador);
        //Campo Vagas
        add(new JLabel("Vagas:"));
        txtVagas = new JTextField();
        add(txtVagas);
        //Botões
        btnSalvar = new JButton("Salvar");
        btnPesquisar = new JButton("Pesquisar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        
        add(btnSalvar);
        add(btnPesquisar);
        add(btnAlterar);
        add(btnExcluir);
        
        btnSalvar.addActionListener(e -> salvarCurso());
        btnPesquisar.addActionListener(e -> pesquisarCurso());
        btnAlterar.addActionListener(e -> alterarCurso());
        btnExcluir.addActionListener(e -> excluirCurso());

      
    }

    
    private void salvarCurso() {
        try {
            String nome = txtNome.getText().trim();
            int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText().trim());
            String modalidade = (String) cbModalidade.getSelectedItem();
            String turno = txtTurno.getText().trim();
            String coordenador = txtCoordenador.getText().trim();
            int vagas = Integer.parseInt(txtVagas.getText().trim());
            if (nome.isEmpty() || turno.isEmpty() || coordenador.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }
            if (sistema.pesquisarCurso(nome) != null) {
                JOptionPane.showMessageDialog(this, "Curso já existe.");
                return;
            }
            Curso curso = new Curso(nome, modalidade, turno, coordenador, cargaHoraria, vagas);
            sistema.adicionarCurso(curso);
            JOptionPane.showMessageDialog(this,"Curso salvo com sucesso!");
            limparCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Carga horária e vagas devem ser números.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Erro: " + ex.getMessage());
        }
    }

    private void pesquisarCurso() {
        String nome = txtNome.getText().trim();
        Curso curso = sistema.pesquisarCurso(nome);
        if (curso != null) {
            txtCargaHoraria.setText(String.valueOf(curso.getCargaHoraria()));
            cbModalidade.setSelectedItem(curso.getModalidade());
            txtTurno.setText(curso.getTurno());
            txtCoordenador.setText(curso.getCoordenador());
            txtVagas.setText(String.valueOf(curso.getVagas()));
        } else {
            JOptionPane.showMessageDialog(this,"Curso não encontrado.");
        }
    }

    private void alterarCurso() {
        try {
            String nome = txtNome.getText().trim();
            int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText().trim());
            String modalidade = (String) cbModalidade.getSelectedItem();
            String turno = txtTurno.getText().trim();
            String coordenador = txtCoordenador.getText().trim();
            int vagas = Integer.parseInt(txtVagas.getText().trim());
            Curso cursoAtualizado = new Curso(nome, modalidade, turno, coordenador, cargaHoraria, vagas);
            boolean alterado = sistema.alterarCurso(nome,cursoAtualizado);
            if (alterado) {
                JOptionPane.showMessageDialog(this, "Curso alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Curso não encontrado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void excluirCurso() {
        String nome = txtNome.getText().trim();
        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja excluir este curso?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean excluido = sistema.excluirCurso(nome);
            if (excluido) {
                JOptionPane.showMessageDialog(this, "Curso excluído com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Curso não encontrado.");
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCargaHoraria.setText("");
        txtTurno.setText("");
        txtCoordenador.setText("");
        txtVagas.setText("");
        cbModalidade.setSelectedIndex(0);
    }

    @Override
    public void executar() {
        setVisible(true);
    }
}