package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.MenuInCourse;
import th.ac.ku.kps.eng.cpe.soaProject.repository.MenuInCourseRepository;

@Service
public class MenuInCourseService {

	@Autowired
	private MenuInCourseRepository menuInCourseRepository;
	
	public List<MenuInCourse> getMenuInCourse() {
		return (List<MenuInCourse>)menuInCourseRepository.findAll();
	}
	
	public MenuInCourse getMenuInCourseByID(int id) {
		return menuInCourseRepository.findById(id).get();
	}
	
	public void createOrUpdateMenuInCourse(MenuInCourse menu) {
		menuInCourseRepository.save(menu);
	}
	
	public void deleteMenuInCourse(int id) {
		menuInCourseRepository.deleteById(id);
	}

}
