$(function(){
	$.post("pages/front/CityAction!list.action",{},function(data){
		for (var i = 0; i < data.allCities.length; i++) {
			$("#cityTab").append("<tr><td>" + data.allCities[i].cid + "</td><td>" 
					+ data.allCities[i].title + "</td></tr>")
		}
	},"json");
}) 