/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;


public class Travel_Agents_Dao extends connectionInitializer{
    public int vehicle_id;
    public Travel_Agents_Dao()throws Exception{
        conn=com.dao.db.getInstance().getConnection();
    }
   
  public boolean isRegister(com.pojo.Travel_Agents t)throws Exception
  {
  // int hotelid=this.get_hotel_Id();
   stmt=conn.prepareStatement("insert into travel_agents values(0,?,?,?,?,?,?,?,?,?)");
  
   stmt.setString(1,t.getTravel_age_name());
   stmt.setString(2,t.getTravel_age_firmname());
   stmt.setString(3,t.getTravel_age_contact());
   stmt.setString(4,t.getTravel_age_email());
    stmt.setString(5,t.getTravel_age_address());
   stmt.setInt(6,t.getCity_id());
    stmt.setInt(7,t.getState_id());
     stmt.setInt(8,t.getCountry_id());
   
   

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
  public boolean isupdate(com.pojo.Travel_Agents t)throws Exception{
      
  stmt=conn.prepareStatement("update travel_agents set travel_age_id=?,travel_age_name=?,travel_age_firmname=?,travel_age_contact=?,travel_age_email=?,travel_age_address,city_id=?,state_id=?,country_id=? where travel_age_id=?");
   stmt.setInt(1,t.travel_age_id); 
  stmt.setString(2,t.travel_age_name);
   stmt.setString(3,t.travel_age_firmname);
   stmt.setString(4,t.travel_age_contact);
   stmt.setString(5,t.travel_age_email);
    stmt.setString(6,t.travel_age_address);
   stmt.setInt(7,t.city_id);
    stmt.setInt(8,t.state_id);
     stmt.setInt(9,t.country_id);
   
 int value=stmt.executeUpdate();
   if(value>0)
  { return true;
   }
  else
   { return false;
  }
  }
  public boolean isDelete(com.pojo.Travel_Agents t) throws Exception{
      stmt=conn.prepareStatement("delete from travel_agents where travel_age_id=?");
  stmt.setInt(1,t.travel_age_id);
 int value=stmt.executeUpdate();
    if(value>0)
    { return true;
    }
    else
    { return false;
    }
  }
  public ArrayList<com.pojo.Travel_Agents> getAllHotels(com.pojo.Travel_Agents t)throws Exception{
      ArrayList<com.pojo.Travel_Agents> al=new ArrayList<com.pojo.Travel_Agents>();
      stmt=conn.prepareStatement("select * from travel_agents");
      rs=stmt.executeQuery();
     
      
      while(rs.next()){
         
          t.travel_age_id=rs.getInt(1);
          t.travel_age_name=rs.getString(2);
          t.travel_age_firmname=rs.getString(3);
          t.travel_age_contact=rs.getString(4);
          t.travel_age_email=rs.getString(5);
          t.travel_age_address=rs.getString(6);
          t.city_id=rs.getInt(7);
          t.state_id=rs.getInt(8);
          t.country_id=rs.getInt(9);
          
          al.add(t);
   
          
      }
      return al;
  } 
    public static void main(String x[])throws Exception{
        Travel_Agents_Dao vd=new Travel_Agents_Dao();
    }
    
    
    
}
