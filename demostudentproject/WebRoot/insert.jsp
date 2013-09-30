<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	
	var month=document.frm.month.value;
	var year=document.frm.year.value;
	
	
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function validate(){
	var roll=document.frm.roll.value;
	if(roll==""){
	alert("enter roll no");
	document.frm.roll.focus();
	return false;
	}
	else{
	if(isNaN(roll)){
	alert("enter a valid number");
	document.frm.roll.focus();
	return false;
	}
	}
	
	var name=document.frm.name.value;
	if(name==""){
	alert("enter your name");
	document.frm.name.focus();
	return false;
	}
	else{
	if(!isNaN(name)){
	alert("not a valid name");
	document.frm.name.focus();
	return false;
	}
	}
	var phoneno=document.frm.phoneno.value;
	if(phoneno==""){
	alert("enter phonenno");
	document.frm.phoneno.focus();
	return false;
	}
	if(isNaN(phoneno)){
	alert("not a valid phone number");
	document.frm.phoneno.focus();
	return false;
	}
	else{
	var length=phoneno.length;
	
	if(length!=10){
	alert("enter 10 digit number");
	document.frm.phoneno.focus();
	return false;
	}
	}
	var day=document.frm.day.value;
	if(day=="" || day==null){
	alert("enter day");
	document.frm.day.focus();
	return false;
	}
	var month=document.frm.month.value;
	if(month=="month"){
	alert("enter month");
	document.frm.month.focus();
	return false;
	}
	var year=document.frm.year.value;
	if(year=="year"){
	alert("enter year");
	document.frm.month.focus();
	return false;
	}
	if((month=="apr" || month=="june" || month=="sept" || month=="nov") && day==31){
	alert("invalid day");
	return false;
	}
	if(month=="feb")
	{
	   if((year%4==0 && year%100!=0) || year%400==0)
	     {
	         if(day>29)
	           {
	              alert("leap year");
	              return false;
	           }
	     }      
	         else if(day>28)
	           {
	               alert("day can not be more than 28 days");
	                return false;
	             }
	        }
	     
	return true;
	
	}
	</script>
  </head>
  
  <body>
  
  <form action="./greet.do" name="frm">
  <table border="2" width="80%">
  <tr><td width="20%">Roll</td><td><input type="text" name="roll"></td></tr> 
 <tr><td> Name:</td><td><input type="text" name="name"></td></tr>
  <tr><td>Phoneno</td><td><input type="text" name="phoneno"></td></tr>
  <tr><td>email</td><td><input type="text" name="email"></td></tr>
  <tr><td>join date</td><td><select id="day" name="day" size="1" >
  <option></option>
  <%for(int i=1;i<32;i++){ %>
  <option value="<%=i %>"><%=i %></option>
  <%} %>
  <% String[] month={"jan","feb","mar","apr","may","june","july","august","sept","oct","nov","dec"};
  int[] day = {1,2,3,4,5,6,7,8,9,10,11,12};
  %>
  </select>
  <select name="month" size="1" >
  <option value="month">month</option>
  <%for(int i=0;i<12;i++){ %>
  <option value="<%=day[i] %>"><%=month[i] %></option>
  <%} %></select>
  <select name="year" size="1" >
  <option value="year">year</option>
  <%for(int i=1999;i<2012;i++){ %>
  <option value="<%=i %>"><%=i%></option>
  <%} %></select>
  </td>
  </tr>
  </table>
  <br><center><input type="submit" value="insert" onclick="return validate()" /><input type="reset" value="reset">
  </center>
  
  </form>
    <br>
    
  </body>
  
</html>
