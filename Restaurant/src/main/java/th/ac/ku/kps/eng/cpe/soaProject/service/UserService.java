package th.ac.ku.kps.eng.cpe.soaProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.ku.kps.eng.cpe.soaProject.model.User;
import th.ac.ku.kps.eng.cpe.soaProject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers() {
		return (List<User>)userRepository.findAll();
	}
	
	public User getUserByID(int id) {
		return userRepository.findById(id).get();
	}
	
	public void createNewUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public User getByUserAndPass(String username, String password) {
		return userRepository.findByUserAndPass(username, password);
	}
}
