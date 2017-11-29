/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class CountryDao  extends connectionInitializer{
    public CountryDao() throws Exception{
    conn=com.dao.db.getInstance().getConnection();
   
    }
    
    public boolean AddCountry(com.pojo.CountryPojo c) throws Exception{
    
    stmt=conn.prepareStatement("insert into country values(0,?)");
    stmt.setString(1, c.getCountry_name());
    int value=stmt.executeUpdate();
    if(value>0){
    
    return true;
    }
    else{
    
    return false;
    }
    
    }
    
    
    
    
    public ArrayList getCountry() throws Exception{
   ArrayList al= new ArrayList();
   com.pojo.CountryPojo c;
   stmt=conn.prepareStatement("select * from country");
   rs=stmt.executeQuery();
   while(rs.next()){
   c= new com.pojo.CountryPojo();
   c.setCountry_id(rs.getInt(1));
   c.setCountry_name(rs.getString(2));
   al.add(c);
   }
    return al;
    }
    
    
}
