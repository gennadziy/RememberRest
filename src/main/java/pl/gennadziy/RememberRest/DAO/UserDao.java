package pl.gennadziy.RememberRest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gennadziy.RememberRest.model.Use;

public interface UserDao extends JpaRepository<Use, Long> {
}
