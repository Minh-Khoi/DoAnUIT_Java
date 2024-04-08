/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uit.team.QLMuonSachJFrame;
import uit.team.QLPhieuMuonJFrame11;
import uit.team.models.businesses.MuonSachUtils;
import uit.team.models.mssql.entities.MuonSach;

/**
 *
 * @author USER
 */
public class QLMuonSachController {
    
    public static void gotoHomeFrameAfterDispose(JFrame jFrame){
        jFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                QLMuonSachJFrame targ = (QLMuonSachJFrame)e.getComponent();
                if (targ.returnBack){
                    new QLPhieuMuonJFrame11().setVisible(true);                    
                }
            }
        });
    }
    
    public static void initDatas(JTable jTable1, String maPhieuMuon) {
        String[] colsName = new String [] {"Mã Sách", "Trạng thái sách","Ngày hẹn trả","ngày trả","Trạng thái trả"};
        DefaultTableModel model = new DefaultTableModel(colsName, 0);

        List<MuonSach> list = MuonSachUtils.findRecsByPhieuMuon(maPhieuMuon);
        for(MuonSach instance : list){
            Object[] rowArr = instance.toPropertiesArray();
            List<Object> rowList = new ArrayList<>(Arrays.asList(rowArr));
            rowList.remove(0);
            model.addRow(rowList.toArray());
        }
        jTable1.setModel(model);
    }
}
