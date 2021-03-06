/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CategoryController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class Categories extends javax.swing.JPanel {

    private JFrame frame;
    FormCategory form;

    /**
     * Creates new form Categories
     */
    public Categories(JFrame frame) throws SQLException {
        this.frame = frame;
        initComponents();
        initTableData();
        form = new FormCategory(frame, this.tableCategories);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategories = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        btnNew.setText("Nova categoria");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew);

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate);

        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Categorias");
        add(jLabel1);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        tableCategories.setAutoCreateRowSorter(true);
        tableCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCategories.setMaximumSize(null);
        jScrollPane1.setViewportView(tableCategories);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        form.clearFields();
        form.selectedId = 0;
        form.setDefaultTitle();
        form.setVisibility(true);
        form.setDefaultTitle();
    }//GEN-LAST:event_btnNewActionPerformed


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //verifica se tem linha selecionada
        int row = this.tableCategories.getSelectedRow();
        if (row >= 0) {
            form.selectedId = 1;
            form.loadData(this.tableCategories, row);
            form.setVisibility(true);
        } else {
            showMessageDialog(this, "Nenhum registro selecionado!");

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tableCategories.getSelectedRow();
        if (row >= 0) {
            try {
                deleteCategory(row);
            } catch (SQLException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            showMessageDialog(this, "Nenhum registro selecionado");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    public void deleteCategory(int row) throws SQLException {
        CategoryController controller = new CategoryController();
        Object[] options = {"Sim, remover", "Cancelar!"};
        int n = JOptionPane.showOptionDialog(this,
                "Tem certeza que deseja excluir a categoria?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) this.tableCategories.getModel();
            controller.delete((int) model.getValueAt(row, 0));

            int[] rows = tableCategories.getSelectedRows();
            for (int i = 0; i < rows.length; i++) {
                model.removeRow(rows[i] - i);
            }
        }
    }

    private void initTableData() throws SQLException {
        CategoryController controller = new CategoryController();
        ResultSet data = controller.index();

        DefaultTableModel model = (DefaultTableModel) this.tableCategories.getModel();

        while (data.next()) {
            System.out.println(data);
            model.addRow(new Object[]{data.getInt("id"), data.getString("name")});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCategories;
    // End of variables declaration//GEN-END:variables
}
