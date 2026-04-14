<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		text-align: center;
	}
	.btn {
		display: block;
		color: #ffffff;
		margin: 0 auto 30px auto;
		padding: 15px 20px;
		width: 150px;
		text-decoration: none;
	}
	.login {
        background-color: #337ab7; 
    }
    .register {
        background-color: #5cb85c;
    }
    .btn:hover {
        opacity: 0.85;
    }
</style>
</head>
<body>
	<div class="title-container">
		<h2>Welcome to TP3</h2>
	</div>
	<div class="body-container">
		<a href="login.jsp" class="btn login">Login</a>
		<a href="register.jsp" class="btn register">Register</a>
	</div>
</body>
</html>