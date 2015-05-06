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
	<!----------------Register part2 screen----------------->
    <div class="container registrationscreen" id="registrationscreenpart2">
  
	<div class="row">
  	
    	<div class="col-sm-12 text-center title">Registration</div>
        <div class="col-sm-12 text-center registration-part2 titlemd">Account Detail</div>
        
        <div class="col-sm-12 text-center registraionform">
			<div class="textbox">
				<input id="username" type="text" placeholder="USER NAME *" required>
				<input id="email" type="text" placeholder="EMAIL *" required>
				<input id="password" type="text" placeholder="PASSWORD *"  required onfocusout="fnCheckPass()">
				<input id="confirmPass" type="text" placeholder="CONFIRM PASSWORD *"  required onfocusout="fnCheckPass()">
				<div class="row">
					<div class="col-xs-6"> <input id="captcha" type="text" placeholder="CAPTCHA *" class="noborder"  required></div>
					<div class="col-xs-6">
						<div class="captcha"></div>
					</div>
				</div>
			</div>
			<button type="submit" onclick="fnRegConfirm()">REGISTER</button>
        </div>
  
	</div>
  
	</div>
   
   <!--------------------------------------------->
  


    <script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/meetmepal.js"></script>
  

</body></html>