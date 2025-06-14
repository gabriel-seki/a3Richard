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

public class FrontInpecionar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrontInpecionar.class.getName());

    /**
     * Creates new form FrontInpecionar
     */
    public FrontInpecionar() {
        initComponents();
        carregarProdutos();      // <-- ADICIONE ESTA LINHA
        carregarCategorias();  
        configurarBotao();       // <-- E ESTA LINHA
    jComboBox1.addActionListener(evt -> {
    if (jComboBox1.getSelectedItem() != null && !jComboBox1.getSelectedItem().toString().isEmpty()) {
        jComboBox2.setSelectedIndex(-1); // remove seleção da categoria
    }
});
jComboBox2.addActionListener(evt -> {
    if (jComboBox2.getSelectedItem() != null && !jComboBox2.getSelectedItem().toString().isEmpty()) {
        jComboBox1.setSelectedIndex(-1); // remove seleção do produto
    }
});
    }
      
   
private void carregarProdutos() {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoquecrypto", "root", "Sonho2013");
        Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT nome FROM produtos ORDER BY nome ASC");

        jComboBox1.removeAllItems(); // Limpa os itens antigos

        while (rs.next()) {
            jComboBox1.addItem(rs.getString("nome"));
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar produtos.");
    }
}
private void carregarCategorias() {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoquecrypto", "root", "Sonho2013");
        Statement stmt = conn.createStatement();

        String sql = "SELECT DISTINCT c.nome FROM categorias c " +
                     "JOIN produtos p ON p.categoria_id = c.id " +
                     "ORDER BY c.nome ASC";

        ResultSet rs = stmt.executeQuery(sql);

        jComboBox2.removeAllItems(); // Limpa os itens antigos

        while (rs.next()) {
            jComboBox2.addItem(rs.getString("nome"));
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar categorias.");
    }
}
private void configurarBotao() {
    jButton1.addActionListener(e -> {
        String produtoSelecionado = (String) jComboBox1.getSelectedItem();
        String categoriaSelecionada = (String) jComboBox2.getSelectedItem();
        if (produtoSelecionado != null && !produtoSelecionado.isEmpty() && !produtoSelecionado.equals("Item 1")) {
            FrontInspecionar1 telaProduto = new FrontInspecionar1(produtoSelecionado);
            telaProduto.setVisible(true);
            dispose();
        
        } else if (categoriaSelecionada != null && !categoriaSelecionada.isEmpty() && !categoriaSelecionada.equals("Item 1")) {
            Inspecionar2 telaCategoria = new Inspecionar2(categoriaSelecionada);

            // Aqui você pode passar a categoria selecionada para a nova tela, se quiser
            telaCategoria.setVisible(true);
            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto ou uma categoria.");
        }
    });
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Próximo");

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Produtos");

        jLabel2.setText("Categorias");

        jLabel3.setText("SELECIONE UMA DAS OPÇÕES ABAIXO");
        jLabel3.setMaximumSize(new java.awt.Dimension(300, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new FrontCentral().setVisible(true);  // Abre a tela central
    dispose(); // Fecha a tela atual
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrontInpecionar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

