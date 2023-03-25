package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;
import th.ac.ku.kps.eng.cpe.soaProject.repository.CourseMenuRepository;

@Service
public class CourseMenuService {
	
	@Autowired
	private CourseMenuRepository courseMenuRepository;
	
	public List<CourseMenu> getCourseMenus(){
		return (List<CourseMenu>)courseMenuRepository.findAll();
	}
	
	public CourseMenu getCourseMenuByID(int id){
		return courseMenuRepository.findById(id).get();
	}
	
	public void createNewCourseMenu(CourseMenu courseMenu) {
		courseMenuRepository.save(courseMenu);
	}
	
	public void updateCourseMenu(CourseMenu courseMenu) {
		courseMenuRepository.save(courseMenu);
	}
	
	public void deleteCourseMenu(int id) {
		courseMenuRepository.deleteById(id);
	}
}
