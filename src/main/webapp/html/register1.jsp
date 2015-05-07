<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>meet me pal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

   
    <link href="../css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
</head>

<body onload="drawCaptcha()">
	<!----------------Register part1 screen----------------->
	<div class="container registrationscreen">
		<form method="POST" action="<c:url value='/j_spring_security_check'/>" >
			<div class="row" id="registrationscreenpart1">
				<div class="col-sm-12 text-center title">Registration</div>
				<div class="col-sm-12 text-center registration titlemd">Personal Information</div>
				
				<div class="col-sm-12 text-center registraionform">
						<div class="textbox">
							<input id="fName" type="text" placeholder="FIRST NAME *" required>
							<input id="mName" type="text" placeholder="MIDDLE NAME *" required>
							<input id="lName" type="text" placeholder="LAST NAME *"  required>
							<input id="city" type="text" placeholder="CITY *"  required>
							<input id="state" type="text" placeholder="STATE *"  required>
							<input id="country" type="text" placeholder="COUNTRY *"  required>
							<input id="zipcode" type="text" placeholder="ZIPCODE *"  required>
							<input id="contact" type="tel" placeholder="CONTACT NUMBER *"  required>
							<div class="row">
								<div class="col-xs-9">
									<input id="imgInp" type="file" accept="image/*" capture="camera">
								</div>
								<div class="col-xs-3 reg_picture"><img id="imgDisp" src="../img/defaultImg.jpg" alt=""/></div>
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
							<input id="username" type="text" placeholder="USER NAME *" required>
							<input id="email" type="text" placeholder="EMAIL *" required>
							<input id="password" type="text" placeholder="PASSWORD *"  required onfocusout="fnCheckPass()">
							<input id="confirmPass" type="text" placeholder="CONFIRM PASSWORD *"  required onfocusout="fnCheckPass()">
							<div class="row">
								<div class="col-xs-8"> <input id="captcha" type="text" placeholder="CAPTCHA *" class="noborder"  required></div>
								<div class="col-xs-4">
									<input type="text" id="txtCaptcha" readonly style="background-image:url(../img/captcha.png); text-align:center; border:none; font-size:32px;
											font-weight:bold; font-family:Modern;"/> 
								</div>
							</div>
						</div>
						<button type="submit" onclick="fnRegConfirm()">REGISTER</button>
				</div>
			</div>
		</form>
	</div>
   
	<!--------------------------------------------->
   
    <script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/meetmepal.js"></script>
  

</body>
</html>