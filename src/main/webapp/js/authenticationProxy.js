window["host"] = "http://localhost:8080/ResourceMgmt";
window["refresh_token"] = null;//get it from Local storage if exists
window["clientId"] = "meetMePal";
window["bearerToken"] = null;



function loginWithPwd(username, password) {
    return $.ajax( {
	      	url: host.concat("/oauth/token?grant_type=password&clientId=" + clientId + "&username=" + username + "&password=" + password),
	      	async: false,
	      	type: 'GET'
	 	}).done(loginSuccess)
}


function loginSuccess(o) {
	bearerToken = o.value;
	refresh_token = o.refreshToken.value;
	
	setTimeout(function(){
		
	}, o.expiresIn)
}



function loginWithRefreshToken(refreshToken, reTry, context, args, retRef) {
    return $.ajax( {
	      	url: host.concat("/oauth/token?grant_type=refresh_token&clientId=" + clientId + "&refresh_token=" + refreshToken),
	      	async: false,
	      	type: 'GET'
	 }).done(function(o) {
		 loginSuccess(o);
		 retRef = reTry.apply(context, args);
	 });
}



