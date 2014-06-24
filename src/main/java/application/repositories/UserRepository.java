package application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
