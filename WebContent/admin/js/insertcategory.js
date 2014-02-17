$(document).ready(function(){
$("#SubCategoryInsertion").submit(function(event){
	  event.preventDefault();
	   cat = $("#category option:selected").val();
	   subCat = $("#sub_cat option:selected").val();
	   subcatvalue = $("#SubCategoryvalue").val();
	   
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



