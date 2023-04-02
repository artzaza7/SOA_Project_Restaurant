package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import th.ac.ku.kps.eng.cpe.soaProject.model.CourseMenu;
import th.ac.ku.kps.eng.cpe.soaProject.model.Reservation;
import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;
import th.ac.ku.kps.eng.cpe.soaProject.model.User;
import th.ac.ku.kps.eng.cpe.soaProject.service.CourseMenuService;
import th.ac.ku.kps.eng.cpe.soaProject.service.ReservationService;
import th.ac.ku.kps.eng.cpe.soaProject.service.TableRestaurantService;
import th.ac.ku.kps.eng.cpe.soaProject.service.UserService;

@RestController
@RequestMapping("api/v1/reservations")
@CrossOrigin("http://localhost:8081/")
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

		// Parse the string to a LocalDate object
		LocalDate localDate = LocalDate.parse(body.get("reservationDate").asText());

		// Convert the LocalDate to a java.sql.Date object
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

		// Parse the string to a LocalTime object
		LocalTime localTime = LocalTime.parse(body.get("reservationTimeStart").asText());

		// Convert the LocalTime to a java.sql.Time object
		java.sql.Time sqlTime = java.sql.Time.valueOf(localTime);
		
		// Parse the string to a LocalTime object
		LocalTime localTimeEnd = LocalTime.parse(body.get("reservationTimeEnd").asText());

		// Convert the LocalTime to a java.sql.Time object
		java.sql.Time sqlTimeEnd = java.sql.Time.valueOf(localTimeEnd);
		// ============== From body ==============
		CourseMenu courseMenu = courseMenuService.getCourseMenuByID(body.get("courseMenu").asInt()); 
		User user = userService.getUserByID(body.get("user").asInt());
		TableRestaurant tableRestaurant = tableRestaurantService.getTableByID(body.get("tableRestaurant").asInt());
		// ========================================
		createReservation.setUser(user);
		createReservation.setCourseMenu(courseMenu);
		createReservation.setTableRestaurant(tableRestaurant);
		createReservation.setReservationStatus("BOOKING");
		createReservation.setReservationTimeStart(sqlTime);
		createReservation.setReservationTimeEnd(sqlTimeEnd);
		createReservation.setReservationDate(sqlDate);
		reservationService.createNewReservation(createReservation);
		String successMessage = "Create reservation Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody JsonNode body) {
		Reservation updateReservation = reservationService.getReservationByID(id);
		// Parse the string to a LocalDate object
		LocalDate localDate = LocalDate.parse(body.get("reservationDate").asText());
		
		// Convert the LocalDate to a java.sql.Date object
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

		// Parse the string to a LocalTime object
		LocalTime localTime = LocalTime.parse(body.get("reservationTimeStart").asText());

		// Convert the LocalTime to a java.sql.Time object
		java.sql.Time sqlTime = java.sql.Time.valueOf(localTime);
				
		// Parse the string to a LocalTime object
		LocalTime localTimeEnd = LocalTime.parse(body.get("reservationTimeEnd").asText());

		// Convert the LocalTime to a java.sql.Time object
		java.sql.Time sqlTimeEnd = java.sql.Time.valueOf(localTimeEnd);
		// ============== From body ==============
		CourseMenu courseMenu = courseMenuService.getCourseMenuByID(body.get("courseMenu").asInt()); 
		User user = userService.getUserByID(body.get("user").asInt());
		TableRestaurant tableRestaurant = tableRestaurantService.getTableByID(body.get("tableRestaurant").asInt());
		// ========================================
		updateReservation.setReservationId(id);
		updateReservation.setUser(user);
		updateReservation.setCourseMenu(courseMenu);
		updateReservation.setTableRestaurant(tableRestaurant);
		updateReservation.setReservationStatus(body.get("reservationStatus").asText());
		updateReservation.setReservationTimeStart(sqlTime);
		updateReservation.setReservationTimeEnd(sqlTimeEnd);
		updateReservation.setReservationDate(sqlDate);
		reservationService.updateReservation(updateReservation);
		String successMessage = "Update reservation Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable int id) {
		reservationService.deleteReservation(id);
		String successMessage = "Delete reservation Successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
}
