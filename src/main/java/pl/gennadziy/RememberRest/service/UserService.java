package pl.gennadziy.RememberRest.service;

import pl.gennadziy.RememberRest.model.Use;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Use> allUsers();

    Optional<Use> getUser(Long id);

    void delete();
}
