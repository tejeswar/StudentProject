<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'layout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="cyan">
  <table border="2" align="center" width="100%">
  <tr height="15%">
  <td height="30" colspan="2">
  <tiles:insert attribute="header"></tiles:insert>
  </td>
  </tr>
  <tr height="70%">
  <td width="30%" >
  <tiles:insert attribute="option"></tiles:insert>
  </td>
  <td width="70%">
  <tiles:insert attribute="content"></tiles:insert>
  </td>
  </tr>
  <tr height="15%">
  <td height="30" colspan="2">
  <tiles:insert attribute="footer"></tiles:insert>
  </td>
  </tr>
  </table>
    <br>
  </body>
</html>
