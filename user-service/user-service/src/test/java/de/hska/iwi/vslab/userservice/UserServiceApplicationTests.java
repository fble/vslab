package de.hska.iwi.vslab.userservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.hska.iwi.vslab.userservice.actions.RegisterAction;
import de.hska.iwi.vslab.userservice.controller.json.JSONRegistration;
import de.hska.iwi.vslab.userservice.db.dataobjects.User;
import de.hska.iwi.vslab.userservice.manager.UserManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

	@Autowired
	private RegisterAction registerAction;
	@Autowired
	private UserManager userManager;

	private JSONRegistration mockRegistration;

	@Before
	public void setup() {
		mockRegistration = new JSONRegistration();
		mockRegistration.setFirstname("test");
		mockRegistration.setLastname("user");
		mockRegistration.setPassword1("1234");
		mockRegistration.setPassword2("1234");
		mockRegistration.setUsername("test user");
		
		removeMocks();
	}

	@Test
	public void testRegistration() throws Exception {
		assertThat(userManager.doesUserAlreadyExist(mockRegistration.getUsername())).isFalse();

		registerAction.register(mockRegistration);

		assertThat(userManager.doesUserAlreadyExist(mockRegistration.getUsername())).isTrue();
	}

	@After
	public void cleanup() {
		removeMocks();
	}
	
	private void removeMocks() {
		User user = userManager.getUserByUsername(mockRegistration.getUsername());

		if (user != null)
			userManager.deleteUserById(user.getId());
	}

}
