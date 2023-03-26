package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.MenuInCourse;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
	
	@Query("from Menu m where m.menuName = :name")
	public Menu findByName(@Param("name")String name);
	
	@Query("from Menu m inner join m.menuInCourses i inner join i.courseMenu c  where c.courseMenuName = :name")
	public List<Menu> findByCourse(@Param("name")String name);
}
