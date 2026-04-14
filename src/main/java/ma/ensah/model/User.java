package ma.ensah.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private String nom;
	private String prenom;
	private String role;	// "ADMIN" or "USER"
	private String email;
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, String email, String password, String role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFullName() {
	    return this.prenom + " " + this.nom;
	}
}
