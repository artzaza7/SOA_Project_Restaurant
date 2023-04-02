package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;
import th.ac.ku.kps.eng.cpe.soaProject.service.CourseMenuService;

@RestController
@RequestMapping("api/v1/coursemenus")
@CrossOrigin("http://localhost:8081/")
public class CourseMenuController {
	@Autowired
	private CourseMenuService courseMenuService;
	
	@GetMapping("")
	public List<CourseMenu> getCourseMenus() {
		return (List<CourseMenu>) courseMenuService.getCourseMenus();
	}
	
	@GetMapping("/{id}")
	public CourseMenu getCourseMenuByID(@PathVariable int id) {
		return (CourseMenu)courseMenuService.getCourseMenuByID(id);
	}
	
	@GetMapping("/name/{name}")
	public CourseMenu getCourseMenuByName(@PathVariable String name) {
		return (CourseMenu)courseMenuService.getCourseMenuByName(name);
	}
	
	@GetMapping("/user/{id}")
	public List<CourseMenu> getCourseMenusByUser(@PathVariable int id) {
		return (List<CourseMenu>) courseMenuService.getCourseMenuByUser(id);
	}
	
	@GetMapping("/reservation/{id}")
	public List<CourseMenu> getCourseMenusByReserve(@PathVariable int id) {
		return (List<CourseMenu>) courseMenuService.getCourseMenuByReserve(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> createNewReservation(@RequestBody CourseMenu courseMenu) {
		CourseMenu check = courseMenuService.getCourseMenuByName(courseMenu.getCourseMenuName());
		if(check == null) {
			courseMenuService.createNewCourseMenu(courseMenu);
			String successMessage = "Create courseMenu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate CourseMenu Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody CourseMenu courseMenu) {
		courseMenu.setCourseMenuId(id);
		courseMenu.setMenuInCourses(null);
		courseMenu.setReservations(null);
		CourseMenu check = courseMenuService.getCourseMenuByName(courseMenu.getCourseMenuName());
		if(check == null || check.getCourseMenuId() == id) {
			courseMenuService.updateCourseMenu(courseMenu);
			String successMessage = "Update courseMenu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate CourseMenu Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable int id) {
		courseMenuService.deleteCourseMenu(id);
		String successMessage = "Delete courseMenu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
}
