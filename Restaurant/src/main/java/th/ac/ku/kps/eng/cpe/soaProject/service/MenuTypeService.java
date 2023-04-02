package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;
import th.ac.ku.kps.eng.cpe.soaProject.repository.MenuTypeRepository;


@Service
public class MenuTypeService {

	@Autowired
	private MenuTypeRepository menuTypeRepository;
	
	public List<MenuType> getMenuType() {
		return (List<MenuType>)menuTypeRepository.findAll();
	}
	
	public MenuType getMenuTypeByID(int id) {
		return menuTypeRepository.findById(id).get();
	}
	
	public MenuType getMenuTypeByMenuID(int id) {
		return menuTypeRepository.findByMenuID(id);
	}
	
	public MenuType getMenuTypeByName(String name) {
		return (MenuType) menuTypeRepository.findByName(name);
	}
	
	public void createOrUpdateMenuType(MenuType menu) {
		menuTypeRepository.save(menu);
	}
	
	public void deleteMenuType(int id) {
		menuTypeRepository.deleteById(id);
	}

}