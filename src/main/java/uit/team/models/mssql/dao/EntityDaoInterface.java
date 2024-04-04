/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.dao;

import java.util.List;
import java.util.Map;
import uit.team.models.mssql.entities.EntityInterface;

/**
 *
 * @author USER
 */
public abstract class EntityDaoInterface {
    static void connectDB() {} 
    public static int insert (EntityInterface obj){return 0;};
    public static List readAllPrimaryValues(){return null;}
    public static List readAll(){return null;}
    public static EntityInterface readByPrimaryKey(String priValue){return null;}
    public static List<EntityInterface>  readByCols(Map<String, Object> colValue){return null;}
    public static int update(EntityInterface obj){return 0 ;}
    public static int delete(String prValue){return 0;}
    public static String generateNewPrimaryValue(){return null;};
}
