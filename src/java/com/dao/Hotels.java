/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import java.sql.*;
import java.util.*;
import com.pojo.*;
public class Hotels extends connectionInitializer{
   // public int hotel_id;
    public Hotels()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   /* public public int hotel_id;
    public Hotels()throws Exception{
      int get_hotel_Id()throws Exception
  {
   stmt=conn.prepareStatement("select max(hotel_id) from hotels");
   rs=stmt.executeQuery();
   if(rs.next())
   {
    hotel_id=rs.getInt(1);
   }
    return ++hotel_id;

   }*/

  public boolean isRegister(com.pojo.Hotels h)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into hotels values(0,?,?,?,?,?,?,?)");
   //stmt.setInt(1,hotelid);
   stmt.setString(2,h.getHotel_name());
   stmt.setString(3,h.getHotel_address());
   stmt.setInt(4,h.getCountry_id());
   stmt.setInt(5,h.getState_id());
   stmt.setInt(6,h.getPlace_id());
   stmt.setInt(7,h.getHotel_cat_id());
   stmt.setString(8,h.getHotel_description());

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
  public boolean isupdate(com.pojo.Hotels h)throws Exception{
      
  stmt=conn.prepareStatement("update hotels set hotel_name=?,hotel_address=?,country_id=?,state_id=?,place_id=?,hotel_cat_id=?,hotel_description=? where hotel_id=?");
  stmt.setString(2,h.hotel_name);
   stmt.setString(3,h.hotel_address);
   stmt.setInt(4,h.country_id);
   stmt.setInt(5,h.state_id);
   stmt.setInt(6,h.place_id);
   stmt.setInt(7,h.hotel_cat_id);
   stmt.setString(8,h.hotel_description);
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Hotels h) throws Exception{
      stmt=conn.prepareStatement("delete from hotels where hotel_id=?");
  stmt.setInt(1,h.hotel_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Hotels> getAllHotels(com.pojo.Hotels h1)throws Exception{
      ArrayList<com.pojo.Hotels> al=new ArrayList<com.pojo.Hotels>();
      stmt=conn.prepareStatement("select * from hotels");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          h1.hotel_id=rs.getInt(1);
          h1.hotel_name=rs.getString(2);
          h1.hotel_address=rs.getString(3);
          h1.country_id=rs.getInt(4);
          h1.state_id=rs.getInt(5);
          h1.place_id=rs.getInt(6);
          h1.hotel_cat_id=rs.getInt(7);
          h1.hotel_description=rs.getString(8);
          
          al.add(h1);
   
          
      }
      return al;
  } 
    public static void main(String x[])throws Exception{
        Hotels h=new Hotels();
    }
}
