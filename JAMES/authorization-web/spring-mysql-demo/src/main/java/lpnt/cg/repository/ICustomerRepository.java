package lpnt.cg.repository;

import lpnt.cg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}