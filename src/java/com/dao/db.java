/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class db {

    public static Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private db() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/travel", "root", "root");
            
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    
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

    public  Connection getConnection() throws Exception {
        return conn;
    }

    public static db getInstance() throws Exception {
        db d = new db();
        return d;
    }

    public static void main(String x[]) throws Exception {
        db d = new db();
    }
}
