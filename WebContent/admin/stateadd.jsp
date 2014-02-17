<%@page import="java.io.PrintWriter"%>
<%@  page contentType="text/html; charset=iso-8859-1" language="java"
import="java.util.*,java.text.*,java.io.*" errorPage=""%>
 <%@ page import = "requirementlogic.*"  %>
 <%@ page import = "java.util.ArrayList" %>
      <%VariableIntialization ds_country =(VariableIntialization)session.getAttribute("deshopa_country"); %>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">

	<!-- Set the viewport width to device width for mobile -->
	<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
    
	<!-- Set meta informations -->
	<title>DeShoppa.com</title>
	<meta name="description" content="The DeShoppa is a responsive ecommerce template for your next projects">
	<meta name="author" content="">
<jsp:useBean id="VRI" class="requirementlogic.VariableIntialization"/>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
    
    <div class="container make-bg PT15" style="min-height:500px;">
<form method="get" action="../State" name="location" id="location">
<div class="span2"><select name="country_ref" id="country_ref" class="clear">

<%
	StateAdd SA = new StateAdd();
 	List country_List = SA.getcountry();
 	if(country_List.size()!=0){
 	     for (int i = 0; i < country_List.size(); i++) {
 	    	VRI = (VariableIntialization) country_List.get(i);%>
<option value="<%=VRI.getcountry_id().get(i) %>"><%= VRI.getcountry().get(i)%></option>

<%} %>


</select></div>
<%} %>
<div class="span3 clear">
state<input type="text" value="" name="state" id="state"/>

<input type="submit" value="submit"/>
</div>

</form>
	</div> 

</body></html>





