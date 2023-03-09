package com.fdmgroup.BlogWeb.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.BlogWeb.app.model.Post;
import com.fdmgroup.BlogWeb.app.service.DefaultUserDetailService;
import com.fdmgroup.BlogWeb.app.service.PostService;
import com.fdmgroup.BlogWeb.app.service.RoleService;

@Controller
public class PostController {

	@Autowired 
	private DefaultUserDetailService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/posts/{ID}")
	public String goToSinglePost (ModelMap model, @PathVariable Integer ID ) {
		
		Post post=postService.findPostById(ID);
		model.addAttribute("post",post);
		
		return "singlePost";
	}
	
	
	
}
