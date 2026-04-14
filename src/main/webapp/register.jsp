<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
<style>
	body{
		text-align: center;
	}
	.form-group {
		margin: 20px;
	}
</style>
</head>
<body>
	<c:if test="${not empty error}">
	    <p style="color:red; text-align:center;">${error}</p>
	</c:if>
	<div class="title-container">
		<h2>Create an account</h2>
	</div>
	<div class="form-body">
        <form action="register" method="post">
        	<div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="${param.nom}">
            </div>
            
            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" id="prenom" name="prenom" value="${param.prenom}">
            </div>
            
            <div class="form-group">
			    <label for="role">Role</label>
			    <select id="role" name="role">
			        <option value="USER">Utilisateur</option>
			        <option value="ADMIN">Administrateur</option>
			    </select>
			</div>
            
            <div class="form-group">
                <label for="email">email</label>
                <input type="email" id="email" name="email" value="${param.email}">
            </div>
            
            <div class="form-group">
                <label for="password">mot de passe</label>
                <input type="password" id="password" name="password" value="${param.password}">
            </div>
            <button type="submit" class="btn-submit">create account</button>
        </form>
    </div>
    <a href="login.jsp" class="btn-login">Login</a>
</body>
</html>