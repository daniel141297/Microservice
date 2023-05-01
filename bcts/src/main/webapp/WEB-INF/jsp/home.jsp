<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">

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
		<nav class="pcoded-navbar menu-light " style="background-color: white;margin-left: -90px;">
		<div class="navbar-wrapper  ">
			<div class="navbar-content scroll-div " >
			
				<ul class="nav pcoded-inner-navbar " style="margin-top:50px">
				
					<li class="nav-item" >
					    <a href="dashboard" style="background:#4680ff;color:white" class="nav-link "><span class="pcoded-micon"><i class="feather icon-home"></i></span><span class="pcoded-mtext">Poller Count</span></a>
					</li>
				</ul>
			
				
			</div>
		</div>
	</nav>
			<div class="col-lg-9 col-md-10">
				<div class="card b-0 rounded-0 show">
					<div class="row justify-content-center mx-auto step-container">
						<div class="col-md-12 col-12 step-box active">
						<div class="row align-items-center">
                    <div class="col-md-12">
                       
                        <ul class="breadcrumb" >
                                <li class="breadcrumb-item"><button  class="need btn btn-outline-primary"  id="4">Last Four</button></li>
                            <li class="breadcrumb-item"><button  class="need btn btn-outline-primary" id="8">Last eight</button></li>
                 
                  <li class="breadcrumb-item"><button  class="need btn btn-outline-primary" id="12">Last Twelve Hours</button></li>
                 
                  <li class="breadcrumb-item"><button  class="need btn btn-outline-primary" id="24">Last twenty four </button></li>
                 
                  <li class="breadcrumb-item"><button  class="need btn btn-outline-primary" id="168">Last seven Day</button></li>
                 
                        </ul>
                    </div>
                </div>
							<h6>
								Bahwan CyberTek 
							</h6>
						</div>
					</div>
					<div class="p-3 justify-content-center text-center">
						
						<div class="row justify-content-center">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Service Name</th>
										<th scope="col">Count</th>
										
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
	$(".need").click(function(){
		var id=$(this).attr('id');
		$("#list").empty();
		var setdata=$("#list");
		var data="";
			$.ajax({
			  type:"POST",
			  url:"home",
			  data:{time:id},
			  success: function(response) {
				  var obj = jQuery.parseJSON(response);
				  if(obj.serviceList.length >0){
					  for(var i=0; i< obj.serviceList.length; i++){
						  if(obj.serviceList[i]['count'] <1){
							  data+='<tr>';
							  data+='<td style=" background-color: #f57171;color:white">'+obj.serviceList[i]['Service_Name']+'</td>';
							  data+='<td>'+obj.serviceList[i]['count']+'</td>';
							 
							  data+='</tr>';
						  }else{
							  data+='<tr>';
							  data+='<td style=" background-color:#bb0909;color:white">'+obj.serviceList[i]['Service_Name']+'</td>';
							  data+='<td>'+obj.serviceList[i]['count']+'</td>';
							
							  data+='</tr>';
						  }
						 
					  }
					  setdata.append(data);
				  }else{
					  $('#list').append('<tr><td> No data found</td></tr>');
				  }
			  }
	});
	});
$(document).ready(function(){
$("#list").empty();
var setdata=$("#list");
var id=4;
var data="";
	$.ajax({
	  type:"POST",
	  url:"home",
	  data:{time:id},
	  success: function(response) {
		  var obj = jQuery.parseJSON(response);
		  if(obj.serviceList.length >0){
			  for(var i=0; i< obj.serviceList.length; i++){
				  if(obj.serviceList[i]['count'] <1){
					  data+='<tr>';
					  data+='<td style=" background-color: #f57171;color:white">'+obj.serviceList[i]['Service_Name']+'</td>';
					  data+='<td>'+obj.serviceList[i]['count']+'</td>';
					
					  data+='</tr>';
				  }else{
					  data+='<tr>';
					  data+='<td style=" background-color:#bb0909;color:white">'+obj.serviceList[i]['Service_Name']+'</td>';
					  data+='<td>'+obj.serviceList[i]['count']+'</td>';
					 
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