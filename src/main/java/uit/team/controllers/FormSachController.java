/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import uit.team.forms.FormSach;
import uit.team.models.businesses.DauSachUtils;
import uit.team.models.businesses.SachUtils;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.DauSach;
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class FormSachController extends FormController{
    public static void initDauSachCombobox(JComboBox dauSachCombobox) {
        List datas = DauSachUtils.getDauSachInfos(dauSachCombobox);
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(datas.toArray());
        dauSachCombobox.setModel(model);
    }
    
        
    public static void populateDatas(FormSach form, String prV) {
        Sach instance = SachDAO.readByPrimaryKey(prV);
        form.maTextField1.setText(instance.getMaSach());
        form.tenTextField2.setText(instance.getTenSach());
        form.soLuongTextField3.setText(String.valueOf(instance.getSoLuong()));
        form.tenNxbTextField6.setText(instance.getTenSach());
        form.tenTextField2.setText(instance.getTenSach());
        form.tenTacGiaTextField8.setText(instance.getTenTG());
        form.trangThaiTextField4.setText(instance.getTrangThai());
        DauSach ds = DauSachDAO.readByPrimaryKey(instance.getMaDauSach());
        form.dauSachComboBox1.setSelectedItem(ds.getMaDauSach().trim() + " - " + ds.getTenDauSach().trim());
    }
    
    
    public static void saveDatas(FormSach form) {
        String maSach = form.maTextField1.getText();
        String tenSach = form.tenTextField2.getText();
        String trangThai = form.trangThaiTextField4.getText();
        int soLuong = Integer.parseInt(form.soLuongTextField3.getText());
        String tenNXB = form.tenNxbTextField6.getText();
        String tenTG = form.tenTacGiaTextField8.getText();
        String maDauSach = form.dauSachComboBox1.getSelectedItem().toString().split("-")[0].trim();
        
        Sach instance = new Sach(maSach, tenSach, trangThai, soLuong, tenNXB, tenTG, maDauSach);
        SachUtils.saveInstance(instance, form.modifyMode);
    }
}
