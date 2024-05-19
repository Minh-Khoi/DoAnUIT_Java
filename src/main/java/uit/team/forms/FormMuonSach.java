/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.forms;

import javax.swing.JFrame;
import uit.team.controllers.FormMuonSachController;

/**
 *
 * @author USER
 */
public class FormMuonSach extends FormInsertUpdate {
    public String maPhieuMuon = "";
    public String maSach ;
    /**
     * Creates new form FormMuonSach
     */
    public FormMuonSach(String maPhieuMuon_) {
        initComponents();
        this.maPhieuMuon = maPhieuMuon_;
        initForm(false,"");
    }
    public FormMuonSach(boolean modifyMode_, String selectedMaSach_,String maPhieuMuon_) {
        initComponents();
        this.maPhieuMuon = maPhieuMuon_;
        initForm(modifyMode_,selectedMaSach_);
    }
    
    
    private void initForm(boolean modifyMode_, String selectedMaSach_){        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
        titleLabel1.setText(modifyMode_ ? "Chỉnh sửa Sách mượn" : "Thêm Sách mượn");
        this.modifyMode = modifyMode_;
        this.maSach = selectedMaSach_;
        sachMuonComboBox2.setEnabled(!modifyMode);
        FormMuonSachController.gotoQLMuonSachAfterDispose(this);
        FormMuonSachController.populateSachMuonCombobox(sachMuonComboBox2, maPhieuMuon);
        if(modifyMode_){
            FormMuonSachController.populateDatas(this, maPhieuMuon, maSach);
        }
        FormMuonSachController.showFieldNgayTra(this);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitButton1 = new javax.swing.JButton();
        titleLabel1 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        sachMuonComboBox2 = new javax.swing.JComboBox<>();
        ngayHenTraDateChooser2 = new com.toedter.calendar.JDateChooser();
        trangThaiSachComboBox3 = new javax.swing.JComboBox<>();
        sachMuonLabel1 = new javax.swing.JLabel();
        ngayHenTraLabel2 = new javax.swing.JLabel();
        daTraLabel3 = new javax.swing.JLabel();
        trangThaiSachLabel4 = new javax.swing.JLabel();
        daTraCheckBox1 = new javax.swing.JCheckBox();
        ngayTraSachDateChooser3 = new com.toedter.calendar.JDateChooser();
        ngayTraSachLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        submitButton1.setText("Submit");
        submitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton1ActionPerformed(evt);
            }
        });

        titleLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        titleLabel1.setText("Thêm/Sửa Sách mượn");

        errorLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(255, 0, 0));

        sachMuonComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sachMuonComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sachMuonComboBox2ItemStateChanged(evt);
            }
        });
        sachMuonComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sachMuonComboBox2ActionPerformed(evt);
            }
        });

        trangThaiSachComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách mới","Sách cũ" }));
        trangThaiSachComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                trangThaiSachComboBox3ItemStateChanged(evt);
            }
        });
        trangThaiSachComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaiSachComboBox3ActionPerformed(evt);
            }
        });

        sachMuonLabel1.setText("Sách mượn");

        ngayHenTraLabel2.setText("Ngày hẹn trả");

        daTraLabel3.setText("Đánh dấu đã trả");

        trangThaiSachLabel4.setText("Trạng thái sách");

        daTraCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daTraCheckBox1ActionPerformed(evt);
            }
        });

        ngayTraSachLabel1.setText("Ngày trả sách");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(daTraLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sachMuonLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trangThaiSachLabel4)
                            .addComponent(ngayHenTraLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ngayTraSachLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(ngayTraSachDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(daTraCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sachMuonComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(submitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(trangThaiSachComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayHenTraDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(errorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(77, 77, 77))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(271, 271, 271)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(304, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(submitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(errorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sachMuonComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sachMuonLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngayHenTraDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayHenTraLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trangThaiSachComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trangThaiSachLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daTraLabel3)
                    .addComponent(daTraCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ngayTraSachDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(ngayTraSachLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 105, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(380, 380, 380)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButton1ActionPerformed
        // TODO add your handling code here:
        boolean validInputs = FormMuonSachController.validateBeforeSaving(this);
        if (validInputs){
            FormMuonSachController.saveDatas(this);
            this.dispose();
        }

    }//GEN-LAST:event_submitButton1ActionPerformed

    private void sachMuonComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sachMuonComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sachMuonComboBox2ItemStateChanged

    private void sachMuonComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sachMuonComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sachMuonComboBox2ActionPerformed

    private void trangThaiSachComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_trangThaiSachComboBox3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_trangThaiSachComboBox3ItemStateChanged

    private void trangThaiSachComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaiSachComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangThaiSachComboBox3ActionPerformed

    private void daTraCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daTraCheckBox1ActionPerformed
        // TODO add your handling code here:
        FormMuonSachController.showFieldNgayTra(this);
    }//GEN-LAST:event_daTraCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new FormMuonSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox daTraCheckBox1;
    private javax.swing.JLabel daTraLabel3;
    public javax.swing.JLabel errorLabel1;
    public com.toedter.calendar.JDateChooser ngayHenTraDateChooser2;
    private javax.swing.JLabel ngayHenTraLabel2;
    public com.toedter.calendar.JDateChooser ngayTraSachDateChooser3;
    public javax.swing.JLabel ngayTraSachLabel1;
    public javax.swing.JComboBox<String> sachMuonComboBox2;
    private javax.swing.JLabel sachMuonLabel1;
    private javax.swing.JButton submitButton1;
    private javax.swing.JLabel titleLabel1;
    public javax.swing.JComboBox<String> trangThaiSachComboBox3;
    private javax.swing.JLabel trangThaiSachLabel4;
    // End of variables declaration//GEN-END:variables
}
