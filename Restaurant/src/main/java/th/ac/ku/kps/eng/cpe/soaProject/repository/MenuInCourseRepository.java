package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.MenuInCourse;

public interface MenuInCourseRepository extends CrudRepository<MenuInCourse, Integer> {

}
