<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-ERP</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
body{
margin:0;
padding:0;
font-family: Verdana, Geneva, sans-serif;
background-color:#f7f7f7;
}
tr,td{
	border:0;
	padding: 4px;
}
table{
position:absolute;
top:50%;
left:50%;
transform:translate(-50%,-85%);
padding: 10px;
background-color:#fff;
box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14),
                    0 1px 5px 0 rgba(0, 0, 0, 0.12),
                    0 3px 1px -2px rgba(0, 0, 0, 0.2);
      border-radius: 2px;
}
.input_text{
    width: 218px;
	background:url(css/inputBack.png) repeat-x;
    border:#D7D7D7 solid 1px;
    -moz-border-radius: 3px;
    -moz-box-sizing:border-box;
    -webkit-border-radius: 3px;
    -webkit-box-sizing:border-box;
    padding:3px 5px 5px 5px;
    vertical-align:middle;
    font-size:12px;
}
.buttonLogin{
    padding: 5px 0px;
    border: 1px solid;
    background-color: #fff;
    color: #c51162;
    font-size: 13px;
    border-radius: 8px;
    min-width: 66px;
    font-weight: bold;
    cursor: pointer;
}
.loginTitle{
    margin: 8px 0px;
    float: left;
    margin-left: 9px;
    font-weight: 300;
    color: rgba(0, 0, 0, 0.68);
}
</style>
</head>
<body>
<form action="LoginValidate" method="post">
	<table border="0">
		<tr align="center"><td colspan="2" id="showMsg" style='color: red; font-size: small;'></td></tr>
		<tr align="left"><td colspan="2"><h3 class="loginTitle">Login</h3></td></tr>
		<tr><td></td><td><input type="text" name="username" placeholder="Username" class="input_text" required></td></tr>
		<tr><td></td><td><input type="password" name="pass" placeholder="Password" class="input_text" required></td></tr>
		<tr align="right"><td></td><td><input type="submit" value="Login" class="buttonLogin"></td></tr>
	</table>
<!-- </form>
	<h2>Login</h2>
	<form action="LoginValidate" method="post">
	<label for="username">Username:</label>
	<input type="text" id="username" name="username">
	<label for="pass">Password:</label>
	<input type="text" id="pass" name="pass">
	<input type="submit" name="Login">
	</form> -->
	<script src="js/jquery.min.js"></script>
	<script>
	if($("#errMsg")){
		var msg = $("#errMsg").text();
		$("#errMsg").remove();
		$("#showMsg").html(msg);
		
	}
	</script>
</body>
</html>