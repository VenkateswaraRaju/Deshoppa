<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "requirementlogic.*" %>
     <%@ page import="java.util.*" %>
    <%VariableIntialization ds_countryinthis =(VariableIntialization)session.getAttribute("deshopa_country"); %>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
	<meta charset="utf-8">

	<!-- Set the viewport width to device width for mobile -->
	<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
    
	<!-- Set meta informations -->
	<title>DeShoppa.com</title>
	<meta name="description" content="The DeShoppa is a responsive ecommerce template for your next projects">
	<meta name="author" content="">
<link rel="stylesheet" href="css/layerslider.css" type="text/css">
	<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
	<link rel="stylesheet" href="../css/media.css" type="text/css">
	<link rel="stylesheet" href="../css/flexislider.css" type="text/css">
	<link rel="stylesheet" href="../css/style.css" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
  var xyz;
  $("#country_id").change(function() {
	  xyz = $("option:selected").val();

	var url ="../Retrive_country?stateadd_1=stateedit&countryREF="+xyz;
	$(location).attr('href',url);

});
});
</script>
</head>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
    
    <div class="container make-bg" style="min-height:500px;">
<%if(session.getAttribute("deshopa_country") != null){ %>
<div class="span2 clear">
<select name="country_id" id="country_id">
<option>-select-</option>
<% for(int j=0; j<ds_countryinthis.getcountry().size(); j++ ){%>

<option value="<%= ds_countryinthis.getcountry_id().get(j)%>" id="blabbb"><%= ds_countryinthis.getcountry().get(j) %></option>

<%} %>
</select></div>

<% for(int j=0; j<ds_countryinthis.getState().size(); j++ ){%>
<form  action="../UpdateInfoState" name="location" id="location">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="form-table">
  <tr>
    <td width="51%" class="PL10 PR10" style="text-align:left;">
    <div class="MT10"><input type="text" value="<%=ds_countryinthis.getState().get(j) %>" name="state_edit" id="state_edit"/></div>*edit here itself n update</td>
    <td width="16%"><input type="hidden" name="stateid_edit" value="<%=ds_countryinthis.getState_id().get(j) %>"/><div> <%= ds_countryinthis.getcountry_id().get(j)%></div></td>
    <td width="19%"><input value="update" type="submit" id="update_button" class="MT10" name="update_button" /> </td>
    <td width="14%"><input value="delete" type="submit" id="update_button" class="MT10" name="update_button" onclick="form.action='../DeleteInfo';"/></td>
  </tr>
</table>
</form>
<%} %>
<%} %>

	</div> 

</body></html>

