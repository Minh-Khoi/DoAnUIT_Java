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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uit.team.models.mssql.dao.DauSachDAO.connectDB;
import uit.team.models.mssql.dbconnect.ConnectToMSSQL;
import uit.team.models.mssql.entities.HocVien;

/**
 *
 * @author USER
 */
public class HocVienDAO extends EntityDaoInterface {
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
    
    
    public static int insert (HocVien obj){
        connectDB();
        String sql = "INSERT INTO HOCVIEN VALUES (?,?,?,?,?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, obj.getMaHV());
            preStmt.setString(2, obj.getTenHV());
            preStmt.setString(3, obj.getSoDT());
            preStmt.setDate(4, obj.getNgaySinh());
            preStmt.setString(5, obj.getDonVi());
            preStmt.setString(6, obj.getGioiTinh());
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
        String sql = "SELECT MAHV FROM HOCVIEN ";
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
        String preFix = "HV";
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
    
    
    public static List readAll(){
        connectDB();
        List<HocVien> listObjs = new ArrayList<HocVien>();
        String sql = "SELECT * FROM HOCVIEN ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maHV = res.getString("MAHV");
                String tenHV = res.getNString("TENHV");
                String soDT = res.getString("SDT");
                Date ngaySinh = res.getDate("NGAYSINH");
                String donVi = res.getString("DONVI");
                String gioiTinh = res.getNString("GIOITINH");
                HocVien obj = new HocVien(maHV, tenHV, soDT, ngaySinh, donVi, gioiTinh);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    
    public static HocVien readByPrimaryKey(String priValue){
        connectDB();
        String sql = "SELECT * FROM HOCVIEN WHERE MAHV = ? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, priValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maHV = res.getString("MAHV");
                String tenHV = res.getNString("TENHV");
                String soDT = res.getString("SDT");
                Date ngaySinh = res.getDate("NGAYSINH");
                String donVi = res.getString("DONVI");
                String gioiTinh = res.getString("GIOITINH");
                HocVien obj = new HocVien(maHV, tenHV, soDT, ngaySinh, donVi, gioiTinh);
                return obj;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public static List  readByCols(Map<String, Object> colValue){
        connectDB();
        List<HocVien> listObjs = new ArrayList<HocVien>();
        String sql = "SELECT * FROM HOCVIEN " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maHV = res.getString("MAHV");
                String tenHV = res.getNString("TENHV");
                String soDT = res.getString("SDT");
                Date ngaySinh = res.getDate("NGAYSINH");
                String donVi = res.getString("DONVI");
                String gioiTinh = res.getNString("GIOITINH");
                HocVien obj = new HocVien(maHV, tenHV, soDT, ngaySinh, donVi, gioiTinh);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    
    public static int update(HocVien obj){
        connectDB();
        String sql = "UPDATE HOCVIEN SET  TENHV=?, SDT=?, NGAYSINH=?,DONVI=?, GIOITINH=? WHERE MAHV=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(6, obj.getMaHV());
            preStmt.setString(1, obj.getTenHV());
            preStmt.setString(2, obj.getSoDT());
            preStmt.setDate(3, obj.getNgaySinh());
            preStmt.setString(4, obj.getDonVi());
            preStmt.setString(5, obj.getGioiTinh());
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int delete(String prValue){
        connectDB();
        String sql = "DELETE FROM HOCVIEN WHERE MAHV=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, prValue );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
//    public static void main(String[] args) {
//        String maHV="HV0110";
//        String tenHV="Nguyen Ngoc Minh Khoi";
//        String sdt="0362889147";
//        Date ngaySinh = new Date(1995 - 1900, 10 - 1, 10);
//        String donvi = "Pru-Indo";
//        String gioiTinh = "Nam";
//        HocVien obj = new HocVien(maHV, tenHV, sdt, ngaySinh, donvi, gioiTinh);
//        insert(obj);
//        update(obj);
//        delete(maHV);
//        obj.setMaHV("HV011");
//        insert(obj);
//        try {
//            System.out.println( "Connection is closed: " + conn.isClosed() );
//        } catch (SQLException ex) {
//            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
//    public static void main(String[] args) {
//        Map map = new HashMap<String, Object>();
//        map.put("DONVI", "Pru-Indo");
//        List<HocVien> listObjs = readByCols(map);
//        System.out.println(listObjs);
//    }
}
