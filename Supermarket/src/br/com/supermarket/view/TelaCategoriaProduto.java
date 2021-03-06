/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.view;

import br.com.supermarket.dao.CategoriaProdutoDAO;
import br.com.supermarket.model.CategoriaProduto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class TelaCategoriaProduto extends javax.swing.JFrame {
    
    CategoriaProduto categoriaProduto;
    private List<CategoriaProduto> lista;
    /**
     * Creates new form TelaCategoriaProduto
     */
    public TelaCategoriaProduto() {
        initComponents();
        limparCampos();
        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Categoria");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 185, 170));

        txtId.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        txtId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtId.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        txtNome.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btNovo.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/new.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btNovo.setMaximumSize(new java.awt.Dimension(95, 25));
        btNovo.setMinimumSize(new java.awt.Dimension(95, 25));
        btNovo.setPreferredSize(new java.awt.Dimension(85, 25));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/accept.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btSalvar.setMaximumSize(new java.awt.Dimension(95, 25));
        btSalvar.setMinimumSize(new java.awt.Dimension(95, 25));
        btSalvar.setPreferredSize(new java.awt.Dimension(85, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btExcluir.setPreferredSize(new java.awt.Dimension(85, 25));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbCategoria.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        tbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriaMouseClicked(evt);
            }
        });
        tbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbCategoriaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbCategoria);

        txtPesquisar.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        txtPesquisar.setToolTipText("Pesquisar Categoria");
        txtPesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/zoom.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel3.setText("Categoria do Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(281, 281, 281)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(1, 1, 1)))
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
    }    
    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        validaCampos();
    }//GEN-LAST:event_btSalvarActionPerformed

    public void validaCampos() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o Nome da categoria", "Aten????o!", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
        } else {
            //FuncionarioController funcionarioController = new FuncionarioController();        
            CategoriaProduto categoriaProduto = new CategoriaProduto();
            CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();

            categoriaProduto.setNome(txtNome.getText());
        
            if (txtId.getText().equals("")) {
                categoriaProdutoDAO.create(categoriaProduto);
            } else {
                categoriaProduto.setId((int)tbCategoria.getValueAt(tbCategoria.getSelectedRow(), 0));
                categoriaProdutoDAO.update(categoriaProduto);
            }
            readJTable();
            limparCampos();
        }
    }
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        CategoriaProduto categoriaProduto = new CategoriaProduto();
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        
        categoriaProduto.setId((int)tbCategoria.getValueAt(tbCategoria.getSelectedRow(), 0));
        
        categoriaProdutoDAO.delete(categoriaProduto);        
        readJTable();
        limparCampos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        readJTableForDesk(txtPesquisar.getText());
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriaMouseClicked
        limparCampos();
        eventoTabela();
    }//GEN-LAST:event_tbCategoriaMouseClicked

    private void tbCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCategoriaKeyReleased
        limparCampos();
        eventoTabela();
    }//GEN-LAST:event_tbCategoriaKeyReleased

    
    private void eventoTabela() {
        if (tbCategoria.getSelectedRow() != -1) {           
            
            txtId.setText(tbCategoria.getValueAt(tbCategoria.getSelectedRow(), 0).toString());
            txtNome.setText(tbCategoria.getValueAt(tbCategoria.getSelectedRow(), 1).toString());
            
            /* BUSCAR CAMPOS NO BANCO
            int id = (int) tbCategoria.getValueAt(tbCategoria.getSelectedRow(), 0);
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
            stmt = connection.prepareStatement("SELECT email_funcionario, login_funcionario, senha_funcionario"
                    + " FROM tb_funcionario WHERE id_funcionario ='" + id + "'");
            rs = stmt.executeQuery();
            rs.first();
            txtEmail.setText(rs.getString(1));
            txtLogin.setText(rs.getString(2));
            txtSenha.setText(rs.getString(3));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher formul??rio... " + e);
            } finally {
                ConexaoDB.closeConnection(connection, stmt, rs);
            }*/
        }
    }
    
    
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tbCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        
        for (CategoriaProduto categoriaProduto : categoriaProdutoDAO.read()) {            
            modelo.addRow(new Object[]{
                categoriaProduto.getId(),
                categoriaProduto.getNome(),
            });
        }
    }
    
    public void readJTableForDesk(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) tbCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        
        for (CategoriaProduto categoriaProduto : categoriaProdutoDAO.readForDesc(desc)) {            
            modelo.addRow(new Object[]{
                categoriaProduto.getId(),
                categoriaProduto.getNome(),
            });
        }
    }
    
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCategoriaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
