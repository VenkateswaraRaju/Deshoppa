<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- saved from url=(0038) -->
<html lang="en" class="" id="ls-global"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>	<meta charset="utf-8">

	<!-- Set the viewport width to device width for mobile -->
	<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<!-- Set meta informations -->
	<title>DeShoppa.com</title>
	<meta name="description" content="The DeShoppa is a responsive ecommerce template for your next projects">
	<meta name="author" content="">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/AutoSelectOption.js" type="text/javascript"></script>
<script>
$(window).load(function(event){
	event.preventDefault();
	$.getJSON("../CategoryUpdateDelete",
	function(data){	
	$.each(data, function(index, collections){
			for(var prop in collections.Sub_Category){
			 var subcat = collections.Sub_Category[prop];
			 var category = collections.category[prop];
			 var menu = collections.menu[prop];
			 var Subcategory_Id = collections.Subcategory_Id[prop];
			 $("<select></select><br>").attr("id","cat"+prop)
               .appendTo('#categoriesss');
			   $("<option></option>").attr("id",menu).attr("value", menu).text(menu).appendTo("#cat"+prop);
			   $("<option value='MEN' id='menu1'>MEN</option><option value='WOMEN' id='menu2' catg='WOMEN'>WOMEN</option><option value='KIDS' id='menu3' catg='KIDS'>KIDS</option><option value='HOME_FURNITURE' id='menu4' catg='HOMEFURNITURE'>HOME & FURNITURE</option><option value='BOOKS_MEDIA' id='menu7' catg='BOOKSMEDIA' >BOOKS & MEDIA</option><option value='ELECTRONICS' id='menu6' catg='ELECTRONICS'>ELECTRONICS</option>").appendTo("#cat"+prop);
			   
			    $("<select></select><br>").attr("id","subcat"+prop)
               .appendTo('#categoryy');
			   $("<option></option>").attr("id",category).attr("value", category).text(category).appendTo("#subcat"+prop);
			 $('<input>').prop('type', 'text')
                .attr("value", subcat).attr("id",Subcategory_Id)
                .appendTo('#SubCategoryvalue');
				
              }
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
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><div class="span3 MT10" id="categoriesss">
</div></td>
    <td><div class="span3 MT10" id="categoryy">
</div></td>
    <td><div class="span3 MT10" id="SubCategoryvalue">
<input type="submit" id="submit" class="MT10"/>
</div></td>
  </tr>
</table>





<div id="insertioncompleted" class="span5 clear"></div>
</form>
	</div> 

</body></html>

