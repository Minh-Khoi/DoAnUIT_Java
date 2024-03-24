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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.team.models.mssql.dbconnect.ConnectToMSSQL;
import uit.team.models.mssql.entities.TraSach;

/**
 *
 * @author USER
 */
public class TraSachDAO {
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
    
    
    public static int insert (TraSach obj){
        connectDB();
        String sql = "INSERT INTO SACH VALUES (?,?,?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, obj.getMaSach());
            preStmt.setString(2, obj.getMaHV());
            preStmt.setString(3, obj.getTrangThai());
            preStmt.setDate(4, obj.getNgayTra());
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
        List<TraSach> listObjs = new ArrayList<TraSach>();
        String sql = "SELECT * FROM TRASACH ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maSach = res.getNString("MASACH");
                String maHV = res.getNString("MAHV");
                String trangThai = res.getNString("TRANGTHAI");
                Date ngayTra = res.getDate("NGAYTRA");
                TraSach obj = new TraSach(maSach, maHV, trangThai, ngayTra);
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
    public static List<TraSach>  readByCols(Map<String, Object> colValue){
        connectDB();
        List<TraSach> listObjs = new ArrayList<TraSach>();
        String sql = "SELECT * FROM TRASACH " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maSach = res.getNString("MASACH");
                String maHV = res.getNString("MAHV");
                String trangThai = res.getNString("TRANGTHAI");
                Date ngayTra = res.getDate("NGAYTRA");
                TraSach obj = new TraSach(maSach, maHV, trangThai, ngayTra);
                listObjs.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listObjs;
    }
    
    public static int update(TraSach obj){
        connectDB();
        String sql = "UPDATE TRASACH SET  TRANGTHAI=? , NGAYTRA=? WHERE MASACH=? AND MAHV=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(3, obj.getMaSach());
            preStmt.setString(4, obj.getMaHV());
            preStmt.setString(1, obj.getTrangThai());
            preStmt.setDate(2, obj.getNgayTra());
            int updated = preStmt.executeUpdate();
            System.out.println("Update " +updated+ " record(s) successfully ");
            return updated;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public static int delete(String maSach,String maHV){
        connectDB();
        String sql = "DELETE FROM TRASACH WHERE MASACH=?  AND MAHV=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, maSach );
            preStmt.setString(2, maHV );
            int deleted = preStmt.executeUpdate();
            System.out.println("Delete " +deleted+ " record(s) successfully ");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
}
