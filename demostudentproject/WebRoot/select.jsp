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
    
    <title>My JSP 'select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="orange"><center><h1>WELCOME TO SELECT PAGE</h1>
  <% 
  
  List<Student> list=(List<Student>)request.getAttribute("list");
  Set<Student> s=new TreeSet<Student>(list);
  /*long l=7795732473l;
  Student s=new Student();
  s.setRoll(5);
  s.setName("tejes");
  s.setEmailid("tejes@gmail.com");
  s.setPhoneno(l);
  s.setDate("7-nov-1987");
  Student st1=new Student();
  st1.setRoll(1);
  st1.setName("akhu");
  st1.setEmailid("akhu@gmail.com");
  st1.setPhoneno(8765432123l);
  st1.setDate("17-jan-1934");
  list.add(s);
  list.add(st1);*/
  %>
  <table border="2" width="100%">
  <tr><td>Roll</td><td>Name</td><td>phoneno</td><td>emailid</td><td>join date</td></tr>
  <%for(Student st:s){
  if(st.getEmailid()==null)
  st.setEmailid("   ");
   %>
  
  <tr bordercolor="red"><td bordercolor="yellow"><%=st.getRoll() %></td><td><%=st.getName() %></td>
  <td><%=st.getPhoneno() %></td><td><%=st.getEmailid() %></td>
  <td><%=st.getDate() %></td></tr><%} %>
  
  
  </table>
  
  </center>
    <br>
  </body>
</html>
