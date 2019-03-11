package br.com.jonathan.crud.view;

import br.com.jonathan.crud.dao.DaoProduto;
import br.com.jonathan.crud.model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jonathan.medeiros
 */
public class TelaLista extends javax.swing.JFrame implements ActionListener{

    private DaoProduto dp;
    private TelaEdicao te;
    
    public TelaLista() {
        initComponents();
        dp = new DaoProduto();
        
        listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lista = ObservableCollections.observableList(new ArrayList<Produto>());
        jPDados = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPDados.setBackground(new java.awt.Color(211, 211, 211));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDadosLayout = new javax.swing.GroupLayout(jPDados);
        jPDados.setLayout(jPDadosLayout);
        jPDadosLayout.setHorizontalGroup(
            jPDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addContainerGap())
        );
        jPDadosLayout.setVerticalGroup(
            jPDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnPesquisar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lista, tblLista);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(tblLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        listar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            if (tblLista.getSelectedRowCount() == 1) {
                int index = tblLista.getSelectedRow();
                Produto p = lista.get(index);
                dp.remover(p);
                lista.remove(p);
                JOptionPane.showMessageDialog(this, "Foi removido o registro!");
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        te = new TelaEdicao(this);
        te.setLocationRelativeTo(null);
        te.setProduto(new Produto());
        te.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblLista.getSelectedRowCount() == 1) {
            int index = tblLista.getSelectedRow();
            Produto p = lista.get(index);
            te = new TelaEdicao(this);
            te.setLocationRelativeTo(null);
            te.setProduto(p);
            te.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        carregaLookAndFell();
        java.awt.EventQueue.invokeLater(() ->{
            TelaLista tl = new TelaLista();
            tl.setLocationRelativeTo(null);
            tl.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel jPDados;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Produto> lista;
    private javax.swing.JTable tblLista;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void listar() {
        lista.clear();
        lista.addAll(dp.getAll());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btnCancelar")) {
            if (te != null) {
                te.dispose();
            }
        }
        
        if (e.getActionCommand().equals("btnSalvar")) {
            if (te != null) {
                Produto p = te.getProduto();
                dp.salvar(p);
                te.dispose();
                listar();
            }
        }
    }
    
    public static void carregaLookAndFell() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());                    
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        }  
    }

}
