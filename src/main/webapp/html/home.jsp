<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</head>
<body>
<sec:authentication var="principal" property="principal" />
	<div class="container homescreen" id="homescreen">
		<div class="row">
			<div class="col-xs-4"><span style="color:white">Welcome <%=request.getUserPrincipal().getName() %>!!</span></div>
			<div class="col-xs-4 title">Meet Me Pal</div>
			<div class="col-xs-4" style="text-align:right">
				<a href="<c:url value='/resources/${principal.username}'/>"><i style="color:white">Edit Profile</i></a>
				<span>&nbsp;|&nbsp;</span>
				<a href="<c:url value='/j_spring_security_logout'/>"><i style="color:white">Logout</i></a>
			</div>
		</div>
	</div>
	
	<script src="<c:url value='/js/jquery.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/meetmepal.js'/>"></script>
</body>
</html>