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

import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.v3.oas.annotations.Parameter;
import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuInCourse;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;
import th.ac.ku.kps.eng.cpe.soaProject.service.CourseMenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuInCourseService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuService;

@RestController
@RequestMapping("api/v1/menuInCourse")
@CrossOrigin("http://localhost:8081/")
public class MenuInCourseController {
	
	@Autowired
	private MenuInCourseService menuInCourseService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private CourseMenuService coursMenuService;

	@GetMapping("")
	public List<MenuInCourse> getMenuInCourse() {
		return (List<MenuInCourse>) menuInCourseService.getMenuInCourse();
	}

	@GetMapping("/{id}")
	public MenuInCourse getMenuInCourseByID(@PathVariable int id) {
		return (MenuInCourse) menuInCourseService.getMenuInCourseByID(id);
	}

	@PostMapping("")
	public ResponseEntity<String> createMenuInCourse(@RequestBody JsonNode body) {
		MenuInCourse menuInCourse = new MenuInCourse();
		Menu menu = menuService.getMenuByID(body.get("menu").asInt());
		CourseMenu courseMenu = coursMenuService.getCourseMenuByID(body.get("courseMenu").asInt());
		menuInCourse.setCourseMenu(courseMenu);
		menuInCourse.setMenu(menu);
		menuInCourseService.createOrUpdateMenuInCourse(menuInCourse);
		String successMessage = "Create Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateMenuInCourse(@RequestBody JsonNode body, @PathVariable int id) {
		MenuInCourse menuInCourse = new MenuInCourse();
		Menu menu = menuService.getMenuByID(body.get("menu").asInt());
		CourseMenu courseMenu = coursMenuService.getCourseMenuByID(body.get("courseMenu").asInt());
		menuInCourse.setMenuInCourseId(id);
		menuInCourse.setCourseMenu(courseMenu);
		menuInCourse.setMenu(menu);
		menuInCourseService.createOrUpdateMenuInCourse(menuInCourse);
		String successMessage = "Update Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenuInCourse(@PathVariable int id) {
		menuInCourseService.deleteMenuInCourse(id);
		String successMessage = "Delete Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
}