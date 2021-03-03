package pl.gennadziy.RememberRest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gennadziy.RememberRest.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
