package com.fdmgroup.BlogWeb.app.dataImport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.BlogWeb.app.model.Post;
import com.fdmgroup.BlogWeb.app.model.Role;
import com.fdmgroup.BlogWeb.app.model.User;
import com.fdmgroup.BlogWeb.app.repositories.PostRepository;
import com.fdmgroup.BlogWeb.app.repositories.UserRepository;

@Component
public class DummyData implements ApplicationRunner {

	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
			
			Role roleAdmin = new Role ("Admin");
			Role roleUser = new Role ("User");
			
			User admin = new User("Ad","Min","admin", encoder.encode("111"), encoder.encode("111"), roleAdmin);
			User user = new User("Dummy","User","dummy", encoder.encode("222"), encoder.encode("222"), roleUser);
		
			userRepo.save(admin);
			userRepo.save(user);
			
			Post post1 = new Post("My first post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post2 = new Post("My second post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post3 = new Post("My third post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post4 = new Post("My fourth post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post5 = new Post("My fifth post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post6 = new Post("My next post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post7 = new Post("My other post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post8 = new Post("My another post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			Post post9 = new Post("My post", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex", "img", user);
			
			postRepo.save(post1);
			postRepo.save(post2);
			postRepo.save(post3);
			postRepo.save(post4);
			postRepo.save(post5);
			postRepo.save(post6);
			postRepo.save(post7);
			postRepo.save(post8);
			postRepo.save(post9);
		
		
	}

}
