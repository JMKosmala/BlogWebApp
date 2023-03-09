package com.fdmgroup.BlogWeb.app.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	private String title;
	@Column (length=2000)
	private String content;
	private String img;
	@ManyToOne
	private User owner;
	
	public Post() {
		super();
	}
	
	public Post(String title, String content, String img, User owner) {
		super();
		this.title = title;
		this.content = content;
		this.img = img;
		this.owner = owner;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, content, img, owner, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(content, other.content) && Objects.equals(img, other.img)
				&& Objects.equals(owner, other.owner) && Objects.equals(title, other.title);
	}

	
	
}
