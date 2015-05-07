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
		city = document.getElementById("city").value,
		contact = document.getElementById("contact").value;
		
	if(fName !== "" && mName !== "" && lName !== "" && city !== "" && contact !== ""){
		document.getElementById('registrationscreenpart1').style.display = 'none';
		document.getElementById('registrationscreenpart2').style.display = 'block';
	}
	
};

function fnRegConfirm(){
	var username = document.getElementById("username").value,
		email = document.getElementById("email").value
		password = document.getElementById("password").value,
		confirmPass = document.getElementById("confirmPass").value,
		captcha = document.getElementById("captcha").value;
	
	if(validateCaptcha()){
		if(username !== "" && email !== "" && password !== "" && confirmPass !== "" && captcha !== ""){
			//alert("Registration Successful.");
		}
	} else {
		alert("Invalid Captcha");
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

$("#imgInp").change(function(){
    readURL(this);
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imgDisp').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}
//Created / Generates the captcha function    
function drawCaptcha()
{
	var a = Math.ceil(Math.random() * 10)+ '';
	var b = Math.ceil(Math.random() * 10)+ '';       
	var c = Math.ceil(Math.random() * 10)+ '';  
	var d = Math.ceil(Math.random() * 10)+ '';  
	var e = Math.ceil(Math.random() * 10)+ '';  
	var f = Math.ceil(Math.random() * 10)+ '';  
	var g = Math.ceil(Math.random() * 10)+ '';  
	var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
	document.getElementById("txtCaptcha").value = code
}

// Validate the Entered input aganist the generated security code function   
function validateCaptcha(){
	var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
	var str2 = removeSpaces(document.getElementById('txtInput').value);
	if (str1 == str2) return true;        
	return false;
	
}

// Remove the spaces from the entered and generated code
function removeSpaces(string)
{
	return string.split(' ').join('');
}