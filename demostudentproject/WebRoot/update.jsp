<%@ page language="java" import="java.util.*,com.dataaccesslayer.dto.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	alert(leng+" radio button is present");
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
function f1(){
var flag=false;
var i;
var leng=document.frm.male.length;
if(leng==undefined){
leng=1;
}

if(leng==1){
if(document.frm.male.checked){
flag=true;
}
}
else{
for(i=0;i<leng;i++){
if(document.frm.male[i].checked){
flag=true;
chose=document.frm.male[i].value;
}
}
}
if(flag==false){
alert("choose any record to update");
return false;
}
return true;
}
</script>
  </head>
  
  <body bgcolor="yellow"><center><h1>WELCOME TO UPDATE PAGE</h1>
  <form name="frm" action="./upd.do">
  <% 
  
  List<Student> list=(List<Student>)request.getAttribute("list");
  
  %>
  <table border="2" width="100%">
  <tr><td>update</td><td>Roll</td><td>Name</td><td>phoneno</td><td>emailid</td><td>join date</td></tr>
  <%for(Student st:list){ %>
  
  <tr><td><input type="radio" name="male" value=<%=st.getRoll()%> /></td><td><%=st.getRoll() %></td><td><%=st.getName() %></td>
  <td><%=st.getPhoneno() %></td><td><%=st.getEmailid() %></td>
  <td><%=st.getDate() %></td></tr><%} %>
  
  
  </table>
  <input type="submit" value="update"  onclick="return f1() "/>
  </form>
  </center>
    <br>
  </body>
</html>
