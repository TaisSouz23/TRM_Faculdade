package sistemafaculdade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroAluno extends JFrame implements Acionavel {
    private SistemaFaculdade sistema;
    private JTextField txtNome, txtMatricula, txtIdade, txtEmail, txtTelefone;
    private JRadioButton rbManha, rbTarde, rbNoite;
    private JCheckBox cbBolsista;
    private JButton btnSalvar, btnAlterar, btnPesquisar, btnExcluir;
    private ButtonGroup grupoTurno;

    public TelaCadastroAluno(SistemaFaculdade sistema) {
        this.sistema = sistema;
        setTitle("Cadastro de Alunos");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        int y = 0;
        try {
            ImageIcon headerIcon = new ImageIcon(getClass().getResource("/imagens/header_cadastro.png"));
            if (headerIcon.getIconWidth() > 0) {
                JLabel lblHeader = new JLabel(headerIcon);
                lblHeader.setBounds(10, 10, headerIcon.getIconWidth(), headerIcon.getIconHeight());
                add(lblHeader);
                y = headerIcon.getIconHeight() + 20;
            }
        } catch (Exception e) {}

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20 + y, 80, 25);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(100, 20 + y, 200, 25);
        add(txtNome);

        JLabel lblMatricula = new JLabel("Matricula:");
        lblMatricula.setBounds(20, 50 + y, 80, 25);
        add(lblMatricula);
        txtMatricula = new JTextField();
        txtMatricula.setBounds(100, 50 + y, 200, 25);
        add(txtMatricula);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 80 + y, 80, 25);
        add(lblIdade);
        txtIdade = new JTextField();
        txtIdade.setBounds(100, 80 + y, 200, 25);
        add(txtIdade);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 110 + y, 80, 25);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 110 + y, 200, 25);
        add(txtEmail);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 140 + y, 80, 25);
        add(lblTelefone);
        txtTelefone = new JTextField();
        txtTelefone.setBounds(100, 140 + y, 200, 25);
        add(txtTelefone);

        JLabel lblTurno = new JLabel("Turno:");
        lblTurno.setBounds(20, 170 + y, 80, 25);
        add(lblTurno);
        rbManha = new JRadioButton("Manha");
        rbManha.setBounds(100, 170 + y, 80, 25);
        add(rbManha);
        rbTarde = new JRadioButton("Tarde");
        rbTarde.setBounds(180, 170 + y, 80, 25);
        add(rbTarde);
        rbNoite = new JRadioButton("Noite");
        rbNoite.setBounds(260, 170 + y, 80, 25);
        add(rbNoite);

        grupoTurno = new ButtonGroup();
        grupoTurno.add(rbManha);
        grupoTurno.add(rbTarde);
        grupoTurno.add(rbNoite);

        cbBolsista = new JCheckBox("Bolsista");
        cbBolsista.setBounds(20, 200 + y, 100, 25);
        add(cbBolsista);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20, 240 + y, 100, 30);
        add(btnSalvar);
        btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(130, 240 + y, 100, 30);
        add(btnAlterar);
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(240, 240 + y, 100, 30);
        add(btnPesquisar);
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 240 + y, 100, 30);
        add(btnExcluir);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { salvarAluno(); }
        });
        btnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { pesquisarAlunoNaTela(); }
        });
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { alterarAlunoNaTela(); }
        });
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { excluirAlunoNaTela(); }
        });
        
    }

    private void salvarAluno() {
        try {
            String nome = txtNome.getText();
            String matricula = txtMatricula.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();
            String turno = "";
            if (rbManha.isSelected()) turno = "Manha";
            else if (rbTarde.isSelected()) turno = "Tarde";
            else if (rbNoite.isSelected()) turno = "Noite";
            boolean bolsista = cbBolsista.isSelected();

            if (sistema.pesquisarAluno(matricula) != null) {
                JOptionPane.showMessageDialog(this, "Matricula ja existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            sistema.adicionarAluno(new Aluno(nome, matricula, idade, email, telefone, turno, bolsista));
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pesquisarAlunoNaTela() {
        String matricula = txtMatricula.getText();
        Aluno aluno = sistema.pesquisarAluno(matricula);
        if (aluno != null) {
            txtNome.setText(aluno.getNome());
            txtIdade.setText(String.valueOf(aluno.getIdade()));
            txtEmail.setText(aluno.getEmail());
            txtTelefone.setText(aluno.getTelefone());
            if (aluno.getTurno().equals("Manha")) rbManha.setSelected(true);
            else if (aluno.getTurno().equals("Tarde")) rbTarde.setSelected(true);
            else if (aluno.getTurno().equals("Noite")) rbNoite.setSelected(true);
            cbBolsista.setSelected(aluno.isBolsista());
        } else {
            JOptionPane.showMessageDialog(this, "Nao encontrado.");
        }
    }

    private void alterarAlunoNaTela() {
        try {
            String matriculaAntiga = txtMatricula.getText();
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();
            String turno = "";
            if (rbManha.isSelected()) turno = "Manha";
            else if (rbTarde.isSelected()) turno = "Tarde";
            else if (rbNoite.isSelected()) turno = "Noite";
            boolean bolsista = cbBolsista.isSelected();

            Aluno alunoAtualizado = new Aluno(nome, matriculaAntiga, idade, email, telefone, turno, bolsista);
            if (sistema.alterarAluno(matriculaAntiga, alunoAtualizado)) {
                JOptionPane.showMessageDialog(this, "Alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Matricula nao encontrada.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void excluirAlunoNaTela() {
        String matricula = txtMatricula.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja excluir este aluno?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (sistema.excluirAluno(matricula)) {
                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Matricula nao encontrada.");
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtMatricula.setText("");
        txtIdade.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        grupoTurno.clearSelection();
        cbBolsista.setSelected(false);
    }
    

    @Override
    public void executar() {
        setVisible(true);
    }
}