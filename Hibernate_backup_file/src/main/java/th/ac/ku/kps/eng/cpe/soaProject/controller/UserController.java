package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import th.ac.ku.kps.eng.cpe.soaProject.model.User;
import th.ac.ku.kps.eng.cpe.soaProject.service.UserService;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("http://localhost:8081/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<User> getUsers() {
		return (List<User>)userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable int id) {
		return (User)userService.getUserByID(id);
	}
	
	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return (User)userService.getUserByName(username);
	}
	
	@PostMapping("")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User check = userService.getUserByName(user.getUserUsername());
		if(check == null) {
			userService.createNewUser(user);
			String successMessage = "Create Menu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate Username.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		user.setUserId(id);
		user.setReservations(null);
		User check = getUserByUsername(user.getUserUsername());
		if(check == null || check.getUserId() == id) {
			userService.updateUser(user);
			String successMessage = "Update user Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate Username.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		String successMessage = "Delete Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@GetMapping("/")
	public ResponseEntity<User> getUserByUserAndPass(@Parameter(name="username")String username, @Parameter(name="password")String password) {
		User user = userService.getByUserAndPass(username, password);
		System.out.print(user);
		if(user == null) {
			ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
			return response;
		}
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	}
}
