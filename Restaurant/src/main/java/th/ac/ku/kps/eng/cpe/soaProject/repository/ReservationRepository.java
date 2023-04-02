package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

	@Query("from Reservation r inner join r.user u where u.userId = :id")
	public List<Reservation> findByUserID(@Param("id")int id);
}
