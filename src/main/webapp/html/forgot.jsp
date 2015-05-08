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

<body>
	<!----------------login screen----------------->
  	<div class="container forgotpasswordscreen" id="forgotscreenpart1">
  
		<div class="row">
	  	
	    	<div class="col-sm-12 text-center title">Meet Me Pal</div>
	        <div class="col-sm-12 text-center forgotpassword titlemd">Forgot Password</div>
	        
	        <div class="col-sm-12 text-center forgotpass1form">
	        	<form>
					<input id="forgot" type="text" placeholder="ENTER YOUR USERNAME">
					<button type="submit" onclick="fnForgotPass()">SEND RESET INFO</button>
	            </form>
	        
	        </div>
	  
		</div>
  
	</div>  
  
    <script src="<c:url value='/js/jquery.js' />"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/meetmepal.js'/>"></script>
  

</body></html>