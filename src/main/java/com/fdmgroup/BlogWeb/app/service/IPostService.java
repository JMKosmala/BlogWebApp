package com.fdmgroup.BlogWeb.app.service;

import java.util.ArrayList;

import com.fdmgroup.BlogWeb.app.model.Post;

public interface IPostService {

	public void createNewPost (Post post);
	public void editPost (Integer postId);
	public Post findPostById(Integer postId);
	public Post findPostByOwner (String username);
	public Post findPostByTitle (String title);
	public void deletePost(Post post);
	public ArrayList<Post>getAllPosts();
}
