<%-- 
    Document   : State
    Created on : Nov 29, 2017, 2:59:01 PM
    Author     : lenovo
--%>

<%@page import="com.pojo.CountryPojo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="countrydao" class="com.dao.CountryDao"></jsp:useBean>
        <jsp:useBean id="c" class="com.pojo.CountryPojo"></jsp:useBean>
    </head>
    <body>
       <form action="AddCountry.jsp" method="post">
            
        <table>
            <tr>
                <td>State</td>
                <td><input type="text" name="country_name"></td>
           
            </tr>
            
             <tr>
                <td>Country</td>
                <td><select>
                    <%
                   java.util.ArrayList al=countrydao.getCountry();
                   
java.util.Iterator ir=al.iterator();
while(ir.hasNext()){
c= (CountryPojo) ir.next();
%>
<option value="<%=c.getCountry_id()%>"><%=c.getCountry_name()%></option>
                        <%



}
                    
                    
                    
                    
                    %>
                        
                        
                        
                    </select></td>
           
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="submit"></td>
                
            </tr>
            
        </table>
            </form>
    </body>
</html>
