package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.service.MenuService;


@RestController
@RequestMapping("api/v1/menus")
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/")
	public List<Menu> getMenu() {
		return (List<Menu>) menuService.getMenus();
	}

	@GetMapping("/id/{id}")
	public Menu getMenuByID(@PathVariable int id) {
		return (Menu) menuService.getMenuByID(id);
	}
	
	@GetMapping("/name/{name}")
	public Menu getMenuByName(@PathVariable String name) {
		return (Menu) menuService.getMenuByName(name);
	}

	@PostMapping("/")
	public Menu createMenu(@RequestBody Menu menu) {
		menuService.createOrUpdateMenu(menu);
		return menu;
	}

	@PutMapping("/")
	public Menu updateMenu(@RequestBody Menu menu) {
		menuService.createOrUpdateMenu(menu);
		return menu;
	}

	@DeleteMapping("/{id}")
	public void deleteMenu(@PathVariable int id) {
		menuService.deleteMenu(id);
	}
}
