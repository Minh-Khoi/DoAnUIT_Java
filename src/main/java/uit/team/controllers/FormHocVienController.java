/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import uit.team.forms.FormHocVien;
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
        form.donViComboBox1.setSelectedItem(instance.getDonVi());
        form.gioiTinhComboBox1.setSelectedItem(instance.getGioiTinh());
    }
}
