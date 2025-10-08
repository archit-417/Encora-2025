package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test 
	public void shouldReturnUserName_whenUserExsits() {
		User user = new User(1, "Alice");
		
		when(userRepository.findById(1))
		.thenReturn(Optional.of(user));
		
		String result = userService.getUserNameById(1);
		
		assertEquals("Alice", result);
		verify(userRepository).findById(1);
	}

	@Test
	public void shouldReturnUnknown_whenUserNotFound () {
		when(userRepository.findById(2))
		.thenReturn(Optional.empty());
		
		String result = userService.getUserNameById(2);
		
		assertEquals("Unknown", result);
	}
}