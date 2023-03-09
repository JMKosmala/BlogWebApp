package com.fdmgroup.BlogWeb.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.BlogWeb.app.model.Post;
import com.fdmgroup.BlogWeb.app.model.User;
import com.fdmgroup.BlogWeb.app.service.DefaultUserDetailService;
import com.fdmgroup.BlogWeb.app.service.PostService;
import com.fdmgroup.BlogWeb.app.service.RoleService;

@Controller
public class MainController {

	@Autowired 
	private DefaultUserDetailService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/")
	public String goToIndexPage(ModelMap model) {
		
		ArrayList<Post> posts = postService.getAllPosts();
		
		Post mainPost =postService.findPostById(posts.size());
		model.addAttribute("mainPost",mainPost);
		Post secondaryPost1 =postService.findPostById(posts.size()-1);
		model.addAttribute("secondaryPost1",secondaryPost1);
		Post secondaryPost2 =postService.findPostById(posts.size()-2);
		model.addAttribute("secondaryPost2",secondaryPost2);
		Post tertiaryPost1 =postService.findPostById(posts.size()-3);
		model.addAttribute("tertiaryPost1",tertiaryPost1);
		Post tertiaryPost2 =postService.findPostById(posts.size()-4);
		model.addAttribute("tertiaryPost2",tertiaryPost2);
		Post tertiaryPost3 =postService.findPostById(posts.size()-5);
		model.addAttribute("tertiaryPost3",tertiaryPost3);
		
		ArrayList<Post> otherPosts = new ArrayList<>();
		
		for(Post post: posts) {
			if(post.getID()<(posts.size()-6)) {
				otherPosts.add(post);
			}
			
		}
		model.addAttribute("otherPosts",otherPosts);
		
		return "index";
	}
	@GetMapping("/login")
	public String goToLoginPage() {
		return "login";
	}
	
	//register
	
	@GetMapping("/register")
	public String goToRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit (@ModelAttribute("user")User user, ModelMap model) {
		
		User userFromDB =userService.findByUsername(user.getUsername());
		if(userFromDB.getUsername().equals(user.getUsername())) {
			model.addAttribute("massage","This user are already exists");
			return "/register";
		}
		
		user.setRole(roleService.findByRoleName("Blogger"));
		user.setPassword(encoder.encode(user.getPassword()));
		userService.saveUser(user);
		
		return "index";
	}

}
