package com.fdmgroup.BlogWeb.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.BlogWeb.app.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	Optional<Post> findByID (Integer Id);
	Optional<Post> findByTitle (String title);
	Optional<Post> findByOwner (String username);
}
