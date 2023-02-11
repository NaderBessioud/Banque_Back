<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistique d'actions</title>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


	<script>
		$(document)
			.ready(
					function(){
					
						$.ajax({
							type:'GET',
							dataType:"json",
							contentType:"application/json",
							url:'${pageContext.request.contextPath}/api/product/findall',
							success:function(result){
								google.charts.load('current',
										{
											'packages':['corechart']
										});
								google.charts.setOnLoadCallback(function(){
									drawChart(result);
								});
							}
						});
						function drawChart(result){
							var data = new google.visualization.DataTable();
							data.addColumn('string','titre');
							data.addColumn('number','nombre');
							var dataArray = [];
							$.each(result, function(i,obj){
								dataArray.push([obj.titre, obj.nombre]);
							});
							data.addRows(dataArray);
							var piechart_options = {
									title:'Pie Chart: How Much Actions By Nombre',
									width:400,
									height:300
							};
							var piechart = new google.visualization.PieChart(document
									.getElementById('piechart_div'));
							piechart.draw(data,piechart_options);
							
							var barchart_options = {
									title:'Barchart: How Much Actions By Nombre',
									width:400,
									height:300,
									legend:'none'
							};
							var barchart = new google.visualization.BarChart(document
									.getElementById('barchart_div'));
							barchart.draw(data,barchart_options);
						}
					});
	</script>

</head>
<body>

	<table>
		<tr>
			<td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
			<td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
		</tr>
	</table>

</body>
</html>