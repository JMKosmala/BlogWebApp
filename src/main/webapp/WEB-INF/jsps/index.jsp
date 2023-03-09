<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
     <style><%@include file="/resources/style/BWstyle.css"%></style> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Blogeo</title>
</head>
<body>
	<div class="page_wrapper">
		
		<div class="header">
			<div class="header_banner">
				<div class="logo">logo</div>
				<div class="banner">banner</div>
			</div>
			<div class="header_buttons">
				<div class="login_button">
					<a href="/login">login</a>
				</div>
				<div class="register_button">
					<a href="/register">register</a>
				</div>
			</div>	
		</div>
		
		<div class="main_body">
			<div class="main_post">
				<form method="POST" action="/posts/${mainPost.ID}">
					<div class="post_img">${mainPost.img}</div>
					<div class="post_title">${mainPost.title}</div>
					<div class="post_content">${mainPost.content}</div>
					<div class="post_owner">${mainPost.owner.username}</div>
					<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
			<div class="sec_post1">
				<form method="POST" action="/posts/${secondaryPost1.ID}">
				<div class="post_img">${secondaryPost1.img}</div>
				<div class="post_title">${secondaryPost1.title}</div>
				<div class="post_content">${secondaryPost1.content}</div>
				<div class="post_owner">${secondaryPost1.owner.username}</div>
				<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
			<div class="sec_post2">
				<form method="POST" action="/posts/${secondaryPost2.ID}">
				<div class="post_img">${secondaryPost2.img}</div>
				<div class="post_title">${secondaryPost2.title}</div>
				<div class="post_content">${secondaryPost2.content}</div>
				<div class="post_owner">${secondaryPost2.owner.username}</div>
				<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
			
            <div class="tertiary_post">
            	<form method="POST" action="/posts/${tertiaryPost1.ID}">
				<div class="post_img">${tertiaryPost1.img}</div>
				<div class="post_title">${tertiaryPost1.title}</div>
				<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
            <div class="tertiary_post">
            	<form method="POST" action="/posts/${tertiaryPost2.ID}">
				<div class="post_img">${tertiaryPost2.img}</div>
				<div class="post_title">${tertiaryPost2.title}</div>
				<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
            <div class="tertiary_post">
            	<form method="POST" action="/posts/${tertiaryPost3.ID}">
				<div class="post_img">${tertiaryPost3.img}</div>
				<div class="post_title">${tertiaryPost3.title}</div>
				<button class="readMore_button" type="submit">Read more</button>
				</form>
			</div>
			<div class="other_posts">
				<c:forEach items="${otherPosts}" var="post">
					<div class="old_post"> ${post.title}</div>
				</c:forEach>
				
			</div>
		</div>
		
		<div class="footer">
			<div class="footer_buttons">
				<div class="footer_button">
					<a href="/faq">Help</a>
				</div>
				<div class="footer_button">
					<a href="/aboutUs">About Us</a>				
				</div>
				<div class="footer_button">
					<a href="/contact">Contact</a>
				</div>
			</div>	
		</div>
	</div>	
	
		
		
</body>
</html>