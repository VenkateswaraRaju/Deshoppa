<%@page import="category.MenuVariables"%>
<%@page import="category.CategoryListing"%>
<%@page import="category.Menu_Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "requirementlogic.*" %>
     <%@ page import="java.util.List" %>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">

	
	<% category.MenuVariables MVR = new category.MenuVariables();%>
	<% category.MenuVariables MVRR = new category.MenuVariables();%>
	<% category.MenuVariables MVVR = new category.MenuVariables();%>

	<head>

	</head>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
   
 	  
 	

    
    <div class="container make-bg PT15" style="min-height:500px;">
    
   <%
	CategoryListing CL =new CategoryListing();
	Menu_Listing MLL =new Menu_Listing();
	Menu_Listing ML =new Menu_Listing();
 	List cat_list = CL.getCategory();
 	List cat_list_where=null;
 	List menu_List=null;
 	     for (int i = 0; i < cat_list.size(); i++) {
 	    	MVR = (category.MenuVariables)cat_list.get(i);
 	    	%> 
<form method="get" action="" name="location" id="location">

<div class="span2">

<select name="menu" id="menu" class="clear">

 <%

 	 cat_list_where = MLL.getMenuWhereId(MVR.getmenuid().get(i));
 	
 	
 	     for (int k = 0; k < cat_list_where.size(); k++) {
 	    	MVVR = (category.MenuVariables)cat_list_where.get(k);
 	    
 	    	%>
 <option value="<%=MVVR.getmenuid().get(k)%>"><%=MVVR.getmenu().get(k)%></option>
 <%} %>
<%

 	 menu_List = ML.getMenu();
 	
 	     for (int j = 0; j < menu_List.size(); j++) {
 	    	MVRR = (category.MenuVariables)menu_List.get(j);%>

<option value="<%=MVRR.getmenuid().get(j)%>"><%=MVRR.getmenu().get(j)%></option>

<%} %>


</select></div>

<div class="span3">
SubCategory:<input type="text" value="<%=MVR.getcategory().get(i) %>" name="Category" id="Category"/>
<input type="hidden" value="<%=MVR.getcategoryid().get(i) %>" name="Categoryid" id="Categoryid"/>
<input type="hidden" name="checkparameter" value="delete"/>
</div>
<div class="span2"><input type="submit" value="delete" id="catsubmit" onclick="form.action='../CategoryDeleteUpdate';"/></div>
<div class="clear"></div>
</form>
    <%} %>	
    
<div id="insertioncompleted" class="span5 clear"></div>
	</div> 

</body></html>





