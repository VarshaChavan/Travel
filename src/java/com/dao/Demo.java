/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

/**
 *
 * @author SAGARDADA
 */
public class Demo extends connectionInitializer {
   public Demo() throws Exception{
   
   conn=com.dao.db.getInstance().getConnection();
   
   }
    
  
}
