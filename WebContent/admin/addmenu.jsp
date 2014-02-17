<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
$("#menuadd").click(function(event){
	  event.preventDefault();
	  var menu1 = $("#menuname").val();
    $.get("../Menu",
	{menu : menu1,
	}
	,function(data){
		$("#insertioncompleted").empty().append(data);
		});
  });
});
</script>
</head>
<body>

	<%@ include file="header.jsp" %> 
	 <div class="container make-bg" style="min-height:500px;">
<form name="menu" id="menu">
<div class="span3 MT10"><input type="text" value="" name="menu" id="menuname"/>
<input type="submit" class="MT10" id="menuadd"/>
</div>
<div id="insertioncompleted" class="span5 clear"></div>
</form>
	</div> 

</body></html>

