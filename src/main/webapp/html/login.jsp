<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!----------------login screen----------------->
  	<div class="container loginscreen" id="loginscreen">
  
	<div class="row">
        <div class="col-sm-12 text-center title">Meet Me Pal</div>
		<div class="col-sm-12 text-center titlemd logintitle">Login</div>
		
		<div class="col-sm-12">
			<div class="loginform">
				<form method="POST" action="<c:url value='/j_spring_security_check'/>">
					<div class="textbox">
						<input id="userId" type="text" name="j_username" placeholder="USER NAME">
						<input id="password" type="password" name="j_password" placeholder="PASSWORD" class="noborder">
					</div>
					
					<c:if test="${not empty param.error}">
						<div style="text-align:center;padding-top:8px">
						<font color="red">
							<i>Login error.</i><i>Reason:</i> ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} 
						</font>
						</div>
					</c:if>
	
					<div class="rememberforgotbox">
						<div class="rememberChk">
							<input id="rememberMe" type="checkbox" name="_spring_security_remember_me"></input>
							<label for="rememberMe"> Remember Me</label>
						</div>
						<a href="forgot.html"> FORGOT YOUR PASSWORD ?</a>
					</div>
					
					<div class="loginbutton">
						<button id="btnLogin" type="submit">LOG IN</button>
					</div>
				</form>
				<div class="sociallogin">
					<div class="row">
						<div class="col-xs-4  facebookbtn"><a href=""><i class="fa fa-facebook "></i></a></div>
						<div class="col-xs-4  tweeterbtn"><a href=""><i class="fa fa-twitter"></i></a></div>
						<div class="col-xs-4  likedinbtn"><a href=""><i class="fa fa-linkedin"></i></a></div>
					</div>
				</div>
			</div>
		</div>
    </div>
	</div>
  
  
  
    <script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/meetmepal.js"></script>
  

</body></html>