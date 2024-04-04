/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.Date;
import uit.team.forms.FormHocVien;
import uit.team.models.businesses.HocVienUtils;
import uit.team.models.mssql.dao.HocVienDAO;
import uit.team.models.mssql.entities.HocVien;

/**
 *
 * @author USER
 */
public class FormHocVienController  extends FormController{
    
    public static void populateDatas(FormHocVien form, String prV) {
        HocVien instance = HocVienDAO.readByPrimaryKey(prV);
        form.maTextField1.setText(prV);
        form.tenTextField2.setText(instance.getTenHV());
        form.sodtTextField4.setText(instance.getSoDT());
        form.ngaySinhDateChooser1.setDate(instance.getNgaySinh());
        form.donViComboBox1.setSelectedItem(instance.getDonVi().trim());
        form.gioiTinhComboBox1.setSelectedItem(instance.getGioiTinh().trim());
    }
    
        
    public static void saveDatas(FormHocVien form) {
        String maHV = form.maTextField1.getText();
        String tenHV = form.tenTextField2.getText();
        String soDT = form.sodtTextField4.getText();
        java.sql.Date ngaySinh = new java.sql.Date(form.ngaySinhDateChooser1.getDate().getTime());
        String donVi = form.donViComboBox1.getSelectedItem().toString();
        String gioiTinh = form.gioiTinhComboBox1.getSelectedItem().toString();
        HocVien instance = new HocVien(maHV, tenHV, soDT, ngaySinh, donVi, gioiTinh);
        HocVienUtils.saveInstance(instance, form.modifyMode);
    }
}
