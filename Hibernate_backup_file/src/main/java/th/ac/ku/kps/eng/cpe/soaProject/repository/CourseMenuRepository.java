package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;

public interface CourseMenuRepository extends CrudRepository<CourseMenu, Integer> {

	@Query("from CourseMenu c where c.courseMenuName = :name")
	public CourseMenu findByName(@Param("name")String name);
	
	@Query("from CourseMenu c inner join c.reservations r inner join r.user u  where u.userId = :id")
	public List<CourseMenu> findByUser(@Param("id")int id);
	
	@Query("from CourseMenu c inner join c.reservations r where r.reservationId = :id")
	public List<CourseMenu> findByReservation(@Param("id")int id);
}
