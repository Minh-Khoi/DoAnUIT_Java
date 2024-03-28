/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.team.models.mssql.dbconnect.ConnectToMSSQL;
import uit.team.models.mssql.entities.PhieuMuon;

/**
 *
 * @author USER
 */
public class PhieuMuonDAO {
    private static Connection conn;
    static void connectDB() {
        try {
            if(Objects.isNull(conn) || conn.isClosed()){
                conn = ConnectToMSSQL.getConn();
                System.out.println("Connect ton to DB: " + conn.getCatalog() + " successfully.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static int insert (PhieuMuon obj){
        connectDB();
        String sql = "INSERT INTO PHIEUMUON VALUES (?,?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, obj.getMaPhieu());
            preStmt.setDate(2, obj.getNgayMuon());
            preStmt.setString(3, obj.getMaHV());
            int inserted = preStmt.executeUpdate();
            System.out.println("Insert " +inserted+ " record(s) successfully ");
            return inserted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static List readAllPrimaryValues(){
        connectDB();
        List<String> listPrimaryValues = new ArrayList<String>();
        String sql = "SELECT MAPHIEU FROM PHIEUMUON ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String primaryValue = res.getString(1).trim();
                listPrimaryValues.add(primaryValue);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPrimaryValues;
    }    
    public static String generateNewPrimaryValue(){
        String preFix = "PM";
        List<String> listPrimaryValues = readAllPrimaryValues();
        List<Integer> listPrimaryNums = new ArrayList();
        for(String value : listPrimaryValues){
            String shortenValue = value.replace(preFix, "");
            int num = Integer.parseInt(shortenValue);
            listPrimaryNums.add(num);
        }
        int newNum = Collections.max(listPrimaryNums) +1;
        if(newNum<10){
            return preFix+"00"+newNum;
        } else if(newNum<100){
            return preFix+"0"+newNum;
        }else {
            return preFix+newNum;
        }
    }
    
    public static PhieuMuon readByPrimaryKey(String priValue){
        connectDB();
        String sql = "SELECT * FROM PHIEUMUON  WHERE MAPHIEU = ? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, priValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maPhieu = res.getString("MAPHIEU");
                Date ngayMuon = res.getDate("NGAYMUON");
                String mahv = res.getString("MAHV");
                PhieuMuon obj = new PhieuMuon(maPhieu, ngayMuon, mahv);
                return obj;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static List readAll(){
        connectDB();
        List<PhieuMuon> listObjs = new ArrayList<PhieuMuon>();
        String sql = "SELECT * FROM PHIEUMUON ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maPhieu = res.getString("MAPHIEU");
                Date ngayMuon = res.getDate("NGAYMUON");
                String mahv = res.getString("MAHV");
                PhieuMuon obj = new PhieuMuon(maPhieu, ngayMuon, mahv);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    private static String generateWhereClause(Map<String, Object> colValue){
        StringBuilder whereBuilder = new StringBuilder(" WHERE ");
        int index = 0;
        for (Map.Entry<String, Object> entry : colValue.entrySet()) {
            String colName = entry.getKey();
            Object value = entry.getValue();
            whereBuilder.append(colName + " = ? ");
            index++;
            if(index < colValue.entrySet().size() ){
                whereBuilder.append(" and ");
            }
        }
        return whereBuilder.toString();
    }
    private static void prepareStmtWithColValue(PreparedStatement preStmt , Map<String, Object> colValue) throws SQLException{
        int index = 0;
        for (Map.Entry<String, Object> entry : colValue.entrySet()) {
            index++;
            Object value = entry.getValue();
            preStmt.setObject(index,value);
        }   
    }
    public static List<PhieuMuon>  readByCols(Map<String, Object> colValue){
        connectDB();
        List<PhieuMuon> listObjs = new ArrayList<PhieuMuon>();
        String sql = "SELECT * FROM PHIEUMUON " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maPhieu = res.getString("MAPHIEU");
                Date ngayMuon = res.getDate("NGAYMUON");
                String mahv = res.getString("MAHV");
                PhieuMuon obj = new PhieuMuon(maPhieu, ngayMuon, mahv);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    public static int update(PhieuMuon obj){
        connectDB();
        String sql = "UPDATE PHIEUMUON SET NGAYMUON=? , MAHV=? WHERE MAPHIEU=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(3, obj.getMaPhieu());
            preStmt.setDate(1, obj.getNgayMuon());
            preStmt.setString(2, obj.getMaHV());
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int delete(String maPhieu){
        connectDB();
        String sql = "DELETE FROM PHIEUMUON WHERE MAPHIEU=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, maPhieu );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int deleteByHocVien(String maHV){
        connectDB();
        String sql = "DELETE FROM PHIEUMUON WHERE MAHV=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, maHV );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
//    
//    public static void main(String[] args) {
//        String maPhieu="PM005";
//        Date ngayMuon= Date.valueOf("2024-03-10");
//        String maHV = "HV011";
//        PhieuMuon obj = new PhieuMuon(maPhieu, ngayMuon, maHV);
//        insert(obj);
//        update(obj);
//        delete(maPhieu);
//        obj.setMaPhieu("PM005");
//        insert(obj);
//        try {
//            System.out.println( "Connection is closed: " + conn.isClosed() );
//        } catch (SQLException ex) {
//            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
