<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "requirementlogic.*" %>
     <%@ page import="java.util.*" %>
    
    <%VariableIntialization ds_countryinthis =(VariableIntialization)session.getAttribute("deshopa_country"); %>
    
  <%--   <%String x =ds_country.getcompare().get(key); %> --%>
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
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
  var xyz;
  $("#country_id").change(function() {
	  xyz = $("option:selected").val();

	var url ="../Retrive_country?stateadd_1=none&countryREF="+xyz;
	$(location).attr('href',url);

});
});
</script>
    
</head>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
    
    <div class="container make-bg PT15" style="min-height:500px;">

<%if(session.getAttribute("deshopa_country") != null){ %>

<div class="span2 clear">
<select name="country_id" id="country_id">
<option>-select-</option>
<% for(int j=0; j<ds_countryinthis.getcountry().size(); j++ ){%>

<option value="<%= ds_countryinthis.getcountry_id().get(j)%>" id="blabbb"><%= ds_countryinthis.getcountry().get(j) %></option>

<%} %>
</select></div>
<form method="get" action="../City" name="state" id="state">
<div class="span2 clear">
<select name="state_ref" id="state_ref">

<% for(int k=0; k<ds_countryinthis.getState().size(); k++ ){%>
<option value="<%= ds_countryinthis.getcountry_ref().get(k) %>"><%= ds_countryinthis.getState().get(k) %></option>
<%} %>
</select></div>
<div class="span3 clear">
city<input type="text" value="" name="city" id="city"/><input type="submit" value="submit"/>
</div>

</form>
<% }%>


	</div> 

</body></html>


