package th.ac.ku.kps.eng.cpe.soaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;
import th.ac.ku.kps.eng.cpe.soaProject.service.TableRestaurantService;

@RestController
@RequestMapping("api/v1/tables")
public class TableRestaurantController {
	
	@Autowired
	private TableRestaurantService tableRestaurantService;
	
	@GetMapping("")
	public List<TableRestaurant> getTables() {
		return (List<TableRestaurant>) tableRestaurantService.getTables();
	}
	
	@GetMapping("/{id}")
	public TableRestaurant getTablesByID(@PathVariable int id) {
		return (TableRestaurant)tableRestaurantService.getTableByID(id);
	}
	
	@GetMapping("/code/{code}")
	public TableRestaurant getTablesByCode(@PathVariable String code) {
		return (TableRestaurant)tableRestaurantService.getTableByCode(code);
	}
	
	@PostMapping("")
	public ResponseEntity<String> createNewTable(@RequestBody TableRestaurant table) {
		tableRestaurantService.createNewTable(table);
		String successMessage = "Create table successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateTable(@PathVariable int id, @RequestBody TableRestaurant table) {
		table.setTableRestaurantId(id);
		tableRestaurantService.updateTable(table);
		String successMessage = "Update table successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTable(@PathVariable int id) {
		tableRestaurantService.deleteTable(id);
		String successMessage = "Delete table successfully.";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	
	
}
