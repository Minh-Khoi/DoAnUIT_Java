/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.dao;

import java.sql.Connection;
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
import uit.team.models.mssql.entities.DauSach;

/**
 *
 * @author USER
 */
public class DauSachDAO extends EntityDaoInterface{
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
    
    public static int insert (DauSach dauSach){
        connectDB();
        String sql = "INSERT INTO DAUSACH VALUES (?,?)";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, dauSach.getMaDauSach());
            preStmt.setString(2, dauSach.getTenDauSach());
            int inserted = preStmt.executeUpdate();
            System.out.println("Insert " +inserted+ " record(s) successfully ");
            return inserted;
        } catch (SQLException ex) {
//            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
        return 0;
    }
    
    public static List readAllPrimaryValues(){
        connectDB();
        List<String> listPrimaryValues = new ArrayList<String>();
        String sql = "SELECT MADAUSACH FROM DAUSACH ";
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
        String preFix = "DS";
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
        List<DauSach> listDauSach = new ArrayList<DauSach>();
        String sql = "SELECT * FROM DAUSACH ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maDauSach = res.getString(1);
                String tenDauSach = res.getNString(2);
                DauSach dauSach = new DauSach(maDauSach,tenDauSach);
                listDauSach.add(dauSach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDauSach;
    }
    
    public static DauSach readByPrimaryKey(String priValue){
        connectDB();
        String sql = "SELECT * FROM DAUSACH WHERE MADAUSACH = ? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(1, priValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maDauSach = res.getString(1);
                String tenDauSach = res.getNString(2);
                DauSach dauSach = new DauSach(maDauSach,tenDauSach);
                return dauSach;
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
    public static List readByCols(Map<String, Object> colValue){
        connectDB();
        List<DauSach> listDauSach = new ArrayList<DauSach>();
        String sql = "SELECT * FROM DAUSACH " + generateWhereClause(colValue);
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            prepareStmtWithColValue(preStmt, colValue);
            ResultSet res = preStmt.executeQuery();
            while (res.next()){
                String maDauSach = res.getString(1);
                String tenDauSach = res.getNString(2);
                DauSach dauSach = new DauSach(maDauSach,tenDauSach);
                listDauSach.add(dauSach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDauSach;
    }
    
    public static int update(DauSach dauSach){
        connectDB();
        String sql = "UPDATE DAUSACH SET TENDAUSACH=? WHERE MADAUSACH=? ";
        try(PreparedStatement preStmt = conn.prepareStatement(sql)) {
            preStmt.setString(2, dauSach.getMaDauSach());
            preStmt.setString(1, dauSach.getTenDauSach());
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
        String sql = "DELETE FROM DAUSACH WHERE MADAUSACH=? ";
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
//        DauSach obj = new DauSach("DS011","Khoa hoc Vu Tru - Trai Dat1011");
//        insert(obj);
//        update(obj);
//        delete("DS011");
//        obj.setMaDauSach("DS11");
//        insert(obj);
//        try {
//            System.out.println( "Connection is closed: " + conn.isClosed() );
//        } catch (SQLException ex) {
//            Logger.getLogger(DauSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
