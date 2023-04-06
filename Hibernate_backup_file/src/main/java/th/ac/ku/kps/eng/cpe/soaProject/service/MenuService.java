package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public List<Menu> getMenus() {
		return (List<Menu>)menuRepository.findAll();
	}
	
	public Menu getMenuByID(int id) {
		return menuRepository.findById(id).get();
	}
	
	public Menu getMenuByName(String name) {
		return (Menu) menuRepository.findByName(name);
	}
	
	public List<Menu> getMenuByCourse(String name) {
	return (List<Menu>) menuRepository.findByCourse(name);
	}
	
	public void createOrUpdateMenu(Menu menu) {
		menuRepository.save(menu);
	}
	
	public void deleteMenu(int id) {
		menuRepository.deleteById(id);
	}

}
