/**
 * report页面下拉框事件
 * auther:waylau.com
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $(this).val();
		var url = '/report/id/'+ cityId;
		window.location.href = url;
	})
});