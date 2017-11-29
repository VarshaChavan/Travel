<%@page import="java.sql.*" %>
<%
 Connection conn;
 PreparedStatement stmt;
 ResultSet rs;
 try
 {
  Class.forName("com.mysql.jdbc.Driver");
  conn=DriverManager.getConnection("jdbc:mysql://localhost:3309/travel","root","root");
  if(conn!=null)
   {
   }
   else
   { out.println("Some problem is there");
   }
 }
catch(Exception e)
 { out.println("Error is  "+e);
 }
%>
