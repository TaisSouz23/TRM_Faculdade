package sistemafaculdade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu extends JFrame implements Acionavel {

    private SistemaFaculdade sistema;

    public TelaMenu(SistemaFaculdade sistema) {
        this.sistema = sistema;
        setTitle("Menu Principal - TRM Faculdade");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(235, 235, 235));

        // Título
        JLabel lblTitulo = new JLabel("TRM Faculdade", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 52));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(0, 40, 900, 80);
        add(lblTitulo);

        // Botões
        JButton btnCadastrarAluno = criarBotao("Cadastrar Aluno");
        JButton btnCadastrarCurso = criarBotao("Cadastrar Curso");
        JButton btnMatricula      = criarBotao("Matricula");
        JButton btnListagem       = criarBotao("Listagem");

        // Posicionamento
        int x = 270, largura = 360, altura = 68, espaco = 82;
        btnCadastrarAluno.setBounds(x, 155, largura, altura);
        btnCadastrarCurso.setBounds(x, 155 + espaco, largura, altura);
        btnMatricula.setBounds(x, 155 + espaco * 2, largura, altura);
        btnListagem.setBounds(x, 155 + espaco * 3, largura, altura);

        add(btnCadastrarAluno);
        add(btnCadastrarCurso);
        add(btnMatricula);
        add(btnListagem);

        // Logo canto inferior direito
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/sistemafaculdade/logo.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(logoImg));
        lblLogo.setBounds(730, 480, 140, 140);
        add(lblLogo);

        // Actions
        btnCadastrarAluno.addActionListener(e -> new TelaCadastroAluno(sistema).executar());
        btnCadastrarCurso.addActionListener(e -> new TelaCadastroCurso(sistema).executar());
        btnMatricula.addActionListener(e -> new TelaMatricula(sistema).executar());
        btnListagem.addActionListener(e -> new TelaListagem(sistema).executar());
       
    }

    private JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(228, 228, 228));
        btn.setForeground(new Color(40, 40, 40));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(200, 200, 200));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(228, 228, 228));
            }
        });
        return btn;
    }

   

    @Override
    public void executar() {
        setVisible(true);
    }
}