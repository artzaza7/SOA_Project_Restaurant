package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;

public interface TableRestaurantRepository extends CrudRepository<TableRestaurant, Integer> {

	@Query("from TableRestaurant t where t.tableRestaurantCode = :code")
	public TableRestaurant findByCode(@Param("code")String code);
	
	@Query("from TableRestaurant t inner join t.reservations r inner join r.user u  where u.userId = :id")
	public List<TableRestaurant> findByUser(@Param("id")int id);
	
}
