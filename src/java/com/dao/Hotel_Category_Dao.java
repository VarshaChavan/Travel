/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;
import java.sql.*;

public class Hotel_Category_Dao extends connectionInitializer{
    public int hotel_id;
    public Hotel_Category_Dao()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   
  public boolean isRegister(com.pojo.Hotel_Category hc)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into hotel_category values(0,?)");
  
   stmt.setString(1,hc.getHotel_cat_name());
   
   

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
  public boolean isupdate(com.pojo.Hotel_Category hc)throws Exception{
      
  stmt=conn.prepareStatement("update hotel_category set hotel_cat_id=?,hotel_cat_name=? where hotel_cat_id=?");
  stmt.setInt(1,hc.hotel_cat_id);
   stmt.setString(2,hc.hotel_cat_name);
   
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Hotel_Category hc) throws Exception{
      stmt=conn.prepareStatement("delete from hotel_category where hotel_cat_id=?");
  stmt.setInt(1,hc.hotel_cat_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Hotel_Category> getAllHotelCategory(com.pojo.Hotel_Category hc)throws Exception{
      ArrayList<com.pojo.Hotel_Category> al=new ArrayList<com.pojo.Hotel_Category>();
      stmt=conn.prepareStatement("select * from hotel_category");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          hc.hotel_cat_id=rs.getInt(1);
          hc.hotel_cat_name=rs.getString(2);
         
          
          al.add(hc);
   
          
      }
      return al;
  }  
    public static void main(String x[])throws Exception{
        Hotel_Category_Dao hcd=new Hotel_Category_Dao();
    }
    
}
