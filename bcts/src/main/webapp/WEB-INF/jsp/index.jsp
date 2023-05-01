<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">

<style>
body {
	color: #000;
	overflow-x: hidden;
	height: 100%;
	background: linear-gradient(180deg, #2196F3 250px, #FFF 250px);
	background-repeat: no-repeat
}

.card.show {
	display: block !important
}

.card {
	display: none;
	background-color: #E0F7FA;
	border: 1px solid #E0F7FA;
	box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
}

.step-container {
	border-top: 1px solid lightgrey;
	border-bottom: 1px solid lightgrey;
	width: 99.85%;
	margin-top: 70px;
	margin-bottom: 50px
}

.heading {
	margin-bottom: 40px
}
</style>
</head>
<body>
	<div class="container-fluid px-1 py-5 mx-auto">
		<div class="row d-flex justify-content-center text-center">
			<div class="col-lg-9 col-md-10">
				<div class="card b-0 rounded-0 show">
					<div class="row justify-content-center mx-auto step-container">
						<div class="col-md-12 col-12 step-box active">
							<h6>
								Bahwan CyberTek 
							</h6>
						</div>
					</div>
					<div class="p-3 justify-content-center text-center">
						<h4 class="heading">Service Details</h4>
						<div class="row justify-content-center">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Service Name</th>
										<th scope="col">Count in Last Four Hour</th>
										<th scope="col">Count in Last Eight Hour</th>
									</tr>
								</thead>
								<tbody id="list">

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

	<script>
$(document).ready(function(){
$("#list").empty();
var setdata=$("#list");
var data="";
	$.ajax({
	  type:"POST",
	  url:"home",
	  success: function(response) {
		  var obj = jQuery.parseJSON(response);
		  if(obj.length >0){
			  for(var i=0; i< obj.length; i++){
				  if(obj[i]['count_four'] <1 || obj[i]['count_eight'] <1){
					  data+='<tr style=" background-color: #D1D119;">';
					  data+='<td>'+obj[i]['Service_Name']+'</td>';
					  data+='<td>'+obj[i]['count_four']+'</td>';
					  data+='<td>'+obj[i]['count_eight']+'</td>';
					  data+='</tr>';
				  }else{
					  data+='<tr>';
					  data+='<td>'+obj[i]['Service_Name']+'</td>';
					  data+='<td>'+obj[i]['count_four']+'</td>';
					  data+='<td>'+obj[i]['count_eight']+'</td>';
					  data+='</tr>';
				  }
				 
			  }
			  setdata.append(data);
		  }else{
			  $('#list').append('<tr><td> no data found</td></tr>');
		  }
	  }
	});
});
</script>
</body>
</html>