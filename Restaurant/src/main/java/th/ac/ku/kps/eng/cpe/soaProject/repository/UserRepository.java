package th.ac.ku.kps.eng.cpe.soaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.ku.kps.eng.cpe.soaProject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("from User u where u.userUsername =:username and u.userPassword =:password")
	public User findByUserAndPass(@Param("username")String username, @Param("password")String password);
}
