<%-- 
    Document   : AddCountry
    Created on : Nov 29, 2017, 2:47:07 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.dao.CountryDao" %>
<%@page import="com.pojo.CountryPojo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    </head>
    <body>
     <%
         try{
     CountryDao countrydao= new CountryDao();
     CountryPojo c= new CountryPojo();
     
     
     String country_name=request.getParameter("country_name");
     
     
     c.setCountry_name(country_name);
     
     boolean b=countrydao.AddCountry(c);
     if(b){
     
     System.out.println("Country Added Successfully");
     
     %>
     
     <script>
         alert("Country Added");
         window.location.href="Country.jsp";
         
     </script>
        
        
        <%
     
     }
         }catch(Exception e){
         
         System.out.println(""+e);
         }
     
     %>
    </body>
</html>
