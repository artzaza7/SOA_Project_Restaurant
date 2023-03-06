package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.ku.kps.eng.cpe.soaProject.model.User;
import th.ac.ku.kps.eng.cpe.soaProject.service.UserService;

@Controller
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	@ResponseBody
	public List<User> getUsers() {
		return (List<User>)userService.getUsers();
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "pageWithOutUser/home";
	}

}
