package th.ac.ku.kps.eng.cpe.soaProject.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

	@Query("from Reservation r inner join r.user u where u.userId = :id")
	public List<Reservation> findByUserID(@Param("id")int id);
	
	@Query("from Reservation r inner join r.tableRestaurant t where t.tableRestaurantId = :id and r.reservationDate = :date and :start > r.reservationTimeStart and :start < r.reservationTimeEnd or :end > r.reservationTimeStart and :end < r.reservationTimeEnd and r.reservationStatus = 'BOOKING'")
	public Reservation findByReservation(@Param("id")int id, @Param("date")Date date, @Param("start")Time start, @Param("end")Time end);
}
