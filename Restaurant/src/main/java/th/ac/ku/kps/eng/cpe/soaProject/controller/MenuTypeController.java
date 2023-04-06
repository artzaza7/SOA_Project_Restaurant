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

import io.swagger.v3.oas.annotations.Parameter;
import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuTypeService;



@RestController
@RequestMapping("api/v1/menuType")
@CrossOrigin("http://localhost:8081/")
public class MenuTypeController {
	
	@Autowired
	private MenuTypeService menuTypeService;

	@GetMapping("")
	public List<MenuType> getMenuType() {
		return (List<MenuType>) menuTypeService.getMenuType();
	}

	@GetMapping("/{id}")
	public MenuType getMenuTypeByID(@PathVariable int id) {
		return (MenuType) menuTypeService.getMenuTypeByID(id);
	}
	
	@GetMapping("/name/{name}")
	public MenuType getMenuTypeByName(@PathVariable String name) {
		return (MenuType) menuTypeService.getMenuTypeByName(name);
	}

	@PostMapping("")
	public ResponseEntity<String> createMenuType(@RequestBody MenuType menu) {
		MenuType check = menuTypeService.getMenuTypeByName(menu.getMenuTypeName());
		if(check == null) {
			menuTypeService.createOrUpdateMenuType(menu);
			String successMessage = "Create Menu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate MenuType Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateMenuType(@RequestBody MenuType menu, @PathVariable int id) {
		menu.setMenuTypeId(id);
		MenuType check = menuTypeService.getMenuTypeByName(menu.getMenuTypeName());
		if(check == null || check.getMenuTypeId() == id) {
			menuTypeService.createOrUpdateMenuType(menu);
			String successMessage = "Update Menu Successfully.";
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			return response;
		}
		String successMessage = "Duplicate MenuType Name.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.NOT_FOUND);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenuType(@PathVariable int id) {
		menuTypeService.deleteMenuType(id);
		String successMessage = "Delete Menu Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
}
