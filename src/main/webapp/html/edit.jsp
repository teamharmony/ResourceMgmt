<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>meet me pal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/font-awesome.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
</head>
<sec:authentication var="principal" property="principal" />
<body>
	<!----------------Register part1 screen----------------->
	<div class="container editscreen">
		
			<div class="row" id="editscreen">
				<div class="col-sm-12 text-center edit title">Edit Profile</div>
								
				<div class="col-sm-12 text-center registraionform">
					<form id="editForm" method="POST" action="<c:url value='/resources/${principal.username}'/>" enctype="multipart/form-data" >
						<div class="textbox">
							<input type="hidden" name="_method" value="put" />
							<input id="email" name="email" type="text" placeholder="EMAIL *" required value="${user.email}"></input>
							<input id="fName" name="fName" type="text" placeholder="FIRST NAME *" required value="${user.fName}"></input>
							<input id="mName" name="mName" type="text" placeholder="MIDDLE NAME *" required value="${user.mName}"></input>
							<input id="lName" name="lName" type="text" placeholder="LAST NAME *"  required value="${user.lName}"></input>
							<input id="city" name="city" type="text" placeholder="CITY *"  required value="${user.location.city}"></input>
							<input id="state" name="state" type="text" placeholder="STATE *"  required value="${user.location.state}"></input>
							<input id="country" name="country" type="text" placeholder="COUNTRY *"  required value="${user.location.country}"></input>
							<input id="zipcode" name="zipCode" type="text" placeholder="ZIPCODE *"  required value="${user.location.zip}"></input>
							<input id="contact" name="contact" type="tel" placeholder="CONTACT NUMBER *"  required value="${user.contact}"></input>
							<div class="row">
								<div class="col-xs-9">
									<input id="imgInp" type="file" name="profilePic" accept="image/*" capture="camera">
								</div>
								<div class="col-xs-3 reg_picture">
									
								<img id="imgDisp" src="<c:url value='/resources/${principal.username}/profilePic'/>" alt="" onerror="showDefault()"/>
								
								</div>
							</div>
						</div>
						</form>
						<div class="row">
							<div class="col-sm-6"> <button  onclick="onCancel()">CANCEL</button> </div>
							<div class="col-sm-6"> <button type="submit" onclick="onSubmit()">SUBMIT</input> </div>
						</div>       
				</div>
			</div>
			
			<div class="col-sm-12 text-center error" id="errorMsg" style="display:none"></div>
		
	</div>
   
	<!--------------------------------------------->
   
    <script src="<c:url value='/js/jquery.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/meetmepal.js'/>"></script>
  
   	<script>
   	
   		function showDefault() {
   			$("#imgDisp").attr("src", "../img/defaultImg.png");   			
   		}
   		
   		function onCancel(){
   			//Need better implementation
   			window.history.go(-1);
   		}
   		
   		function onSubmit() {
   			$("#editForm")[0].submit();
   		}
   	</script>

</body>
</html>