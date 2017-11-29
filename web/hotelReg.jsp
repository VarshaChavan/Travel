<%-- 
    Document   : hotelReg
    Created on : Nov 28, 2017, 4:34:40 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="conn.jsp"/>

<html>
<head>
<title> Hotel reg</title>

<style>
div {
    background-color: rgba(0,0,0,0.57);
    width: 500px;
    height:500px;
    border: 25px black;
    padding: 25px;
     margin-top: 100px;
   
    margin-left: 400px;
    border-radius: 50px;
}
input{
    width:60%;
    height:8%;
    
}
.button {
    background-color: #4CAF50;
    border: none;
    width:30%;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 12px;
}
select{
   width:50%;
   height:8%;
}
body{
   background-repeat: no-repeat;
      background-size: 1500px 700px;
}
h1{
  color:white;
}

</style>
</head>
<body background="hotel4.jpg" >
<form name="frm" action="connect.jsp" method="POST">

<div align="center" id=1>
<h1>Hotel registration</h1><br><br>


<input type="text" name="hotel_name" value="placeholder=Hotel_name" ><br><br>
<input type="text"name="hotel_name" value=" placeholder=Hotel_address"><br><br>
<input type="text" name="hotel_name" value=" placeholder=Hotel_description"><br><br><br>

<select>
  <option value="1 star">1 star</option>
  <option value="2 star">2 star</option>
  <option value="3 star">3 star</option>
  <option value="4 star">4 star</option>
  <option value="5 star">5 star</option>
</select><br><br>


<input type="button" name="s" class="button" value="Submit">

</div>
</form>



</body>

</html>