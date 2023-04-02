package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;
import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;
import th.ac.ku.kps.eng.cpe.soaProject.model.User;
import th.ac.ku.kps.eng.cpe.soaProject.service.CourseMenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.ReservationService;
import th.ac.ku.kps.eng.cpe.soaProject.service.TableRestaurantService;
import th.ac.ku.kps.eng.cpe.soaProject.service.UserService;

@CrossOrigin("http://localhost:8081/")
@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private TableRestaurantService tableRestaurantService;
	@Autowired
	private UserService userService;
	@Autowired
	private CourseMenuService courseMenuService;
	
	@GetMapping("")
	public List<Reservation> getReservations() {
		return (List<Reservation>) reservationService.getReservations();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationByID(@PathVariable int id) {
		return (Reservation)reservationService.getReservationByID(id);
	}
	// Reservation reservation
	@PostMapping("")
	public ResponseEntity<String> createNewReservation(@RequestBody JsonNode body) {
		Reservation createReservation = new Reservation();
		
		// ============== From body ==============
		CourseMenu courseMenu = courseMenuService.getCourseMenuByID(body.get("courseMenu").asInt()); 
		User user = userService.getUserByID(body.get("user").asInt());
		TableRestaurant tableRestaurant = tableRestaurantService.getTableByID(body.get("tableRestaurant").asInt());
		// ========================================
		createReservation.setUser(user);
		createReservation.setCourseMenu(courseMenu);
		createReservation.setTableRestaurant(tableRestaurant);
		
		reservationService.createNewReservation(createReservation);
		String successMessage = "Create reservation successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody JsonNode body) {
		Reservation updateReservation = reservationService.getReservationByID(id);
		// ============== From body ==============
		CourseMenu courseMenu = courseMenuService.getCourseMenuByID(body.get("courseMenu").asInt()); 
		User user = userService.getUserByID(body.get("user").asInt());
		TableRestaurant tableRestaurant = tableRestaurantService.getTableByID(body.get("tableRestaurant").asInt());
		// ========================================
		updateReservation.setUser(user);
		updateReservation.setCourseMenu(courseMenu);
		updateReservation.setTableRestaurant(tableRestaurant);
		reservationService.updateReservation(updateReservation);
		String successMessage = "Update reservation successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable int id) {
		reservationService.deleteReservation(id);
		String successMessage = "Delete reservation successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
}
