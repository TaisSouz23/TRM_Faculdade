package sistemafaculdade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame implements Acionavel {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private SistemaFaculdade sistema;

    public TelaLogin(SistemaFaculdade sistema) {
        this.sistema = sistema;
        setTitle("Login - TRM Faculdade");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/sistemafaculdade/logo.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(logoImg));
        lblLogo.setBounds(160, 20, 120, 120);
        add(lblLogo);

        // Título
        JLabel lblTitulo = new JLabel("TRM Faculdade", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(0, 150, 450, 40);
        add(lblTitulo);

        // Subtítulo
        JLabel lblSub = new JLabel("Faça login para continuar", SwingConstants.CENTER);
        lblSub.setFont(new Font("Arial", Font.PLAIN, 13));
        lblSub.setForeground(Color.GRAY);
        lblSub.setBounds(0, 190, 450, 25);
        add(lblSub);

        // Label Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setBounds(80, 240, 80, 25);
        add(lblUsuario);

        // Campo Usuário
        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsuario.setBounds(80, 265, 290, 35);
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)),BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        add(txtUsuario);

        // Label Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
        lblSenha.setBounds(80, 315, 80, 25);
        add(lblSenha);

        // Campo Senha
        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSenha.setBounds(80, 340, 290, 35);
        txtSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)),BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        add(txtSenha);

        // Botão Login
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBounds(80, 400, 290, 45);
        btnLogin.setBackground(new Color(180, 30, 30));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(150, 20, 20));
            }
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(180, 30, 30));
            }
        });

        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());
            if (usuario.equals("admin") && senha.equals("1234")) {
                dispose();
                new TelaMenu(sistema).executar();
            } else {
                JOptionPane.showMessageDialog(null,
                    "Usuário ou senha incorretos!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        add(btnLogin);

        
    }

   

    @Override
    public void executar() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}