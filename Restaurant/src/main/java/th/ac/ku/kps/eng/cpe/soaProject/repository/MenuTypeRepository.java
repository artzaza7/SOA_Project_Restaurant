package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.MenuType;

public interface MenuTypeRepository extends CrudRepository<MenuType, Integer> {

	@Query("from MenuType m where m.menuTypeName = :name")
	public MenuType findByName(@Param("name")String name);
	
	@Query("from MenuType m inner join m.menus s where s.menuId = :id")
	public MenuType findByMenuID(@Param("id")int id);
}
