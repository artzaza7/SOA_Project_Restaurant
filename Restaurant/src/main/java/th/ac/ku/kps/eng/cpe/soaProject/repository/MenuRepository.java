package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
	
	@Query("from Menu m where m.menuName = :name")
	public Menu findByName(@Param("name")String name);
}
