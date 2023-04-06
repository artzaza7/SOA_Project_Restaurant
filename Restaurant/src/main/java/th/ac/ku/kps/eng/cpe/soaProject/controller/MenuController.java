package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.v3.oas.annotations.Parameter;
import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuInCourse;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;
import th.ac.ku.kps.eng.cpe.soaProject.service.CourseMenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuInCourseService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuTypeService;


@RestController
@RequestMapping("api/v1/menus")
@CrossOrigin("http://localhost:8081/")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuTypeService menuTypeService;
	@Autowired
	private CourseMenuService courseMenuService;
	@Autowired
	private MenuInCourseService menuInCourseService;

	@GetMapping("")
	public List<Menu> getMenu() {
		return (List<Menu>) menuService.getMenus();
	}

	@GetMapping("/{id}")
	public Menu getMenuByID(@PathVariable int id) {
		return (Menu) menuService.getMenuByID(id);
	}
	
	@GetMapping("/name/{name}")
	public Menu getMenuByName(@PathVariable String name) {
		return (Menu) menuService.getMenuByName(name);
	}
	
	@GetMapping("/course/{name}")
	public List<Menu> getMenuByCourse(@PathVariable String name) {
		return (List<Menu>) menuService.getMenuByCourse(name);
	}

	@PostMapping("")
	public ResponseEntity<String> createMenu(@RequestBody JsonNode body) {
		Menu menu = new Menu();
		MenuType menuType = menuTypeService.getMenuTypeByID(body.get("menuType").asInt());
		menu.setMenuName(body.get("menuName").asText());
		menu.setMenuDescription(body.get("menuDescription").asText());
		menu.setMenuType(menuType);
//		CourseMenu c = courseMenuService.getCourseMenuByID(body.get("courseMenu").asInt());
//		MenuInCourse mc = new MenuInCourse();
//		mc.setCourseMenu(c);
//		mc.setMenu(menu);
		Menu check = menuService.getMenuByName(menu.getMenuName());
		if(check == null) {
			menuService.createOrUpdateMenu(menu);
//			menuInCourseService.createOrUpdateMenuInCourse(mc);
			String successMessage = "Create Menu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate Menu Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateMenu(@RequestBody Menu menu,@PathVariable int id) {
		Menu m = menuService.getMenuByID(id);
		MenuType menuType = new MenuType();
		menuType = menuTypeService.getMenuTypeByMenuID(id);
		menu.setMenuId(id);
		menu.setMenuType(menuType);
		menu.setMenuInCourses(m.getMenuInCourses());
		Menu check = menuService.getMenuByName(menu.getMenuName());
		if(check == null || check.getMenuId() == id) {
			menuService.createOrUpdateMenu(menu);
			String successMessage = "Update Menu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate Menu Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable int id) {
		menuService.deleteMenu(id);
		String successMessage = "Delete Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/type")
//	public Menu getMenuWithType() {
//		return (Menu) menuService.getType();
//	}
}
