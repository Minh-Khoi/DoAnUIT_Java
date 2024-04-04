/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uit.team.QLSachJFrame1;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class QLSachController  {
//    QLSachJFrame1 jframe ;
    
    
    public static void initDatas(JTable jTable1){
//        SachDAO dao = new SachDAO();
        List<Sach> list = SachDAO.readAll();
        
        String[] colsName = new String [] {"Mã sách","Tên sách","Trạng thái","Số lượng","Tên nhà xuất bản",
                                            "Tên tác giả","Đầu sách"};
        DefaultTableModel model = new DefaultTableModel(colsName, 0);
        for(Sach instance : list){
            Object[] instanceInfos = instance.toPropertiesArray();
            String maDauSach = instanceInfos[instanceInfos.length-1].toString();
            String tenDauSach = DauSachDAO.readByPrimaryKey(maDauSach).getTenDauSach();
            instanceInfos[instanceInfos.length-1] = tenDauSach;
            model.addRow(instanceInfos);
        }
        jTable1.setModel(model);
    }
}
