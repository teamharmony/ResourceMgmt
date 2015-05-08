<!DOCTYPE html>

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

<body>
	<!----------------Register part1 screen----------------->
	<div class="container editscreen">
		<form method="POST">
			<div class="row" id="editscreen">
				<div class="col-sm-12 text-center edit title">Edit Profile</div>
								
				<div class="col-sm-12 text-center registraionform">
						<div class="textbox">
							<input id="username" name="uname" type="text" placeholder="USERNAME *" required>
							<input id="email" name="email" type="text" placeholder="EMAIL *" required>
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
								<div class="col-xs-3 reg_picture"><img id="imgDisp" src="../img/defaultImg.png" alt=""/></div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6"> <button type="submit">CANCEL</button> </div>
							<div class="col-sm-6"> <button type="submit">SUBMIT</button> </div>
						</div>       
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