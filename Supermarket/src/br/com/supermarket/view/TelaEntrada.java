/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermarket.view;

import br.com.supermarket.model.Funcionario;
import gui.Chatbot;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/* IMPORTAR O CHATBOT */

/**
 *
 * @author Gustavo
 */
public class TelaEntrada extends javax.swing.JFrame {
    
    public static int IDfuncLog = 0;
    public static String nomeFuncLog = "";
    public static String acessoFuncLog = "";
    
    public void funcLogado(Funcionario funcLog) {
        IDfuncLog = funcLog.getId();
        nomeFuncLog = funcLog.getNome();
        acessoFuncLog = funcLog.getAcesso();
        validaAcesso();
    }
    
    /**
     * Creates new form TelaEntrada
     */
    public TelaEntrada() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        /* Produto */
        btProdutoCat.setEnabled(false);
        btProdutoCat.setVisible(false);
        btProdut.setEnabled(false);
        btProdut.setVisible(false);
        btFornecedor.setEnabled(false);
        btFornecedor.setVisible(false);
        /* Venda */
        btVenda1.setEnabled(false);
        btVenda1.setVisible(false);
    }
    
    public void validaAcesso() {        
        geraRelatorio("LogIn: ---");
        if (!acessoFuncLog.equals("Administrador")) {
            //System.out.println("Tela limitada");
            /*btVenda1.setEnabled(true);
            btVenda1.setVisible(true);*/
            btVenda.setEnabled(true);
            btVenda.setVisible(true);
            
            btTelaFuncionario.setEnabled(false); btTelaFuncionario.setVisible(false);
            btProduto.setEnabled(false); btProduto.setVisible(false);
            btRelatorio.setEnabled(false); btRelatorio.setVisible(false);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblSaudar = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        btTelaFuncionario = new javax.swing.JToggleButton();
        btProduto = new javax.swing.JToggleButton();
        btVenda = new javax.swing.JToggleButton();
        btProdutoCat = new javax.swing.JToggleButton();
        btProdut = new javax.swing.JToggleButton();
        btVenda1 = new javax.swing.JToggleButton();
        btAjuda = new javax.swing.JToggleButton();
        btFornecedor = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btLogoff = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermarket");
        setBackground(new java.awt.Color(51, 255, 0));
        setFont(new java.awt.Font("Modern No. 20", 0, 12)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(101, 189, 172));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 550));

        lblSaudar.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblSaudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/calendar_view_week.png"))); // NOI18N
        lblSaudar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblHora.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        lblHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/clock_red.png"))); // NOI18N

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/cancel.png"))); // NOI18N
        btSair.setToolTipText("Sair - Encerrar");
        btSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btTelaFuncionario.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        btTelaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/funcionario.png"))); // NOI18N
        btTelaFuncionario.setText("Funcionário");
        btTelaFuncionario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btTelaFuncionario.setFocusPainted(false);
        btTelaFuncionario.setPreferredSize(new java.awt.Dimension(175, 60));
        btTelaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaFuncionarioActionPerformed(evt);
            }
        });

        btProduto.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        btProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/produto.png"))); // NOI18N
        btProduto.setText("Produto");
        btProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btProduto.setFocusPainted(false);
        btProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutoActionPerformed(evt);
            }
        });

        btVenda.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        btVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/venda.png"))); // NOI18N
        btVenda.setText("Venda");
        btVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btVenda.setFocusPainted(false);
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });

        btProdutoCat.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btProdutoCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/categoria.png"))); // NOI18N
        btProdutoCat.setText("Categoria");
        btProdutoCat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btProdutoCat.setPreferredSize(new java.awt.Dimension(145, 40));
        btProdutoCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutoCatActionPerformed(evt);
            }
        });

        btProdut.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btProdut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/produto2.png"))); // NOI18N
        btProdut.setText("Produto");
        btProdut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btProdut.setPreferredSize(new java.awt.Dimension(145, 40));
        btProdut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutActionPerformed(evt);
            }
        });

        btVenda1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btVenda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/venda2.png"))); // NOI18N
        btVenda1.setText("Venda");
        btVenda1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btVenda1.setPreferredSize(new java.awt.Dimension(145, 40));
        btVenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenda1ActionPerformed(evt);
            }
        });

        btAjuda.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/ajuda.png"))); // NOI18N
        btAjuda.setText("Ajuda");
        btAjuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btAjuda.setPreferredSize(new java.awt.Dimension(120, 40));
        btAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjudaActionPerformed(evt);
            }
        });

        btFornecedor.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/produto2.png"))); // NOI18N
        btFornecedor.setText("Fornecedor");
        btFornecedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btFornecedor.setPreferredSize(new java.awt.Dimension(145, 40));
        btFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFornecedorActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/supermarket.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 4, true));

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 24)); // NOI18N
        jLabel2.setText("Supermarket");

        btLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons 1/group_gear.png"))); // NOI18N
        btLogoff.setToolTipText("Trocar de Usuário - Logoff");
        btLogoff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoffActionPerformed(evt);
            }
        });

        btRelatorio.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        btRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img special_icons/relatorio.png"))); // NOI18N
        btRelatorio.setText("Relatórios do Sistema");
        btRelatorio.setToolTipText("Relatórios do Sistema");
        btRelatorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btRelatorio.setPreferredSize(new java.awt.Dimension(235, 40));
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(btTelaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 294, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSaudar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btProdutoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btProdut, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSair)
                    .addComponent(btLogoff))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTelaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btProdut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProdutoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaudar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // CÓDIGO NECESSÁRIO PARA MOSTRAR A HORA
    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // DATA
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("E dd/MM/yyyy");        
        // HORA
        Timer timer = new Timer(1000, new hora());
        timer.start();
        lblSaudar.setText(formato.format(dataSistema) + " - Olá " + nomeFuncLog);
    }//GEN-LAST:event_formWindowOpened

    public void geraRelatorio(String relatorio) {
        // DATA E HORA
        Date dataSistema = new Date();
        //SimpleDateFormat formato = new SimpleDateFormat("E dd/MM/yyyy hh:mm:ss");
        DateFormat formato = new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss");
        //System.out.println(new File(".").getAbsolutePath());
        String content = relatorio + " Funcionário: " + nomeFuncLog + 
            " || Data: " + formato.format(dataSistema) + "\n";
        
        /*String arquivoRelatorio = System.getProperty("user.home") + File.separator +
                "Desktop" + File.separator + "Relatorio_Login-Logout.txt";*/
        String arquivoRelatorio = (new File("Relatorio_Login-Logout.txt").getAbsolutePath());
        try(FileWriter fw = new FileWriter(arquivoRelatorio, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
            out.println(content);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar Relatório", "Erro", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        geraRelatorio("LogOut: --");
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjudaActionPerformed
        Chatbot chatbot = new Chatbot();
        chatbot.setVisible(true);
    }//GEN-LAST:event_btAjudaActionPerformed

    private void btTelaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaFuncionarioActionPerformed
        /* PRODUTO */
        btProdutoCat.setEnabled(false);
        btProdutoCat.setVisible(false);
        btProdut.setVisible(false);
        btProdut.setEnabled(false);
        btFornecedor.setEnabled(false);
        btFornecedor.setVisible(false);
        TelaFuncionario telaFuncionario = new TelaFuncionario();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_btTelaFuncionarioActionPerformed

    private void btProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutoActionPerformed
        /* VENDA */
        /*btVenda1.setEnabled(false);
        btVenda1.setVisible(false);*/
        /* RELATORIO */
        btRelatorio.setVisible(true);
        btRelatorio.setEnabled(true);
        /* PRODUTO */
        btProdutoCat.setVisible(true);
        btProdutoCat.setEnabled(true);
        btProdut.setVisible(true);
        btProdut.setEnabled(true);
        btFornecedor.setEnabled(true);
        btFornecedor.setVisible(true);
    }//GEN-LAST:event_btProdutoActionPerformed

    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        /* PRODUTO */
        btProdutoCat.setEnabled(false);
        btProdutoCat.setVisible(false);
        btProdut.setVisible(false);
        btProdut.setEnabled(false);
        btFornecedor.setEnabled(false);
        btFornecedor.setVisible(false);
        /* VENDA */
        /*btVenda1.setVisible(true);
        btVenda1.setEnabled(true);*/
        TelaVenda telaVenda = new TelaVenda();
        telaVenda.setVisible(true);
    }//GEN-LAST:event_btVendaActionPerformed

    private void btVenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenda1ActionPerformed
        TelaVenda telaVenda = new TelaVenda();
        telaVenda.setVisible(true);
    }//GEN-LAST:event_btVenda1ActionPerformed

    private void btProdutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutActionPerformed
        TelaProduto telaProduto = new TelaProduto();
        telaProduto.setVisible(true);
    }//GEN-LAST:event_btProdutActionPerformed

    private void btProdutoCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutoCatActionPerformed
        TelaCategoriaProduto telaCategoriaProduto = new TelaCategoriaProduto();
        telaCategoriaProduto.setVisible(true);
    }//GEN-LAST:event_btProdutoCatActionPerformed

    private void btFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFornecedorActionPerformed
        TelaFornecedor telaFornecedor = new TelaFornecedor();
        telaFornecedor.setVisible(true);
    }//GEN-LAST:event_btFornecedorActionPerformed

    private void btLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoffActionPerformed
        try {
            this.dispose();
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
            geraRelatorio("LogOut: --");
        } catch (Throwable ex) {
            Logger.getLogger(TelaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btLogoffActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        RelatorioSistema relatorioSistema = new RelatorioSistema();
        relatorioSistema.setVisible(true);
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        geraRelatorio("LogOut: --");
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        geraRelatorio("LogOut: --");
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAjuda;
    private javax.swing.JToggleButton btFornecedor;
    private javax.swing.JButton btLogoff;
    private javax.swing.JToggleButton btProdut;
    private javax.swing.JToggleButton btProduto;
    private javax.swing.JToggleButton btProdutoCat;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btSair;
    private javax.swing.JToggleButton btTelaFuncionario;
    private javax.swing.JToggleButton btVenda;
    private javax.swing.JToggleButton btVenda1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblSaudar;
    // End of variables declaration//GEN-END:variables

}
