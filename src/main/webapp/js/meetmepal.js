/*
function fnLogin (){
	if( document.getElementById("userId").value === "admin" && document.getElementById("password").value === "admin"){
		alert("Login Successful");
	} else {
		alert("Invalid User name and Password");
	}
};
*/

function fnRegCont(){
	var fName = document.getElementById("fName").value,
		mName = document.getElementById("mName").value,
		lName = document.getElementById("lName").value,
		addr = document.getElementById("address").value,
		contact = document.getElementById("contact").value;
		
	if(fName !== "" && mName !== "" && lName !== "" && addr !== "" && contact !== ""){
		window.location.href = "register2.html";
	}
	
};

function fnRegConfirm(){
	var username = document.getElementById("username").value,
		email = document.getElementById("email").value
		password = document.getElementById("password").value,
		confirmPass = document.getElementById("confirmPass").value,
		captcha = document.getElementById("captcha").value;
	
	if(username !== "" && email !== "" && password !== "" && confirmPass !== "" && captcha !== ""){
		//alert("Registration Successful.");
	}
	
};

function fnCheckPass(){
	var pass = document.getElementById("password").value,
		confPass = document.getElementById("confirmPass").value;
		
	if(pass != confPass){
		alert("Password and Confirm Password needs to be same.");
	}
};

function fnForgotPass(){
	var forgot = document.getElementById("forgot").value;
	
	alert("Reset Info was send to:" + forgot);
};