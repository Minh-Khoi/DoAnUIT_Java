/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uit.team.HomeFrame;
import uit.team.QLDauSachJFrame1;
import uit.team.QLFrame;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.dao.EntityDaoInterface;
import uit.team.models.mssql.entities.DauSach;
import uit.team.models.mssql.entities.EntityInterface;

/**
 *
 * @author USER
 */
public class QLDauSachController {

    public static void initDatas(JTable jTable1){
        List<DauSach> list = DauSachDAO.readAll();
        
        String[] colsName = new String [] {"Mã đầu sách", "Tên đầu sách"};
        DefaultTableModel model = new DefaultTableModel(colsName, 0);
        for(DauSach instance : list){
            model.addRow(instance.toPropertiesArray());
        }
        jTable1.setModel(model);
    }
    
    
}
