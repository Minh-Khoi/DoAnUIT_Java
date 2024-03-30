/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uit.team.models.businesses.PhieuMuonUtils;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.dao.PhieuMuonDAO;
import uit.team.models.mssql.entities.MuonSach;
import uit.team.models.mssql.entities.PhieuMuon;

/**
 *
 * @author USER
 */
public class QLPhieuMuonController  {
    
    public static void initDatas(JTable jTable1){
//        PhieuMuonDAO dao = new PhieuMuonDAO();
        List<PhieuMuon> list = PhieuMuonDAO.readAll();
        
        String[] colsName = new String [] {"Mã phiếu mượn","Ngày mượn","Mã học viên", "Trạng thái trả"};
        DefaultTableModel model = new DefaultTableModel(colsName, 0);
        for(PhieuMuon instance : list){
            Object[] rowArr = instance.toPropertiesArray();
            String trangThaiPhieu =  PhieuMuonUtils.getTrangThaiPhieuMuon(instance.getMaPhieu());
            List<Object> rowList = new ArrayList<>(Arrays.asList(rowArr));
            rowList.add(trangThaiPhieu);
            model.addRow(rowList.toArray());
        }
        jTable1.setModel(model);
    }
}
