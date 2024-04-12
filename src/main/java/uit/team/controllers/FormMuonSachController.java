/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        }
        Sach sach = SachDAO.readByPrimaryKey(maSach);
        if(!Objects.isNull(sach)){
            form.sachMuonComboBox2.setSelectedItem(SachUtils.formatSachMuonForCbbox(sach));
        }
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
}
