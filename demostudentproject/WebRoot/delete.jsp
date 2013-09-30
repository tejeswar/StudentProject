<%@ page language="java" import="java.util.*,com.dataaccesslayer.dto.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	alert("length is:"+len); 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
function f1(){
var j;
var len=document.frm.x.length;
var flag=false; 
if(len==undefined){
len=1;
} 

var count=0;
if(len==1){
if(document.frm.x.checked){
flag=true;
count++;
}
}
else  {               
for(j=0;j<len;j++){
if(document.frm.x[j].checked){
count++;
flag=true;
}
}
}

if(flag==false){
alert("choose records to delete");
return false;
}
var f=window.confirm("Do u really want to delete record");
if(f==false)
  return false;
return true;
}
</script>
  </head>
  
  <body bgcolor="red"><center><h1>WELCOME TO DELETE PAGE</h1>
  <form name="frm" action="./del.do">
  <% 
  
  List<Student> list=(List<Student>)request.getAttribute("list");
 
  %>
  <table border="2" width="100%">
  <tr><td>selec to delete</td><td>Roll</td><td>Name</td><td>phoneno</td><td>emailid</td><td>join date</td></tr>
  <%for(Student st:list){ %>
  
  <tr><td><input type="checkbox" name="x" value="<%=st.getRoll() %>"></td><td><%=st.getRoll() %></td><td><%=st.getName() %></td>
  <td><%=st.getPhoneno() %></td><td><%=st.getEmailid() %></td>
  <td><%=st.getDate() %></td></tr><%} %>
  
  
  </table>
  <input type="submit" value="delete" onclick="return f1()">
  </form>
  </center>
    <br>
  </body>
</html>
