$(document).ready(function(){
	document.onselectstart=function(){return false;} ;
	console.log('userType :' + userType);
	console.log('userName :' + userName);
	$("#channelConfig").hide();
	if(userType == 0){
		$("#channelConfig").show();
	}
	if(userType == 2 || userType == 3){
		$("#instrumentConfig").show();
		$("#currentChart").show();
		$("#historyChart").hide();
		$("#userManager").hide();
		$("#downloadFile").hide();
		$("#evaluate").hide();
	}
	if(userType == 3){
		$("#instrument").show();
		$("#history").hide();
		$("#download").hide();
		$("#DAMP_history").hide();
		$("#DAMP_download").hide();
		$("#evaluate").hide();
		$("#userMenu").hide();
	}
	if(userType == 4){
		$("#menu li").hide();
		$("#dump").show();
	}
	if(userType == 5){
		$("#menu li").hide();
		$("#current").show();
		$("#current tr").hide();
		$("#3Dpage").show();
	}
	if(userType == 6){
		$("#menu li").hide();
		$("#current").show();
		$("#current tr").hide();
		$("#3Dpage").show();
		
		$("#history").show();
		$("#history tr").hide();
		$("#history_acce").show();
		
		$("#download").show();
		$("#download tr").hide();
		$("#download_acce").show();
	}
	if(userType == 7){
		$("#menu li").hide();
		$("#download").show();
		$("#download tr").hide();
		$("#download_acce").show();
		$("#download_press").show();
		$("#download_VIBRA").show();
		$("#download_wind").show();
	}
	if(userType == 8){
		$("#menu li").hide();
		$("#instrument").show();
		$("#instrumentConfig").hide();
	}
});

function jump(name){
	if(userName == null) {
		location.href = "/";
	}else if(name != null) {
		location.href = "/jump?name=" + name;
	}
}

