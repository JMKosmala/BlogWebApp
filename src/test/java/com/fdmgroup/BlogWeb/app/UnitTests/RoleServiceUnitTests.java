package com.fdmgroup.BlogWeb.app.UnitTests;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleServiceUnitTests {

	@Test
	public void test_findByUsernameReturnsOkWhenUsernameIsCorrect(){
		
	}
	@Test
	public void test_findByUsernameReturnsUserNotFoundWhenUsernameIsIncorrect(){
		
	}
	
	
}
