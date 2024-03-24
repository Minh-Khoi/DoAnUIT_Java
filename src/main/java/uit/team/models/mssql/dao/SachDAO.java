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
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class SachDAO {
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
    
    public static int insert (Sach obj){
        connectDB();
        String sql = "INSERT INTO SACH VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, obj.getMaSach());
            preStmt.setString(2, obj.getTenSach());
            preStmt.setString(3, obj.getTrangThai());
            preStmt.setInt(4, obj.getSoLuong());
            preStmt.setString(5, obj.getTenNXB());
            preStmt.setString(6, obj.getTenTG());
            preStmt.setString(7, obj.getMaDauSach());
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
        String sql = "SELECT MASACH FROM SACH ";
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
        String preFix = "BK";
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
        List<Sach> listObjs = new ArrayList<Sach>();
        String sql = "SELECT * FROM SACH ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maSach = res.getNString("MASACH");
                String tenSach = res.getNString("TENSACH");
                String trangThai = res.getNString("TRANGTHAI");
                int soLuong = res.getInt("SOLUONG");
                String tenNXB = res.getNString("TENNXB");
                String tenTG = res.getNString("TENTG");
                String maDauSach = res.getNString("MADAUSACH");
                Sach obj = new Sach(maSach, tenSach, trangThai, soLuong, tenNXB, tenTG, maDauSach);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    
    public static Sach readByPrimaryKey(String priValue){
        connectDB();
        String sql = "SELECT * FROM SACH  WHERE MASACH = ? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, priValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maSach = res.getNString("MASACH");
                String tenSach = res.getNString("TENSACH");
                String trangThai = res.getNString("TRANGTHAI");
                int soLuong = res.getInt("SOLUONG");
                String tenNXB = res.getNString("TENNXB");
                String tenTG = res.getNString("TENTG");
                String maDauSach = res.getNString("MADAUSACH");
                Sach obj = new Sach(maSach, tenSach, trangThai, soLuong, tenNXB, tenTG, maDauSach);
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
    public static List<Sach>  readByCols(Map<String, Object> colValue){
        connectDB();
        List<Sach> listObjs = new ArrayList<Sach>();
        String sql = "SELECT * FROM SACH " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maSach = res.getNString("MASACH");
                String tenSach = res.getNString("TENSACH");
                String trangThai = res.getNString("TRANGTHAI");
                int soLuong = res.getInt("SOLUONG");
                String tenNXB = res.getNString("TENNXB");
                String tenTG = res.getNString("TENTG");
                String maDauSach = res.getNString("MADAUSACH");
                Sach obj = new Sach(maSach, tenSach, trangThai, soLuong, tenNXB, tenTG, maDauSach);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    public static int update(Sach obj){
        connectDB();
        String sql = "UPDATE SACH SET MADAUSACH=? , TENSACH=?, TRANGTHAI=? , SOLUONG=?, TENNXB=? , TENTG=? WHERE MASACH=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(7, obj.getMaSach());
            preStmt.setString(1, obj.getMaDauSach());
            preStmt.setString(2, obj.getTenSach());
            preStmt.setString(3, obj.getTrangThai());
            preStmt.setInt(4, obj.getSoLuong());
            preStmt.setString(5, obj.getTenNXB());
            preStmt.setString(6, obj.getTenTG());
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int delete(String maSach){
        connectDB();
        String sql = "DELETE FROM SACH WHERE MASACH=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, maSach );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
//    public static void main(String[] args) {
//        String maSach="BK011";
//        String tenSach="MInh Khôi VĨ Đại";
//        String trangThai="Còn";
//        int soLuong=33;
//        String tenNXB="Khoa học vũ trụ";
//        String tenTG="Nguyễn Ngọc Minh Khôi";
//        String maDauSach="DS05";
//        Sach obj = new Sach(maSach, tenSach, trangThai, soLuong, tenNXB, tenTG, maDauSach);
//        insert(obj);
//        update(obj);
//        delete(maSach);
//        obj.setMaSach("BK012");
//        insert(obj);
//        try {
//            System.out.println( "Connection is closed: " + conn.isClosed() );
//        } catch (SQLException ex) {
//            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
