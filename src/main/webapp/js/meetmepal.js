//Registeration Page
function fnRegCont(){
	var fName = document.getElementById("fName").value,
		mName = document.getElementById("mName").value,
		lName = document.getElementById("lName").value,
		city = document.getElementById("city").value,
		state = document.getElementById("state").value,
		country = document.getElementById("country").value,
		zipcode = document.getElementById("zipcode").value,
		contact = document.getElementById("contact").value;
		
	if(fName !== "" && mName !== "" && lName !== "" && city !== "" && state !== ""  && country !== "" && zipcode !== "" && contact !== ""){
		document.getElementById('registrationscreenpart1').style.display = 'none';
		document.getElementById('registrationscreenpart2').style.display = 'block';
	}
	
};

function checkForm(form)
{	
	if(!validateCaptcha()){
		document.getElementById('errorMsg').style.display = "block";
		document.getElementById('errorMsg').innerHTML = "Invalid Captcha !!";
		form.captcha.focus();
		return false;
	}
	
	if(form.password.value != "" && form.password.value == form.confirmPass.value) {
		if(form.password.value.length < 6) {
			document.getElementById('errorMsg').style.display = "block"
			document.getElementById('errorMsg').innerHTML = "Password must contain at least six characters!";
			form.password.focus();
			return false;
		}
	} else {
		document.getElementById('errorMsg').style.display = "block"
		document.getElementById('errorMsg').innerHTML = "Please check that password and confirmed password are same!";
		form.password.focus();
		return false;
	}

  return true;
}

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
	var str2 = removeSpaces(document.getElementById('captcha').value);
	if (str1 == str2)
		return true; 	
}

// Remove the spaces from the entered and generated code
function removeSpaces(string)
{
	return string.split(' ').join('');
}