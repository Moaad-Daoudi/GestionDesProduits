<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
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
	.form-group {
		margin: 20px;
	}
</style>
</head>
<body>
	<% 
	    String error = (String) request.getAttribute("error");
	    if(error != null) { 
	%>
	    <p style="color:red;"><%= error %></p>
	<% } %>
	<div class="title-container">
		<h2>Login to your app</h2>
	</div>
	<div class="form-body">
        <form action="login" method="post">
            <div class="form-group">
                <label for="email">email</label>
                <input type="email" id="email" name="email" value="${param.email}">
            </div>
            
            <div class="form-group">
                <label for="password">mot de passe</label>
                <input type="password" id="password" name="password" value="${param.password}">
            </div>
            <button type="submit" class="btn-submit">login</button>
        </form>
    </div>
    <a href="register.jsp" class="btn-register">Register if you have an account</a>
</body>
</html>