/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import uit.team.models.businesses.HocVienUtils;
import uit.team.models.businesses.PhieuMuonUtils;
import uit.team.models.mssql.dao.PhieuMuonDAO;

/**
 *
 * @author USER
 */
public class FormPhieuMuonController  extends FormController{
    public static void populateHocVienCombobox(JComboBox hocVienComboBox1) {
        List<String> resultList = HocVienUtils.queryForComboboz();
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(resultList.toArray());
        hocVienComboBox1.setModel(model);
    }
    
    public static void populateHocVienInfosTab(JTextPane textPane, String maHV){
        String infos = HocVienUtils.queryFullInfos(maHV);
        textPane.setText(infos);
    }
}
