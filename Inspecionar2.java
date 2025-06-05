/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ryano
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Inspecionar2 extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(Inspecionar2.class.getName());
    private String categoriaSelecionada;

    public Inspecionar2(String categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
        initComponents();
        carregarTabela();
    }

    private void carregarTabela() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoquecrypto", "root", "Sonho2013");
            Statement stmt = conn.createStatement();

            String sql = "SELECT p.nome AS produto_nome, p.preco_unitario, p.quantidade_estoque, " +
             "(p.preco_unitario * p.quantidade_estoque) AS balanco " +
             "FROM produtos p " +
             "JOIN categorias c ON p.categoria_id = c.id " +
             "WHERE c.nome = '" + categoriaSelecionada + "'";

            ResultSet rs = stmt.executeQuery(sql);

            // Limpa a tabela atual
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Adiciona cada linha
            while (rs.next()) {
                String nome = rs.getString("produto_nome");

                double preco = rs.getDouble("preco_unitario");
                int quantidade = rs.getInt("quantidade_estoque");
                double balanco = rs.getDouble("balanco");

                model.addRow(new Object[]{nome, preco, quantidade, balanco});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados da categoria.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setEnabled(false);
        jScrollPane1.setName("xtudo"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOME", "PREÇO", "QUANTIDADE", "BALANÇO FISICO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Inspecionar2("Eletrônicos").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
