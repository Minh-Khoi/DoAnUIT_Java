/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import uit.team.QLMuonSachJFrame;
import uit.team.forms.FormMuonSach;
import uit.team.models.businesses.MuonSachUtils;
import uit.team.models.businesses.SachUtils;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.MuonSach;
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class FormMuonSachController {
    public static void populateDatas(FormMuonSach form, String maPhieuMuon,String maSach){
        Map colsValues = new HashMap();
        colsValues.put("MAPHIEU", maPhieuMuon);
        colsValues.put("MASACH", maSach);
        List<MuonSach> muonSachList = MuonSachDAO.readByCols(colsValues);
        if(!muonSachList.isEmpty()){
            MuonSach muonSach = muonSachList.get(0);
            form.trangThaiSachComboBox3.setSelectedItem(muonSach.getTrangThai().trim());
            form.daTraCheckBox1.setSelected(muonSach.getTrangThaiTra().trim().equals("OK"));
            form.ngayHenTraDateChooser2.setDate(muonSach.getNgayHenTra());
            if(!Objects.isNull(muonSach.getNgayTra())){
                form.ngayTraSachDateChooser3.setDate(muonSach.getNgayTra());
            }
        }
        Sach sach = SachDAO.readByPrimaryKey(maSach);
        if(!Objects.isNull(sach)){
            form.sachMuonComboBox2.setSelectedItem(SachUtils.formatSachMuonForCbbox(sach));
        }
    }
    
    public static void showFieldNgayTra(FormMuonSach form){
        form.ngayTraSachLabel1.setVisible(form.daTraCheckBox1.isSelected());
        form.ngayTraSachDateChooser3.setVisible(form.daTraCheckBox1.isSelected());
    }
    
    public static void gotoQLMuonSachAfterDispose(JFrame jFrame){
        jFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                FormMuonSach targ = (FormMuonSach)e.getComponent();
                new QLMuonSachJFrame(targ.maPhieuMuon).setVisible(true);
            }
        }); 
    }
    
    public static void populateSachMuonCombobox(JComboBox sachMuonCbbox, String maPhieuMuon){
        List<String> resultList = SachUtils.queryAllForCombobox();
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(resultList.toArray());
        sachMuonCbbox.setModel(model);
    }
    
    public static void saveDatas(FormMuonSach form) {
        String maPhieuMuon = form.maPhieuMuon;
        String maSach = form.sachMuonComboBox2.getSelectedItem().toString().split("-")[0].trim();
        String trangThaiSach = form.trangThaiSachComboBox3.getSelectedItem().toString().trim();
        Date ngayHenTra = new Date(form.ngayHenTraDateChooser2.getDate().getTime());
        boolean checkTraSach = form.daTraCheckBox1.isSelected();
        String trangThaiTra = (checkTraSach) ? "OK" : "CHƯA TRẢ";
        Date ngayTra = null;
        if(checkTraSach){
            if (!Objects.isNull(form.ngayTraSachDateChooser3.getDate()) ) {
                ngayTra = new Date(form.ngayTraSachDateChooser3.getDate().getTime() );
            } else {
                ngayTra = new Date(new java.util.Date().getTime());
            }
        }
        MuonSach instance = new MuonSach(maPhieuMuon, maSach, trangThaiSach, ngayHenTra, ngayTra, trangThaiTra);
        MuonSachUtils.saveInstance(instance, form.modifyMode);
    }
}
