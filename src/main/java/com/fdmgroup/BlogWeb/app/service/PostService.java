package com.fdmgroup.BlogWeb.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.BlogWeb.app.model.Post;
import com.fdmgroup.BlogWeb.app.model.User;
import com.fdmgroup.BlogWeb.app.repositories.PostRepository;

@Service
public class PostService implements IPostService {

	private PostRepository postRepo;
	
	@Autowired
	private PostService (PostRepository postRepo) {
		this.postRepo=postRepo;
	}
	
	@Override
	public void createNewPost(Post post) {
		postRepo.save(post);
		
	}

	@Override
	public void editPost(Integer postId) {
		Optional<Post> optPost=postRepo.findByID(postId);
		Post post=optPost.get();
			postRepo.save(post);

		
	}

	@Override
	public Post findPostById(Integer postId) {
		Optional<Post>optPost=postRepo.findByID(postId);
		return optPost.get();
	}

	@Override
	public Post findPostByOwner(String username) {
		Optional<Post>optPost=postRepo.findByOwner(username);
		return optPost.get();
	}

	@Override
	public Post findPostByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Post> getAllPosts() {
		
		return new ArrayList <Post>(postRepo.findAll());
	}

}
