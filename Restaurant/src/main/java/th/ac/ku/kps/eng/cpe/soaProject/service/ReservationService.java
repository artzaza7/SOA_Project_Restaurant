package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;
import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;
import th.ac.ku.kps.eng.cpe.soaProject.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getReservations(){
		return (List<Reservation>)reservationRepository.findAll();
	}
	
	public Reservation getReservationByID(int id){
		return reservationRepository.findById(id).get();
	}
	
	public List<Reservation> getReservationByUserID(int id){
		return reservationRepository.findByUserID(id);
	}
	
	public void createNewReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void updateReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void deleteReservation(int id) {
		reservationRepository.deleteById(id);
	}
}
