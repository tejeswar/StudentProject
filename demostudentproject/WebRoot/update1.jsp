<%@page import="com.dataaccesslayer.dto.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    Student student=null;
    student=(Student)request.getAttribute("student");
   
     %><br>
     <form action="./up.do">
     <table border="2" width="80%">
  <tr><td width="20%">Roll</td><td><input type="text" name="roll1" value="<%=student.getRoll()%>" disabled="disabled" ></td>
  <td><input type="hidden"" name="roll" value="<%=student.getRoll()%>" ></td>
  </tr> 
 <tr><td> Name:</td><td><input type="text" name="name" value="<%=student.getName()%>"></td></tr>
  <tr><td>Phoneno</td><td><input type="text" name="phoneno" value="<%=student.getPhoneno()%>"></td></tr>
  <tr><td>email</td><td><input type="text" name="email" value="<%=student.getEmailid()%>"></td></tr>
  </table>
  <center><input type="submit" value="save" /></center>
  </form>
  </body>
</html>
