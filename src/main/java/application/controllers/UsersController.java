package application.controllers;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.models.User;
import application.repositories.UserRepository;

@Controller
public class UsersController {
	@Autowired private UserRepository userRepository;
	
	private static User user;

	
	@RequestMapping("/users")
	public String userCreate(Model model){
		
		//create user object
		user = new User();
		//set in the values for the user object
		user.setFirst_name("PUT FIRST NAME HERE");
		user.setLast_name("PUT LAST NAME HERE");
		user.setEmail("PUT EMAIL HERE");
		user.setPassword("PUT PASSWORD HERE");
		
		//prepare the timestamp
		Date date = new Date(System.currentTimeMillis());
		Timestamp timestamp = new Timestamp(date.getTime());
		
		//set in the current time stamps for created_at and updated_at fields
		user.setCreated_at(timestamp);
		user.setUpdated_at(timestamp);
		
		//save it to user object to repository
		userRepository.save(user);
		
		//make the repository accessible to the views
		model.addAttribute("users", userRepository.findAll());
		
		//render the view
		return "index";
	}
}

