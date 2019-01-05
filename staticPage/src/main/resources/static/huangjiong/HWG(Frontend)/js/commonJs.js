//公共js文件
document.write('<script src="assets/js/jquery-1.12.3.min.js"></script>');
document.write('<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>');
document.write('<script type="text/javascript" src="assets/js/main.js"></script>');

let base=location.protocol+"//"+location.host+location.pathname;

//HWG公用js方法
const Hwg = {
	//设置token
	setToken (thisToken){
		window.sessionStorage.setItem("token",thisToken);
	},
	//获取token
	getToken (){ 
		return window.sessionStorage.getItem("token");
	},
	setOutToken (outToken){
		window.sessionStorage.setItem("outToken",outToken);
	},
	getOutToken (){ 
		return window.sessionStorage.getItem("outToken");
	},
	setUserId(uId){
		window.sessionStorage.setItem("uId",uId);
	},
	getUserId(){
		return window.sessionStorage.getItem("uId");
	},
	//获取地址栏参数
	getUrlKey(name) {
		return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[
			1].replace(/\+/g, '%20')) || null
	}
	
}

//页面加载调用

	if(Hwg.getToken()==null||Hwg.getToken()=='null'||Hwg.getToken==''){
		Hwg.setToken(Hwg.getUrlKey("access_token"))//存入token
		
		Hwg.setOutToken(Hwg.getUrlKey("refresh_token"))//存入刷新token
		
		Hwg.setUserId(Hwg.getUrlKey("uid"))//存入用户id
	}
	//用户推出 清除所有信息
	function outUser(url){
		
		$.post("http://localhost:8006/login/userEndLogin",{refresh_token:Hwg.getOutToken()},function(res){
			
		})
		window.sessionStorage.removeItem("token");
		window.sessionStorage.removeItem("uId")
		window.sessionStorage.removeItem("outToken")
		window.location.href=url
	}
