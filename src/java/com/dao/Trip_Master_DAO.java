/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.*;
import com.pojo.*;

public class Trip_Master_DAO extends connectionInitializer{
    public Trip_Master_DAO()throws Exception{
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

  public boolean isRegister(com.pojo.Trip_Master tm)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into hotels values(0,?,?,?,?)");
   //stmt.setInt(1,hotelid);
   stmt.setInt(2,tm.getAuc_id());
   stmt.setInt(3,tm.getTravel_age_id());
   stmt.setString(4,tm.getTrip_confirmdate());
   stmt.setInt(5,tm.getQuot_id());
  

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
  public boolean isupdate(com.pojo.Trip_Master tm)throws Exception{
      
  stmt=conn.prepareStatement("update hotels set auc_id=?,travel_age_id=?,trip_confirmdate=?,quot_id=? where trip_master_id=?");
  stmt.setInt(2,tm.auc_id);
  stmt.setInt(3,tm.travel_age_id);
  stmt.setString(4,tm.trip_confirmdate);
  stmt.setInt(5,tm.quot_id);
 
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Trip_Master tm) throws Exception{
      stmt=conn.prepareStatement("delete from trip_master where trip_master_id=?");
  stmt.setInt(1,tm.trip_master_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Trip_Master> getAllHotels(com.pojo.Trip_Master tm)throws Exception{
      ArrayList<com.pojo.Trip_Master> al=new ArrayList<com.pojo.Trip_Master>();
      stmt=conn.prepareStatement("select * from trip_master");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          tm.trip_master_id=rs.getInt(1);
          tm.auc_id=rs.getInt(2);
          tm.travel_age_id=rs.getInt(3);
          tm.trip_confirmdate=rs.getString(4);
          tm.quot_id=rs.getInt(5);
         
          al.add(tm);
   
          
      }
      return al;
  } 
    public static void main(String x[])throws Exception{
        Trip_Master t=new Trip_Master();
    }
}
