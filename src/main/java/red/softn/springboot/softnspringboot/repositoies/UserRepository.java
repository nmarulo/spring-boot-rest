package red.softn.springboot.softnspringboot.repositoies;

import org.springframework.data.repository.CrudRepository;
import red.softn.springboot.softnspringboot.db.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {



}
