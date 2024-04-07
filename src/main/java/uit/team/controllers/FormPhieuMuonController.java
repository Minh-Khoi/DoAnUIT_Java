/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import uit.team.QLMuonSachJFrame;
import uit.team.QLPhieuMuonJFrame11;
import uit.team.forms.FormPhieuMuon;
import uit.team.models.businesses.HocVienUtils;
import uit.team.models.businesses.PhieuMuonUtils;
import uit.team.models.mssql.dao.PhieuMuonDAO;
import uit.team.models.mssql.entities.HocVien;
import uit.team.models.mssql.entities.PhieuMuon;

/**
 *
 * @author USER
 */
public class FormPhieuMuonController  extends FormController{
    public static void initHocVienCombobox(JComboBox hocVienComboBox1) {
        List<String> resultList = HocVienUtils.queryForComboboz();
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(resultList.toArray());
        hocVienComboBox1.setModel(model);
    }
    
    public static void populateHocVienInfosTab(JTextPane textPane, String maHV){
        String infos = HocVienUtils.queryFullInfos(maHV);
        textPane.setText(infos);
    }
    
        
    public static void populateDatas(FormPhieuMuon form, String prV) {
        PhieuMuon instance = PhieuMuonDAO.readByPrimaryKey(prV);
        form.maPhieuTextField1.setText(instance.getMaPhieu());
        form.ngayMuonDateChooser1.setDate(instance.getNgayMuon());
        form.trangThaiComboBox1.setSelectedItem(PhieuMuonUtils.getTrangThaiPhieuMuon(prV).trim());
        String fullHocVienInfos = HocVienUtils.queryFullInfos(instance.getMaHV());
        String[] arrayHVInfos = fullHocVienInfos.split("-");
        form.hocVienComboBox1.setSelectedItem(arrayHVInfos[0].trim()+" - "+arrayHVInfos[1].trim());
        form.thongTinHVTextPane1.setText(fullHocVienInfos);
    }
    
    public static void resetFunctionClose(FormPhieuMuon jFrame){
        WindowListener listener = jFrame.getWindowListeners()[0];
        if (!Objects.isNull(listener)){
            jFrame.removeWindowListener(listener);
        }
        if (!jFrame.onGoingToNext) {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLPhieuMuonJFrame11().setVisible(true);
                }
            });
        } else {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLMuonSachJFrame().setVisible(true);
                }
            });
        }
    }
    
    public static void saveDatas(FormPhieuMuon form) {
        String maPhieu = form.maPhieuTextField1.getText();
        String maHV = form.hocVienComboBox1.getSelectedItem().toString().split("-")[0].trim();
        java.sql.Date ngayMuon = new java.sql.Date(form.ngayMuonDateChooser1.getDate().getTime());
        String trangThai = form.trangThaiComboBox1.getSelectedItem().toString().trim();

        PhieuMuon instancePM = new PhieuMuon(maPhieu, ngayMuon, maHV);
        PhieuMuonUtils.saveInstance(instancePM, form.modifyMode);
//        PhieuMuonUtils
    }
}
