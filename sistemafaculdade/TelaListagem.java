package sistemafaculdade;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TelaListagem extends JFrame implements Acionavel {

    private SistemaFaculdade sistema;
    
    private JTabbedPane tabbedPane;

    private JTable tabelaAlunos;
    private JTable tabelaCursos;

    private DefaultTableModel modeloAlunos;
    private DefaultTableModel modeloCursos;

    private DefaultTableCellRenderer renderer;

    public TelaListagem(SistemaFaculdade sistema) {

        this.sistema = sistema;
        setTitle("Listagem do Sistema");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        // Renderer
        renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(new Color(180, 30, 30));
                    c.setForeground(Color.WHITE);
                }
                c.setFont(new Font("Arial",Font.PLAIN,14));
                return c;
            }
        };

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Alunos",criarPainelAlunos());
        tabbedPane.addTab("Cursos",criarPainelCursos());
        tabbedPane.addTab("Estatísticas",criarPainelEstatisticas());

        add(tabbedPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        JButton btnAtualizar =new JButton("Atualizar");

        JButton btnFechar =new JButton("Fechar");
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);
        add(painelBotoes, BorderLayout.SOUTH);
        btnAtualizar.addActionListener(e -> atualizarTabelas());
        btnFechar.addActionListener(e -> dispose());
    }

    private JPanel criarPainelAlunos() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] colunas = {"Matrícula", "Nome", "Idade", "Email", "Telefone", "Turno", "Bolsista"};
        modeloAlunos = new DefaultTableModel(colunas, 0);
        tabelaAlunos = new JTable(modeloAlunos);
        configurarTabela(tabelaAlunos);
        atualizarTabelaAlunos();
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel criarPainelCursos() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] colunas = {"Nome", "Modalidade", "Turno", "Coordenador", "Carga Horária", "Vagas"};
        modeloCursos = new DefaultTableModel(colunas, 0);
        tabelaCursos = new JTable(modeloCursos);
        configurarTabela(tabelaCursos);
        atualizarTabelaCursos();
        JScrollPane scrollPane = new JScrollPane(tabelaCursos);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel criarPainelEstatisticas() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        List<Aluno> alunos = sistema.getAlunos();
        List<Curso> cursos = sistema.getCursos();
        int manha = 0;
        int tarde = 0;
        int noite = 0;
        int bolsistas = 0;
        for (Aluno a : alunos) {
            switch (a.getTurno()) {
                case "Manha":
                    manha++;
                    break;
                case "Tarde":
                    tarde++;
                    break;
                case "Noite":
                    noite++;
                    break;
            }
            if (a.isBolsista()) {
                bolsistas++;
            }
        }

        addCard(panel,"Total de Alunos", String.valueOf(alunos.size()));
        addCard(panel, "Total de Cursos", String.valueOf(cursos.size()));
        addCard(panel,"Manhã", String.valueOf(manha));
        addCard(panel, "Tarde", String.valueOf(tarde));
        addCard(panel, "Noite", String.valueOf(noite));
        addCard(panel, "Bolsistas", String.valueOf(bolsistas));
        return panel;
    }

    private void addCard(JPanel panel, String titulo,String valor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD,14));
        JLabel lblValor = new JLabel(valor, SwingConstants.CENTER);
        lblValor.setFont(new Font("Arial", Font.BOLD, 24));
        card.add(lblTitulo, BorderLayout.NORTH);
        card.add(lblValor, BorderLayout.CENTER);
        panel.add(card);
    }

    private void configurarTabela(JTable tabela) {
        tabela.setRowHeight(25);
        tabela.setDefaultRenderer(Object.class, renderer);
        JTableHeader header = tabela.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void atualizarTabelaAlunos() {
        modeloAlunos.setRowCount(0);
        for (Aluno a : sistema.getAlunos()) {
            modeloAlunos.addRow(new Object[]{
                    a.getMatricula(),
                    a.getNome(),
                    a.getIdade(),
                    a.getEmail(),
                    a.getTelefone(),
                    a.getTurno(),
                    a.isBolsista() ? "Sim" : "Não"
            });
        }
    }

    private void atualizarTabelaCursos() {
        modeloCursos.setRowCount(0);
        for (Curso c : sistema.getCursos()) {
            modeloCursos.addRow(new Object[]{
                    c.getNome(),
                    c.getModalidade(),
                    c.getTurno(),
                    c.getCoordenador(),
                    c.getCargaHoraria(),
                    c.getVagas()
            });
        }
    }

    private void atualizarTabelas() {
        atualizarTabelaAlunos();
        atualizarTabelaCursos();
        tabbedPane.setComponentAt(2, criarPainelEstatisticas());
        revalidate();
        repaint();
        JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
    }

    @Override
    public void executar() {
        setVisible(true);
    }
}