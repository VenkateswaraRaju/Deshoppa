<%@page import="category.Menu_Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "requirementlogic.*" %>
     <%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="MVR" class="category.MenuVariables"/>
<body>
<%@ include file="header.jsp" %> 

    <div class="container make-bg" style="min-height:500px;">


<%
	Menu_Listing ML =new Menu_Listing();
 	List menu_List = ML.getMenu();
 	if(menu_List.size()!=0){
 	     for (int i = 0; i < menu_List.size(); i++) {
 	    	MVR = (category.MenuVariables) menu_List.get(i);%>
<form  action="../Menu?menudelete=delete" method="get">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="form-table">
  <tr>
    <td width="41%" class="PL10 PR10" style="text-align:left;">
    <div class="MT10" id="country_holder"><input type='text' name="menu" value="<%=MVR.getmenu().get(i)%>"/><input type='hidden' value="<%=MVR.getmenuid().get(i)%>" name="menu_Id"/></div>*edit here itself n update</td>
    <td width="19%" colspan="3"><input value="update" type="submit" id="update_button" class="MT10" name="update_button" /> </td>
    <td width="14%"><div id="countrydelete_holder"><input type="submit" value="delete" name="delete_menu" onclick="form.action='../MenuEdit';"/></div></td>
      </tr>

</table>
</form>
<%}}%>
	</div> 
</body>
</html>