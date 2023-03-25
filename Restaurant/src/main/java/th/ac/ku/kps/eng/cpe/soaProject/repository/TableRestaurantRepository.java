package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;

public interface TableRestaurantRepository extends CrudRepository<TableRestaurant, Integer> {

	@Query("from TableRestaurant t where t.tableRestaurantCode = :code")
	public TableRestaurant findByCode(@Param("code")String code);
	
}
