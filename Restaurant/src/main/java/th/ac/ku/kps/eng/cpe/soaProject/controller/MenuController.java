package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

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
import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuTypeService;

@CrossOrigin("http://localhost:8081/")
@RestController
@RequestMapping("api/v1/menus")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuTypeService menuTypeService;

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
		menu.setMenuInCourses(null);
		menuService.createOrUpdateMenu(menu);
		String successMessage = "Create Menu Success.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@PutMapping("")
	public ResponseEntity<String> updateMenu(@RequestBody Menu menu,@Parameter(name="id")int id) {
		MenuType menuType = new MenuType();
		menuType = menuTypeService.getMenuTypeByID(id);
		menu.setMenuType(menuType);
		menuService.createOrUpdateMenu(menu);
		String successMessage = "Update Menu Success.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable int id) {
		menuService.deleteMenu(id);
		String successMessage = "Delete Menu Success.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/type")
//	public Menu getMenuWithType() {
//		return (Menu) menuService.getType();
//	}
}
