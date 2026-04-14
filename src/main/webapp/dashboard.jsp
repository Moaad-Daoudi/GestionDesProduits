<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard Produits</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; }
        .actions { margin: 20px auto; padding: 20px; border: 1px solid #ccc; width: 60%; }
        table { margin: 20px auto; border-collapse: collapse; width: 80%; }
        th, td { border: 1px solid #ccc; padding: 10px; }
        .form-group { margin: 10px; }
        .error { color: red; }
    </style>
</head>
<body>

    <h2>Gestion des Produits (MVC1)</h2>
    
    <!-- User Info -->
    <p>Welcome, <strong>${sessionScope.user.prenom} ${sessionScope.user.nom}</strong></p>
    <p>Role: <strong>${sessionScope.user.role}</strong></p>
    <a href="logout">Logout</a>
    <hr/>

    <!-- FORMULAIRE AJOUT / MODIFICATION (ADMIN ONLY) -->
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <div class="actions">
            <h3>${not empty productEdit ? 'Modifier le produit' : 'Ajouter un produit'}</h3>
            
            <form action="${not empty productEdit ? 'updateProduit' : 'addProduit'}" method="post">
                <!-- Hidden ID for update -->
                <input type="hidden" name="id" value="${productEdit.id}" />
                
                <div class="form-group">
                    Nom: <input type="text" name="nom" value="${productEdit.nom}" required />
                </div>
                <div class="form-group">
                    Description: <input type="text" name="description" value="${productEdit.description}" required />
                </div>
                <div class="form-group">
                    Prix: <input type="text" name="prix" value="${productEdit.prix}" required />
                </div>
                <button type="submit">${not empty productEdit ? 'Mettre à jour' : 'Ajouter'}</button>
                
                <c:if test="${not empty productEdit}">
                    <a href="listProduits">Annuler</a>
                </c:if>
            </form>
        </div>
        <hr/>
    </c:if>

    <!-- FORMULAIRE RECHERCHE (VISIBLE TO ALL) -->
    <div>
        <h3>Rechercher un produit</h3>
        <form action="listProduits" method="get">
		    ID: <input type="text" name="idProduit" value="${param.idProduit}" />
		    <button type="submit">Rechercher</button>
		</form>
    </div>
    <br/>

    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                <th>Actions</th>
            </c:if>
        </tr>
        
        <c:forEach var="p" items="${listeProduits}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix}</td>
                
                <c:if test="${sessionScope.user.role == 'ADMIN'}">
                    <td>
                        <a href="editProduit?id=${p.id}">Modifier</a> | 
                        <a href="deleteProduit?id=${p.id}" onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">Supprimer</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>

</body>
</html>