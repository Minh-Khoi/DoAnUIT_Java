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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.team.models.mssql.dbconnect.ConnectToMSSQL;
import uit.team.models.mssql.entities.MuonSach;

/**
 *
 * @author USER
 */
public class MuonSachDAO {
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
    
    public static int insert (MuonSach obj){
        connectDB();
        String sql = "INSERT INTO MUONSACH VALUES (?,?,?,?,?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, obj.getMaPhieu());
            preStmt.setString(2, obj.getMaSach());
            preStmt.setString(3, obj.getTrangThai());
            preStmt.setDate(4, obj.getNgayHenTra());
            preStmt.setDate(5, obj.getNgayTra());
            preStmt.setString(6, obj.getTrangThaiTra());
            int inserted = preStmt.executeUpdate();
            System.out.println("Insert " +inserted+ " record(s) successfully ");
            return inserted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static List readAll(){
        connectDB();
        List<MuonSach> listObjs = new ArrayList<MuonSach>();
        String sql = "SELECT * FROM MUONSACH ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maPhieu = res.getString("MAPHIEU");
                String maSach = res.getString("MASACH");
                String trangThai = res.getNString("TRANGTHAI");
                Date ngayHenTra = res.getDate("NGAYHENTRA");
                Date ngayTra = res.getDate("NGAYTRA");
                String trangThaiTra = res.getNString("TRANGTHAITRA");
                MuonSach obj = new MuonSach(maPhieu, maSach, trangThai, ngayHenTra, ngayTra, trangThaiTra);
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
    public static List<MuonSach>  readByCols(Map<String, Object> colValue){
        connectDB();
        List<MuonSach> listObjs = new ArrayList<MuonSach>();
        String sql = "SELECT * FROM MUONSACH " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maPhieu = res.getString("MAPHIEU");
                String maSach = res.getString("MASACH");
                String trangThai = res.getNString("TRANGTHAI");
                Date ngayHenTra = res.getDate("NGAYHENTRA");
                Date ngayTra = res.getDate("NGAYTRA");
                String trangThaiTra = res.getNString("TRANGTHAITRA");
                MuonSach obj = new MuonSach(maPhieu, maSach, trangThai, ngayHenTra, ngayTra, trangThaiTra);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    
    
    public static int update(MuonSach obj){
        connectDB();
        String sql = "UPDATE MUONSACH SET  TRANGTHAI=?, NGAYHENTRA=?, NGAYTRA=?,TRANGTHAITRA=? WHERE MASACH=? AND MAPHIEU=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(6, obj.getMaPhieu());
            preStmt.setString(5, obj.getMaSach());
            preStmt.setString(1, obj.getTrangThai());
            preStmt.setDate(2, obj.getNgayHenTra());
            preStmt.setDate(3, obj.getNgayTra());
            preStmt.setString(4, obj.getTrangThaiTra());
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int delete(String maPhieu, String maSach){
        connectDB();
        String sql = "DELETE FROM MUONSACH WHERE MASACH=? and MAPHIEU=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, maSach );
            preStmt.setString(2, maPhieu );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int deleteByForeignKey(String key, String value){
        connectDB();
        String sql = "DELETE FROM MUONSACH WHERE <key>=? ".replaceAll("<key>", key);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, value );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int updateTrangThaiTraByPhieuMuon(String maPhieuMuon, String trangThaiTra){
        connectDB();
        String sql = "UPDATE MUONSACH SET  TRANGTHAITRA=? , NGAYTRA = ? WHERE  MAPHIEU=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, trangThaiTra);
            preStmt.setDate(2, (trangThaiTra.equals("OK"))? new Date(new java.util.Date().getTime()) : null);
            preStmt.setString(3, maPhieuMuon);
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        String maPhieu="PM003";
//        Map map = new HashMap();
//        map.put("NGAYTRA", null);
//        List<MuonSach> objs = readByCols(map);
//        System.out.println(Objects.isNull(objs.get(0).getNgayTra()));
//    }
}
