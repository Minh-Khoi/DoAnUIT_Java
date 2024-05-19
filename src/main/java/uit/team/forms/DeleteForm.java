/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.forms;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import uit.team.HomeFrame;
import uit.team.QLDauSachJFrame1;
import uit.team.QLHocVienJFrame;
import uit.team.QLMuonSachJFrame;
import uit.team.QLPhieuMuonJFrame11;
import uit.team.QLSachJFrame1;
import uit.team.models.businesses.DauSachUtils;
import uit.team.models.businesses.PhieuMuonUtils;
import uit.team.models.businesses.SachUtils;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.dao.HocVienDAO;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.dao.PhieuMuonDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.HocVien;
import uit.team.models.mssql.entities.MuonSach;
import uit.team.models.mssql.entities.PhieuMuon;

/**
 *
 * @author USER
 */
public class DeleteForm extends javax.swing.JFrame {
    JFrame previousFrame ;
    /**
     * Creates new form DeleteForm
     */
    public DeleteForm() {
        initComponents();
    }
    
    public DeleteForm(JFrame jFrame) {
        initComponents();
        jFrame.setVisible(false);
        previousFrame = jFrame;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
        setFunctionClose(jFrame);
    }
    
    private void setFunctionClose(JFrame previousFrame ){
        if(previousFrame instanceof QLDauSachJFrame1){
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLDauSachJFrame1().setVisible(true);
                }
            });
        } else if(previousFrame instanceof QLHocVienJFrame){
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLHocVienJFrame().setVisible(true);
                }
            });
        }else if(previousFrame instanceof QLPhieuMuonJFrame11){
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLPhieuMuonJFrame11().setVisible(true);
                }
            });
        } else if(previousFrame instanceof QLSachJFrame1){
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLSachJFrame1().setVisible(true);
                }
            });
        }else if(previousFrame instanceof QLMuonSachJFrame){
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    String maphieumuon = System.getProperty("MAPHIEU_");
                    System.clearProperty("MAPHIEU_");
                    new QLMuonSachJFrame(maphieumuon).setVisible(true);
                }
            });
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
        deleteButton1 = new javax.swing.JButton();
        notDeleteButton2 = new javax.swing.JButton();
        moreTextLabel2 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bạn chắc chắn muốn xóa đối tượng này chứ?");

        deleteButton1.setText("Xóa");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });

        notDeleteButton2.setText("Không");
        notDeleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notDeleteButton2ActionPerformed(evt);
            }
        });

        errorLabel3.setForeground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(moreTextLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(deleteButton1)
                            .addGap(89, 89, 89)
                            .addComponent(notDeleteButton2))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(moreTextLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton1)
                    .addComponent(notDeleteButton2))
                .addGap(18, 18, 18)
                .addComponent(errorLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        if(previousFrame instanceof QLHocVienJFrame){
            JTable jtable1 = ((QLHocVienJFrame)this.previousFrame).jTable1;
            String prV = jtable1.getValueAt(jtable1.getSelectedRow(), 0).toString();
            List<PhieuMuon> pmsChuaTra = PhieuMuonUtils.hocVienChuaTraSach(prV);
            if (!pmsChuaTra.isEmpty()){
                StringBuilder errMessSB = new StringBuilder();
                errMessSB.append("Học viên chưa trả sách. Không xóa được!!\n Tra cứu mã phiếu mượn: ");
                for(PhieuMuon pm : pmsChuaTra){
                    errMessSB.append(pm.getMaPhieu()).append("; ");
                }
                this.errorLabel3.setText("<html><p style=\"white-space: wrap;\">"+errMessSB.toString()+ "</p></html>");
//                System.out.println(errMessSB.toString());
            } else {
                int deleted = HocVienDAO.delete(prV);
                if (deleted == 0){
                    this.errorLabel3.setText("No object to delete");
                } else {
                    this.dispose();
                }
            }            
        } else if(previousFrame instanceof QLDauSachJFrame1){
            JTable jtable1 = ((QLDauSachJFrame1)this.previousFrame).jTable1;
            String prV = jtable1.getValueAt(jtable1.getSelectedRow(), 0).toString();
            List<MuonSach> mssChuaTra = DauSachUtils.sachMuonChuaTra(prV);
            if (!mssChuaTra.isEmpty()){
                StringBuilder errMessSB = new StringBuilder();
                errMessSB.append("Còn sách mượn chưa trả. Chưa thể xóa!! Tra cứu các Mã phiếu - Mã sách sau:  ");
                for (MuonSach ms : mssChuaTra){
                    errMessSB.append(ms.getMaPhieu()).append("-").append(ms.getMaSach()).append("; ");
                }
                this.errorLabel3.setText("<html><p style=\"white-space: wrap;\">"+errMessSB.toString()+ "</p></html>");
            } else {
                int deleted = DauSachDAO.delete(prV);
                if (deleted == 0){
                    this.errorLabel3.setText("No object to delete");
                } else {
                    SachDAO.deleteByDauSach(prV);
                    this.dispose();
                }
            }
        } else if(previousFrame instanceof QLSachJFrame1){
            JTable jtable1 = ((QLSachJFrame1)this.previousFrame).jTable1;
            String prV = jtable1.getValueAt(jtable1.getSelectedRow(), 0).toString();
            List<MuonSach> mssChuaTra = SachUtils.sachChuaTraXong(prV);
            if(!mssChuaTra.isEmpty()){
                StringBuilder errMessSB = new StringBuilder();
                errMessSB.append("Còn sách mượn chưa trả. Chưa thể xóa!! Tra cứu các Mã phiếu - Mã sách sau:  ");
                for (MuonSach ms : mssChuaTra){
                    errMessSB.append(ms.getMaPhieu()).append("-").append(ms.getMaSach()).append("; ");
                }
                this.errorLabel3.setText("<html><p style=\"white-space: wrap;\">"+errMessSB.toString()+ "</p></html>");
            } else {
                int deleted = SachDAO.delete(prV);
                if (deleted == 0){
                    this.errorLabel3.setText("No object to delete");
                } else {

                    this.dispose();
                }
            }            
        }else if(previousFrame instanceof QLPhieuMuonJFrame11){
            JTable jtable1 = ((QLPhieuMuonJFrame11)this.previousFrame).jTable1;
            String prV = jtable1.getValueAt(jtable1.getSelectedRow(), 0).toString();
            int deletedPhieuMuon = PhieuMuonDAO.delete(prV);
            if (deletedPhieuMuon == 0){
                this.errorLabel3.setText("No object to delete");
            } else {
                MuonSachDAO.deleteByForeignKey("MAPHIEU", prV);
                this.dispose();
            }
        }else if(previousFrame instanceof QLMuonSachJFrame){
            JTable jtable1 = ((QLMuonSachJFrame)this.previousFrame).jTable1;
            String maSachMuon = jtable1.getValueAt(jtable1.getSelectedRow(), 0).toString();
            String maPhieuMuon = ((QLMuonSachJFrame)this.previousFrame).maPhieuMuon;
            int deleted = MuonSachDAO.delete(maPhieuMuon, maSachMuon);
            if (deleted == 0){
                this.errorLabel3.setText("No object to delete");
            } else {
                System.setProperty("MAPHIEU_", maPhieuMuon);
                System.out.println(Thread.currentThread().getName());
                this.dispose();
            }
        }
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void notDeleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notDeleteButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_notDeleteButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton1;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel moreTextLabel2;
    private javax.swing.JButton notDeleteButton2;
    // End of variables declaration//GEN-END:variables
}
