/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;

/**
 *
 * @author SAGARDADA
 */
public class Vehicle_Dao extends connectionInitializer{
    public int vehicle_id;
    public Vehicle_Dao()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   
  public boolean isRegister(com.pojo.Vehicle v)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into vehicle values(0,?,?,?,?,?,?)");
  
   stmt.setInt(1,v.getVehicle_cat_id());
   stmt.setInt(2,v.getVehicle_no());
   stmt.setString(3,v.getVehicle_driver());
   stmt.setString(4,v.getVehicle_model());
    stmt.setString(5,v.getVehicle_company());
   stmt.setString(6,v.getVehicle_status());
   
   

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
  public boolean isupdate(com.pojo.Vehicle v)throws Exception{
      
  stmt=conn.prepareStatement("update vehicle set vehicle_id=?,vehicle_cat_id=?,vehicle_no=?,vehicle_driver=?,vehicle_model=?,vehicle_company=?,vehicle_status=? where vehicle_id=?");
   stmt.setInt(1,v.vehicle_id); 
  stmt.setInt(2,v.vehicle_cat_id);
   stmt.setInt(3,v.vehicle_no);
   stmt.setString(4,v.vehicle_driver);
   stmt.setString(5,v.vehicle_model);
    stmt.setString(6,v.vehicle_company);
   stmt.setString(7,v.vehicle_status);
   
   
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Vehicle v) throws Exception{
      stmt=conn.prepareStatement("delete from vehicle where vehicle_id=?");
  stmt.setInt(1,v.vehicle_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Vehicle> getAllHotels(com.pojo.Vehicle v1)throws Exception{
      ArrayList<com.pojo.Vehicle> al=new ArrayList<com.pojo.Vehicle>();
      stmt=conn.prepareStatement("select * from vehicle");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          v1.vehicle_id=rs.getInt(1);
          v1.vehicle_cat_id=rs.getInt(2);
          v1.vehicle_no=rs.getInt(3);
          v1.vehicle_driver=rs.getString(4);
          v1.vehicle_model=rs.getString(5);
          v1.vehicle_company=rs.getString(6);
          v1.vehicle_status=rs.getString(7);
          
          al.add(v1);
   
          
      }
      return al;
  } 
    public static void main(String x[])throws Exception{
        Vehicle_Dao vd=new Vehicle_Dao();
    }
    
    
    
}
