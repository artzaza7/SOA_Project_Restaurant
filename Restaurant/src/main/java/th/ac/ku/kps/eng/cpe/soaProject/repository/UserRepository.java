package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soaProject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
