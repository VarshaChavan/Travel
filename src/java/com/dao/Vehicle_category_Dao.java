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
public class Vehicle_category_Dao extends connectionInitializer{
    public int vehicle_id;
    public Vehicle_category_Dao()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   
  public boolean isRegister(com.pojo.Vehicle_Category vc)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into vehicle_category values(0,?)");
  
 
   stmt.setString(1,vc.getVehicle_cat_name());

   
   

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
  public boolean isupdate(com.pojo.Vehicle_Category vc)throws Exception{
      
  stmt=conn.prepareStatement("update vehicle_category set vehicle_cat_id=?,vehicle_cat_name=? where vehicle_cat_id=?");
  stmt.setInt(1,vc.vehicle_cat_id); 
  stmt.setString(2,vc.vehicle_cat_name);
   
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Vehicle_Category v) throws Exception{
      stmt=conn.prepareStatement("delete from vehicle_category where vehicle_cat_id=?");
  stmt.setInt(1,v.vehicle_cat_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Vehicle_Category> getAllHotels(com.pojo.Vehicle_Category vc)throws Exception{
      ArrayList<com.pojo.Vehicle_Category> al=new ArrayList<com.pojo.Vehicle_Category>();
      stmt=conn.prepareStatement("select * from vehicle_category");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          vc.vehicle_cat_id=rs.getInt(1);
          vc.vehicle_cat_name=rs.getString(2);
         
          
          al.add(vc);
   
          
      }
      return al;
  }  
    public static void main(String x[])throws Exception{
        Vehicle_category_Dao vd=new Vehicle_category_Dao();
    }
    
}
