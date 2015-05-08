<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body onload="drawCaptcha()">
	<!----------------Register part1 screen----------------->
	<div class="container registrationscreen">
		<form method="POST" action="<c:url value='/resources'/>" enctype="multipart/form-data" onsubmit="return checkForm(this);">
			<div class="row" id="registrationscreenpart1">
				<div class="col-sm-12 text-center title">Registration</div>
				<div class="col-sm-12 text-center registration titlemd">Personal Information</div>
				
				<div class="col-sm-12 text-center registraionform">
						<div class="textbox">
							<input id="fName" name="fName" type="text" placeholder="FIRST NAME *" required>
							<input id="mName" name="mName" type="text" placeholder="MIDDLE NAME *" required>
							<input id="lName" name="lName" type="text" placeholder="LAST NAME *"  required>
							<input id="city" name="city" type="text" placeholder="CITY *"  required>
							<input id="state" name="state" type="text" placeholder="STATE *"  required>
							<input id="country" name="country" type="text" placeholder="COUNTRY *"  required>
							<input id="zipcode" name="zipCode" type="text" placeholder="ZIPCODE *"  required>
							<input id="contact" name="contact" type="tel" placeholder="CONTACT NUMBER *"  required>
							<div class="row">
								<div class="col-xs-9">
									<input id="imgInp" type="file" name="profilePic" accept="image/*" capture="camera">
								</div>
								<div class="col-xs-3 reg_picture"><img id="imgDisp" src="<c:url value='/img/defaultImg.png'/>" alt=""/></div>
							</div>
						</div>
						<button type="submit" onclick="fnRegCont()">CONTINUE</button>       
				</div>
			</div>
			
			<div class="row" id="registrationscreenpart2" style="display:none;">
				<div class="col-sm-12 text-center title">Registration</div>
				<div class="col-sm-12 text-center registration-part2 titlemd">Account Detail</div>
				
				<div class="col-sm-12 text-center registraionform">
						<div class="textbox">
							<input id="username" name="username" type="text" placeholder="USER NAME *" required>
							<input id="email" name="email" type="text" placeholder="EMAIL *" required>
							<input id="password" name="password" type="text" placeholder="PASSWORD *"  required>
							<input id="confirmPass" name="confirmPass" type="text" placeholder="CONFIRM PASSWORD *"  required>
							<div class="row">
								<div class="col-xs-8"> <input id="captcha" type="text" placeholder="CAPTCHA *" class="noborder" onfocusout="validateCaptcha()" required></div>
								<div class="col-xs-4">
									<input type="text" id="txtCaptcha" readonly tabindex="-1" style="background-image:<c:url value='/img/captcha.png'/>; text-align:center; border:none; font-size:32px;
											font-weight:bold; font-family:Modern;"/> 
								</div>
							</div>
						</div>
						<button type="submit">REGISTER</button>
				</div>
			</div>
			<div class="col-sm-12 text-center error" id="errorMsg" style="display:none"></div>
		</form>
	</div>
   
	<!--------------------------------------------->
   
    <script src="<c:url value='/js/jquery.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/meetmepal.js'/>"></script>
  

</body>
</html>