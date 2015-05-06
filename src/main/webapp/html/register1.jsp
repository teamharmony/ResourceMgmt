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

<body>
	<!----------------Register part1 screen----------------->
	<div class="container registrationscreen" id="registrationscreenpart1">
		<div class="row">
			<div class="col-sm-12 text-center title">Registration</div>
			<div class="col-sm-12 text-center registration titlemd">Personal Information</div>
			
			<div class="col-sm-12 text-center registraionform">
				
				<div class="textbox">
					<input id="fName" type="text" placeholder="FIRST NAME *" required>
					<input id="mName" type="text" placeholder="MIDDLE NAME *" required>
					<input id="lName" type="text" placeholder="LAST NAME *"  required>
					<input id="address" type="text" placeholder="ADDRESS *"  required>
					<input id="contact" type="tel" placeholder="CONTACT NUMBER *"  required>
					<div class="row">
						<div class="col-xs-9">
							<input type="file" capture="camera">
						</div>
						<div class="col-xs-3 reg_picture"><img src="../img/uploadedpic.png" width="35" height="30" alt=""/></div>
					</div>
				</div>
				<button type="submit" onclick="fnRegCont()">CONTINUE</button>            
			</div>
		</div>
	</div>
   
   <!--------------------------------------------->
   
    <script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/meetmepal.js"></script>
  

</body>
</html>