package sistemafaculdade;

import java.awt.*;
import javax.swing.*;

public class TelaSplash extends JWindow {
    private JProgressBar progressBar;

    public TelaSplash() {
        setSize(450, 580);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.WHITE);
        painel.setOpaque(true);

        // Logo
        ImageIcon logo = new ImageIcon( getClass().getResource("/sistemafaculdade/logo.png"));
        Image img = logo.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        JLabel labelLogo = new JLabel(new ImageIcon(img));
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogo.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));

        // Texto
        JLabel labelTexto = new JLabel("Iniciando...", SwingConstants.CENTER);
        labelTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        labelTexto.setForeground(Color.DARK_GRAY);

        // Barra de progresso
        progressBar = new JProgressBar(0, 100);
        progressBar.setForeground(Color.RED);
        progressBar.setBackground(new Color(220, 220, 220));
        progressBar.setBorderPainted(false);
        progressBar.setPreferredSize(new Dimension(300, 6));

        // Painel inferior
        JPanel painelSul = new JPanel(new GridLayout(2, 1, 5, 10));
        painelSul.setBackground(Color.WHITE);
        painelSul.setOpaque(true);
        painelSul.setBorder(BorderFactory.createEmptyBorder(10, 60, 50, 60));
        painelSul.add(labelTexto);
        painelSul.add(progressBar);

        painel.add(labelLogo, BorderLayout.CENTER);
        painel.add(painelSul, BorderLayout.SOUTH);
        add(painel);

        // Animação — abre Login após carregar
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                final int val = i;
                SwingUtilities.invokeLater(() -> progressBar.setValue(val));
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dispose();
            SwingUtilities.invokeLater(() -> {
                SistemaFaculdade sistema = new SistemaFaculdade();
                new TelaLogin(sistema).setVisible(true);
            });
        }).start();
    }
}