/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustunerturizm2;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author iserh
 */
public class frmOtobusGoruntule extends javax.swing.JFrame {

    DefaultListModel model = new DefaultListModel();
    DefaultTableModel dfmodel = new DefaultTableModel();

    /**
     * Creates new form frmOtobusGoruntule
     */
    public frmOtobusGoruntule() {

        initComponents();
        getRootPane().setDefaultButton(btnKaydet);
        populateTable();
        tblOtobus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmOtobusGorDuzenle = new javax.swing.JFrame();
        txtOtobusPlakaDuzenle = new javax.swing.JTextField();
        txtOtobusSecimKoltukSayisi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        optCancelContinue = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOtobus = new javax.swing.JTable();
        btnOtobusGoruntule = new javax.swing.JButton();
        btnOtobusSil = new javax.swing.JButton();
        txtAraPlaka = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        frmOtobusGorDuzenle.setMinimumSize(new java.awt.Dimension(270, 210));
        frmOtobusGorDuzenle.setResizable(false);

        txtOtobusPlakaDuzenle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtobusPlakaDuzenleKeyReleased(evt);
            }
        });

        txtOtobusSecimKoltukSayisi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtobusSecimKoltukSayisiKeyReleased(evt);
            }
        });

        jLabel2.setText("Plaka");

        jLabel3.setText("Koltuk Sayisi");

        btnKaydet.setText("Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmOtobusGorDuzenleLayout = new javax.swing.GroupLayout(frmOtobusGorDuzenle.getContentPane());
        frmOtobusGorDuzenle.getContentPane().setLayout(frmOtobusGorDuzenleLayout);
        frmOtobusGorDuzenleLayout.setHorizontalGroup(
            frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmOtobusGorDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOtobusSecimKoltukSayisi)
                    .addComponent(txtOtobusPlakaDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmOtobusGorDuzenleLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        frmOtobusGorDuzenleLayout.setVerticalGroup(
            frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmOtobusGorDuzenleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtobusPlakaDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frmOtobusGorDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtobusSecimKoltukSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnKaydet)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        frmOtobusGorDuzenleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtOtobusPlakaDuzenle, txtOtobusSecimKoltukSayisi});

        javax.swing.GroupLayout optCancelContinueLayout = new javax.swing.GroupLayout(optCancelContinue.getContentPane());
        optCancelContinue.getContentPane().setLayout(optCancelContinueLayout);
        optCancelContinueLayout.setHorizontalGroup(
            optCancelContinueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        optCancelContinueLayout.setVerticalGroup(
            optCancelContinueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Otobüs Görüntüleme Ekranı");
        setResizable(false);

        tblOtobus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plaka", "Koltuk Sayısı"
            }
        ));
        jScrollPane1.setViewportView(tblOtobus);

        btnOtobusGoruntule.setText("Görüntüle");
        btnOtobusGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtobusGoruntuleActionPerformed(evt);
            }
        });

        btnOtobusSil.setText("Sil");
        btnOtobusSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtobusSilActionPerformed(evt);
            }
        });

        txtAraPlaka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAraPlakaKeyReleased(evt);
            }
        });

        jLabel1.setText("Arama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtobusGoruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtobusSil, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAraPlaka, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAraPlaka, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtobusGoruntule)
                    .addComponent(btnOtobusSil))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAraPlakaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAraPlakaKeyReleased
        // TODO add your handling code here:
        String searchKey = txtAraPlaka.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(dfmodel);
        tblOtobus.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtAraPlakaKeyReleased
    int selectedRow;

    public ArrayList<Otobus> getGoruntulenenOtobus() throws SQLException {
        int id = (Integer) tblOtobus.getModel().getValueAt(tblOtobus.convertRowIndexToModel(selectedRow), 0);
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Otobus> GoruntulenenOtobus = null;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from otobus WHERE ID=" + id);
            GoruntulenenOtobus = new ArrayList<>();
            while (resultSet.next()) {
                GoruntulenenOtobus.add(new Otobus(resultSet.getInt("ID"),
                        resultSet.getString("plaka"),
                        resultSet.getInt("koltuksayisi")
                )
                );

            }
        } catch (SQLException e) {
            helper.showErrorMessage(e);

        } finally {
            statement.close();
            connection.close();
        }
        return GoruntulenenOtobus;
    }
    private void btnOtobusGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtobusGoruntuleActionPerformed
        // TODO add your handling code here:
        try {
            selectedRow = tblOtobus.getSelectedRow();
            ArrayList<Otobus> GoruntulenenOtobus = getGoruntulenenOtobus();
            GoruntulenenOtobus.stream().map((otobus) -> {
                txtOtobusPlakaDuzenle.setText(otobus.getPlaka());
                return otobus;
            }).forEachOrdered((otobus) -> {
                txtOtobusSecimKoltukSayisi.setText(Integer.toString(otobus.getKoltukSayisi()));
            });
            populateTable();

        } catch (SQLException ex) {
            Logger.getLogger(frmMusteriGoruntule.class.getName()).log(Level.SEVERE, null, ex);
        }
        frmOtobusGorDuzenle.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        frmOtobusGorDuzenle.setLocationRelativeTo(null);
        frmOtobusGorDuzenle.setVisible(true);

    }//GEN-LAST:event_btnOtobusGoruntuleActionPerformed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        int id = 0;
        try {
            connection = helper.getConnection();
            ArrayList<Otobus> GoruntulenenOtobus = getGoruntulenenOtobus();
            for (Otobus otobus : GoruntulenenOtobus) {
                id = otobus.getId();
            }
            String sql = "UPDATE otobus SET koltuksayisi=?,plaka=? WHERE ID=" + id;
            statement = connection.prepareStatement(sql);
            statement.setString(1, txtOtobusSecimKoltukSayisi.getText());
            statement.setString(2, txtOtobusPlakaDuzenle.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Otobüs Bilgileri Güncellendi"
                        + "", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
            populateTable();

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmMusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnOtobusSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtobusSilActionPerformed
        // TODO add your handling code here:
        int id = (Integer) tblOtobus.getModel().getValueAt(tblOtobus.convertRowIndexToModel(selectedRow), 0);
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        Object[] options = {"Sil", "İptal et"};
        int n = JOptionPane.showOptionDialog(optCancelContinue,
                "Bu otobüsü silmek istediğinize emin misiniz?",
                "Emin misiniz?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        switch (n) {
            case JOptionPane.YES_OPTION:
                try {
                    connection = helper.getConnection();
                    String sql = "DELETE from otobus WHERE ID=" + id;
                    statement = connection.prepareStatement(sql);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Otobüs silindi", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    populateTable();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmOtobusGoruntule.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(frmOtobusGoruntule.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   break;
            case JOptionPane.NO_OPTION:
                break;
            default:
                break;
        }


    }//GEN-LAST:event_btnOtobusSilActionPerformed

    private void txtOtobusSecimKoltukSayisiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtobusSecimKoltukSayisiKeyReleased
        // TODO add your handling code here:
        try {
            Integer.parseInt(txtOtobusSecimKoltukSayisi.getText());

        } catch (NumberFormatException e) {
            txtOtobusSecimKoltukSayisi.setText(txtOtobusSecimKoltukSayisi.getText().replaceAll("[^0-9]", ""));
        }
    }//GEN-LAST:event_txtOtobusSecimKoltukSayisiKeyReleased

    private void txtOtobusPlakaDuzenleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtobusPlakaDuzenleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtobusPlakaDuzenleKeyReleased

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
            java.util.logging.Logger.getLogger(frmOtobusGoruntule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOtobusGoruntule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOtobusGoruntule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOtobusGoruntule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmOtobusGoruntule().setVisible(true);
        });
    }

    public ArrayList<Otobus> getOtobus() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Otobus> otobusler = null;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from otobus");
            otobusler = new ArrayList<>();
            while (resultSet.next()) {
                otobusler.add(new Otobus(resultSet.getInt("ID"),
                        resultSet.getString("plaka"),
                        resultSet.getInt("koltuksayisi")));

            }
        } catch (SQLException e) {
            helper.showErrorMessage(e);

        } finally {
            statement.close();
            connection.close();
        }
        return otobusler;

    }

    public void populateTable() {
        dfmodel.setRowCount(0);
        dfmodel = (DefaultTableModel) tblOtobus.getModel();
        try {
            ArrayList<Otobus> otobusler = getOtobus();
            for (Otobus otobus : otobusler) {
                Object[] row = {
                    otobus.getId(),
                    otobus.getPlaka(),
                    otobus.getKoltukSayisi()};
                dfmodel.addRow(row);

            }
            if (tblOtobus.getColumnName(0).equals("ID")) {
                tblOtobus.removeColumn(tblOtobus.getColumn("ID"));
            }
        } catch (SQLException ex) {
            DbHelper help = new DbHelper();
            help.showErrorMessage(ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JButton btnOtobusGoruntule;
    private javax.swing.JButton btnOtobusSil;
    private javax.swing.JFrame frmOtobusGorDuzenle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog optCancelContinue;
    private javax.swing.JTable tblOtobus;
    private javax.swing.JTextField txtAraPlaka;
    private javax.swing.JTextField txtOtobusPlakaDuzenle;
    private javax.swing.JTextField txtOtobusSecimKoltukSayisi;
    // End of variables declaration//GEN-END:variables
}