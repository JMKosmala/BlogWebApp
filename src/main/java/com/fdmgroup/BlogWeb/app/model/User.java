package com.fdmgroup.BlogWeb.app.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer ID;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String connfirmPassword;
	private Integer articlesAdded;
	@OneToMany (mappedBy="owner")
	private List <Post> myArticles;
	
	@ManyToOne
	@Transient
	private Role role;
	
	
//constructors
	
	public User() {
		super();
	}
	
	public User(String name, String surname, String username, String password, String connfirmPassword, Role role) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.connfirmPassword = connfirmPassword;
		this.role = role;
	}
	public User(String username) {
		super();
		this.username = username;
	}
	
//getters and setters
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConnfirmPassword() {
		return connfirmPassword;
	}
	public void setConnfirmPassword(String connfirmPassword) {
		this.connfirmPassword = connfirmPassword;
	}
	public Integer getArticlesAdded() {
		return articlesAdded;
	}
	public void setArticlesAdded(Integer articlesAdded) {
		this.articlesAdded = articlesAdded;
	}
	public List<Post> getMyArticles() {
		return myArticles;
	}
	public void setMyArticles(List<Post> myArticles) {
		this.myArticles = myArticles;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(articlesAdded, connfirmPassword, myArticles, name, password, role, surname, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(articlesAdded, other.articlesAdded)
				&& Objects.equals(connfirmPassword, other.connfirmPassword)
				&& Objects.equals(myArticles, other.myArticles) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}


	

	
}
