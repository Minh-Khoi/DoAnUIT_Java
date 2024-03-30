/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uit.team.models.mssql.dao.HocVienDAO;
import uit.team.models.mssql.entities.HocVien;

/**
 *
 * @author USER
 */
public class QLHocVienController  {
    
    public static void initDatas(JTable jTable1){
//        HocVienDAO dao = new HocVienDAO();
        List<HocVien> list = HocVienDAO.readAll();
        
        String[] colsName = new String [] {"Mã học viên", "Tên học viên","Số điện thoại","ngày sinh","đơn vị", "giới tính"};
        DefaultTableModel model = new DefaultTableModel(colsName, 0);
        for(HocVien instance : list){
            model.addRow(instance.toPropertiesArray());
        }
        jTable1.setModel(model);
    }
    
    
}
