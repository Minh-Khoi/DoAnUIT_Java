/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.forms;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import uit.team.QLSachJFrame1;
import uit.team.controllers.FormController;
import uit.team.controllers.FormSachController;

/**
 *
 * @author USER
 */
public class FormSach  extends FormInsertUpdate {

    /**
     * Creates new form FormSach
     */
    public FormSach() {
        initComponents();
        initForm(modifyMode,"");
    }

    public FormSach(boolean modifyMode_, String selectedPrv) {
        initComponents();
        initForm(modifyMode_,selectedPrv);
    }
    
    private void initForm(boolean modifyMode__, String selectedPrv){        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
        this.modifyMode = modifyMode__;
        this.prV = selectedPrv;
        titleLabel1.setText(modifyMode__ ? "Chỉnh sửa Sách" : "Thêm sách");
        maTextField1.setEnabled(!modifyMode);
        this.insertTab.setVisible(false);
        this.modifyTab.setVisible(false);
        FormController.setFunctionClose(this);
        FormSachController.initDauSachCombobox(dauSachComboBox1);
        if (modifyMode){
            FormSachController.populateDatas(this, prV);
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

        maSach = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        tenLabel = new javax.swing.JLabel();
        maLabel = new javax.swing.JLabel();
        soLuongLabel = new javax.swing.JLabel();
        trangThaiLatbel = new javax.swing.JLabel();
        dauSachLabel = new javax.swing.JLabel();
        tenNxbLabel = new javax.swing.JLabel();
        tenTacGiaLabel = new javax.swing.JLabel();
        submitButton1 = new javax.swing.JButton();
        insertTab = new javax.swing.JButton();
        modifyTab = new javax.swing.JButton();
        maTextField1 = new javax.swing.JTextField();
        tenTextField2 = new javax.swing.JTextField();
        soLuongTextField3 = new javax.swing.JTextField();
        trangThaiTextField4 = new javax.swing.JTextField();
        tenNxbTextField6 = new javax.swing.JTextField();
        tenTacGiaTextField8 = new javax.swing.JTextField();
        dauSachComboBox1 = new javax.swing.JComboBox<>();
        actionDauSachButton1 = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        titleLabel1.setText("Thêm/Sửa ");

        tenLabel.setText("Tên Sách");

        maLabel.setText("Mã Sách");

        soLuongLabel.setText("Số lượng");

        trangThaiLatbel.setText("Trạng thái");

        dauSachLabel.setText("Đầu sách");

        tenNxbLabel.setText("Tên NXB");

        tenTacGiaLabel.setText("Tên tác giả");

        submitButton1.setText("Submit");
        submitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton1ActionPerformed(evt);
            }
        });

        insertTab.setText("Chức năng THÊM");
        insertTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertTabActionPerformed(evt);
            }
        });

        modifyTab.setText("Chức năng CHỈNH SỬA");
        modifyTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyTabActionPerformed(evt);
            }
        });

        maTextField1.setToolTipText("");

        tenTextField2.setToolTipText("");

        soLuongTextField3.setToolTipText("");

        trangThaiTextField4.setToolTipText("");

        tenNxbTextField6.setToolTipText("");

        tenTacGiaTextField8.setToolTipText("");

        dauSachComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        actionDauSachButton1.setText("Thêm/Sửa Đầu sách");
        actionDauSachButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionDauSachButton1ActionPerformed(evt);
            }
        });

        errorLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout maSachLayout = new javax.swing.GroupLayout(maSach);
        maSach.setLayout(maSachLayout);
        maSachLayout.setHorizontalGroup(
            maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maSachLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(maSachLayout.createSequentialGroup()
                        .addComponent(insertTab, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(modifyTab, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(maSachLayout.createSequentialGroup()
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenNxbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenTacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dauSachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trangThaiLatbel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maTextField1)
                            .addComponent(tenTextField2)
                            .addComponent(trangThaiTextField4)
                            .addComponent(soLuongTextField3)
                            .addComponent(tenNxbTextField6)
                            .addComponent(tenTacGiaTextField8)
                            .addComponent(dauSachComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maSachLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(maSachLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(maSachLayout.createSequentialGroup()
                                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(errorLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, maSachLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                        .addComponent(submitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72))
                            .addGroup(maSachLayout.createSequentialGroup()
                                .addComponent(actionDauSachButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        maSachLayout.setVerticalGroup(
            maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(maSachLayout.createSequentialGroup()
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insertTab, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(maSachLayout.createSequentialGroup()
                                .addComponent(trangThaiTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(soLuongTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(maSachLayout.createSequentialGroup()
                                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tenTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangThaiLatbel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(soLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tenNxbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenNxbTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenTacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenTacGiaTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(maSachLayout.createSequentialGroup()
                        .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(submitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(errorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(maSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dauSachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dauSachComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionDauSachButton1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButton1ActionPerformed

    private void insertTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertTabActionPerformed

    private void modifyTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyTabActionPerformed

    private void actionDauSachButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionDauSachButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actionDauSachButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionDauSachButton1;
    public javax.swing.JComboBox<String> dauSachComboBox1;
    private javax.swing.JLabel dauSachLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JButton insertTab;
    private javax.swing.JLabel maLabel;
    private javax.swing.JPanel maSach;
    public javax.swing.JTextField maTextField1;
    private javax.swing.JButton modifyTab;
    private javax.swing.JLabel soLuongLabel;
    public javax.swing.JTextField soLuongTextField3;
    private javax.swing.JButton submitButton1;
    private javax.swing.JLabel tenLabel;
    private javax.swing.JLabel tenNxbLabel;
    public javax.swing.JTextField tenNxbTextField6;
    private javax.swing.JLabel tenTacGiaLabel;
    public javax.swing.JTextField tenTacGiaTextField8;
    public javax.swing.JTextField tenTextField2;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel trangThaiLatbel;
    public javax.swing.JTextField trangThaiTextField4;
    // End of variables declaration//GEN-END:variables
}
