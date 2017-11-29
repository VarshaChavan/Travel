/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;
import java.sql.*;
public class Place_Dao extends connectionInitializer{
    public int hotel_id;
    public Place_Dao()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   
  public boolean isRegister(com.pojo.Place p)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into place values(0,?,?,?,?)");
  
   stmt.setString(1,p.getPlace_name());
   stmt.setInt(2,p.getState_id());
   stmt.setInt(3,p.getCountry_id());
   stmt.setInt(4,p.getCity_id());
   
   

   int value=stmt.executeUpdate();
   if(value>0)
   {
    return true;
   }
   else
   {
   return false;
   }
  }
  public boolean isupdate(com.pojo.Place p)throws Exception{
      
  stmt=conn.prepareStatement("update place set place_id=?,place_name=?,state_id=?,country_id=?,city_id=? where place_id=?");
   stmt.setInt(1,p.place_id);
   stmt.setString(2,p.place_name);
   stmt.setInt(3,p.state_id);
   stmt.setInt(4,p.country_id);
   stmt.setInt(5,p.city_id);
   
   
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Place p) throws Exception{
      stmt=conn.prepareStatement("delete from place where place_id=?");
  stmt.setInt(1,p.place_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Place> getAllHotels(com.pojo.Place p1)throws Exception{
      ArrayList<com.pojo.Place> al=new ArrayList<com.pojo.Place>();
      stmt=conn.prepareStatement("select * from place");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          p1.place_id=rs.getInt(1);
          p1.place_name=rs.getString(2);
          p1.state_id=rs.getInt(3);
          p1.country_id=rs.getInt(4);
          p1.city_id=rs.getInt(5);
          
          
          al.add(p1);
   
          
      }
      return al;
  } 
    public static void main(String x[])throws Exception{
        Place_Dao pd=new Place_Dao();
    }
    
    
}
