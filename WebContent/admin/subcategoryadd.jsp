<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="category.Menu_Listing,java.util.List"%>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>	<meta charset="utf-8">

	<!-- Set the viewport width to device width for mobile -->
	<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<!-- Set meta informations -->
	<title>DeShoppa.com</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/AutoSelectOption.js" type="text/javascript"></script>
<script src="js/insertcategory.js" type="text/javascript"></script>
<jsp:useBean id="MVR" class="category.MenuVariables"/>
<script type="text/javascript">
$(document).ready(function() {
    $("#category").change(function () {
			var xyz = $("#category option:selected").val();
			$("#subcategorys").empty();
			$.get("../CategoryInsertion",
	{categorys : cat,
	subcategorys: subCat,
	SubCategoryvalue: subcatvalue,
	}
	,function(data,status){
		$("#insertioncompleted").empty().append(data);
		});
	
});

});
</script>
</head>
<body>

	<%@ include file="header.jsp" %> 
	<!-- Start Site Container -->
    <div class="container make-bg " style="min-height:500px;">
<form method="get" name="SubCategoryInsertion" id="SubCategoryInsertion">
<div class="span3 MT10 clear">
<select id="category" name="categorys">
<option>-select-</option>
<%
	Menu_Listing ML =new Menu_Listing();
 	List menu_List = ML.getMenu();
	for (int i = 0; i < menu_List.size(); i++) {
 	    	MVR = (category.MenuVariables) menu_List.get(i);%>


<option value="<%=MVR.getmenuid().get(i)%>"><%=MVR.getmenu().get(i)%></option>

<%} %>
</select></div>
<div class="span3 MT10 clear" >
<select id="sub_cat" name="subcategorys">
</select></div>
<div class="span3 MT10 clear" ><input type="text" value="" name="SubCategoryvalue" id="SubCategoryvalue"/>
<input type="submit" id="submit" class="MT10"/>
</div>
<div id="insertioncompleted" class="span5 clear"></div>
</form>
	</div> 

</body></html>

