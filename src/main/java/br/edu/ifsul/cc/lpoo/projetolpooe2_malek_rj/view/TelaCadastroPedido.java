/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.view;

import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model.Alimento;
import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model.Pedido;
import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model.StatusPedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author malek
 */
public class TelaCadastroPedido extends javax.swing.JDialog {

    PersistenciaJPA jpa;
    private Pedido pedido;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultListModel<Alimento> mascaraItemLista = new DefaultListModel<>();

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Creates new form TelaCadastroPedido
     */
    public TelaCadastroPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public void listarInformacoes() {

        List<Alimento> list = new ArrayList();

        try {
            jpa = new PersistenciaJPA();
            Pedido p = (Pedido) jpa.find(Pedido.class, pedido.getId());
            list = p.getAlimentos();
            for (Alimento a : list) {
                mascaraItemLista.addElement(a);
            }
            jListAlimentos.setModel(mascaraItemLista);
            txtData.setText(sdf.format(p.getData().getTime()));
            jCBoxStatus.setSelectedItem(p.getStatus());
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarStatus() {

        List<StatusPedido> listStatus = new ArrayList();

        listStatus.add(StatusPedido.NOVO);
        listStatus.add(StatusPedido.EM_PREPARACAO);
        listStatus.add(StatusPedido.EM_ROTA);
        listStatus.add(StatusPedido.ENTREGUE);
        listStatus.add(StatusPedido.FINALIZADO);

        for (StatusPedido s : listStatus) {
            jCBoxStatus.addItem(s);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBoxStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAlimentos = new javax.swing.JList<>();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Pedido");

        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Data");

        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Status");

        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Produtos");

        btnSalvar.setForeground(new java.awt.Color(0, 51, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setForeground(new java.awt.Color(0, 51, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListAlimentos);

        btnRemove.setForeground(new java.awt.Color(0, 51, 255));
        btnRemove.setText("-");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setForeground(new java.awt.Color(0, 51, 255));
        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(339, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addGap(49, 49, 49)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(166, Short.MAX_VALUE)
                    .addComponent(btnAdd)
                    .addGap(128, 128, 128)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (pedido == null) {
            Date date;
            try {
                pedido = new Pedido();

                if (txtData.getText() != null && !txtData.getText().trim().isEmpty()) {
                    date = sdf.parse(txtData.getText());

                } else {
                    date = new Date();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                pedido.setData(calendar);

                pedido.setStatus((StatusPedido) jCBoxStatus.getSelectedItem());

                for (int i = 0; i < mascaraItemLista.size(); i++) {
                    Alimento alimento = (Alimento) mascaraItemLista.getElementAt(i);
                    pedido.addAlimento(alimento, 1);
                }
                
                pedido.somaTotal();

                jpa = new PersistenciaJPA();
                jpa.conexaoAberta();
                jpa.persist(pedido);
                jpa.fecharConexao();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao inserir um novo pedido!");
                System.out.println("ErRO: " + ex.getMessage());
            }
        } else {

            jpa = new PersistenciaJPA();

            try {
                Pedido p = new Pedido();
                p = pedido;
                p = (Pedido) jpa.find(Pedido.class, p.getId());

                p.setStatus((StatusPedido) jCBoxStatus.getSelectedItem());

                List<Alimento> lst = new ArrayList();

                for (int i = 0; i < mascaraItemLista.getSize(); i++) {
                    lst.add(mascaraItemLista.getElementAt(i));
                }

                p.setAlimentos(lst);
                p.somaTotal();
                jpa.conexaoAberta();
                jpa.persist(p);
                jpa.fecharConexao();
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao editar o pedido!");
                System.out.println("erro: " + e.getMessage());

            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        TelaAdicionarAlimento telaAlimento = new TelaAdicionarAlimento(this, true);
        //telaAlimento.listarStatus();
        //telaCadastro.listarAlimentos();
        telaAlimento.setLocationRelativeTo(this);
        telaAlimento.setVisible(true);

        Alimento a = telaAlimento.getAlimentoSelecionado();

        mascaraItemLista.addElement(a);
        jListAlimentos.setModel(mascaraItemLista);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int alimSelecionado = jListAlimentos.getSelectedIndex();
        if (alimSelecionado != -1) {
            mascaraItemLista.removeElementAt(alimSelecionado);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroPedido dialog = new TelaCadastroPedido(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<StatusPedido> jCBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<Alimento> jListAlimentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
