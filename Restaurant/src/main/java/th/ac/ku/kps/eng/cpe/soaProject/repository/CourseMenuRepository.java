package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;

public interface CourseMenuRepository extends CrudRepository<CourseMenu, Integer> {

	@Query("from CourseMenu c where c.courseMenuName = :name")
	public CourseMenu findByName(@Param("name")String name);
}
