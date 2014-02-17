<%@page import="category.Menu_Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "requirementlogic.*" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">

	<jsp:useBean id="MVR" class="category.MenuVariables"/>
	<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
$("#catsubmit").click(function(event){
	  event.preventDefault();
	 
	  var menuForm = $("#menu option:selected").val();
	  var categoryform = $("#Category").val();
	 
    $.get("../CategoryInsert?checkparameter=insert",
	{menu : menuForm,
    	Category:categoryform,
	}
	,function(data){
		$("#Category").val("");
		$("#insertioncompleted").empty().append(data);
		});
  });
});
</script>
	</head>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
    
    <div class="container make-bg PT15" style="min-height:500px;">
<form method="get" action="" name="location" id="location">

<div class="span2"><select name="menu" id="menu" class="clear">

<%
	Menu_Listing ML =new Menu_Listing();
 	List menu_List = ML.getMenu();

 	     for (int i = 0; i < menu_List.size(); i++) {
 	    	MVR = (category.MenuVariables) menu_List.get(i);%>

<option value="<%=MVR.getmenuid().get(i)%>"><%=MVR.getmenu().get(i)%></option>

<%} %>


</select></div>

<div class="span3 clear">
SubCategory<input type="text" value="" name="Category" id="Category"/>

<input type="submit" value="submit" id="catsubmit"/>
</div>

</form>
<div id="insertioncompleted" class="span5 clear"></div>
	</div> 

</body></html>





