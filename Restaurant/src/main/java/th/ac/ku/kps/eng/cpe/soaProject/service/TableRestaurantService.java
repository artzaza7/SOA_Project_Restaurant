package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.Menu;
import th.ac.ku.kps.eng.cpe.soaProject.model.TableRestaurant;
import th.ac.ku.kps.eng.cpe.soaProject.repository.TableRestaurantRepository;

@Service
public class TableRestaurantService {

	@Autowired
	private TableRestaurantRepository tableRestaurantRepository;

	public List<TableRestaurant> getTables(){
		return (List<TableRestaurant>)tableRestaurantRepository.findAll();
	}
	
	public TableRestaurant getTableByID(int id){
		return tableRestaurantRepository.findById(id).get();
	}
	
	public TableRestaurant getTableByCode(String code){
		return tableRestaurantRepository.findByCode(code);
	}
	
	public void createNewTable(TableRestaurant table) {
		tableRestaurantRepository.save(table);
	}
	
	public void updateTable(TableRestaurant table) {
		tableRestaurantRepository.save(table);
	}
	
	public void deleteTable(int id) {
		tableRestaurantRepository.deleteById(id);
	}
}
