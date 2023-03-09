package com.fdmgroup.BlogWeb.app.UnitTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fdmgroup.BlogWeb.app.model.Role;
import com.fdmgroup.BlogWeb.app.model.User;
import com.fdmgroup.BlogWeb.app.repositories.UserRepository;
import com.fdmgroup.BlogWeb.app.service.DefaultUserDetailService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DefaultUserDetailsServiceUnitTests {

	@InjectMocks
	DefaultUserDetailService userService;
	@MockBean
	UserRepository mockUserRepo;
	@Autowired
	PasswordEncoder encoder;
	
		@BeforeEach
		public void Setup() {
			Role roleUser=new Role();
			User testUser= new User("Test","User","uzi",encoder.encode("111"),encoder.encode("111"),roleUser);
			Optional<User> optUser =Optional.of(testUser);
			ArrayList<User>users=new ArrayList<User>();
			users.add(testUser);
		}
	
	@Test
	public void test_findByUsernameReturnsOkWhenUsernameIsCorrect(){
		User testUser = new User("uzi");
		Optional<User> expectedUser= Optional.of(testUser);
		when(mockUserRepo.findByUsername("uzi")).thenReturn(expectedUser);
		
		User actualUser= userService.findByUsername("uzi");
		assertEquals(actualUser,expectedUser.get());
		
	}
	@Test
	public void test_findByUsernameReturnsUserNotFoundWhenUsernameIsIncorrect(){
		
	}

}