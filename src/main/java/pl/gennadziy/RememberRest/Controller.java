package pl.gennadziy.RememberRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gennadziy.RememberRest.DAO.UserDao;
import pl.gennadziy.RememberRest.exception.ResourceNotFoundException;
import pl.gennadziy.RememberRest.model.Use;
import pl.gennadziy.RememberRest.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "api/all")
    public ResponseEntity<List<Use>> getAll() {
        return ResponseEntity.ok().body(userService.allUsers());
    }

    @GetMapping(value = "api/{id}")
    public ResponseEntity<Optional<Use>> getId(@PathVariable("id") Long id) throws Exception {
        Optional<Use> use = userService.getUser(id);
        if (use.isPresent()) {
            return ResponseEntity.ok().body(use);
        } else
            throw new ResourceNotFoundException("Not found id :: " + id);
    }

//    @DeleteMapping(value = "api/{id}")
//    public Map<String, Boolean> deletePlanet(@PathVariable(value = "id") Long id)
//            throws ResourceNotFoundException {
//        Use use = userService.getUser(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
//        userDao.deleteById(id);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    @DeleteMapping(value = "api/{id}")
    public String deletePlanet(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Use use = userService.getUser(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userDao.deleteById(id);
        return "Deleted  " +id;
    }

    @PostMapping(value = "api")
    public Use addUser(@Valid @RequestBody Use use) {
        return userDao.save(use);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Use> updateUser(@PathVariable(value = "id") Long id,
                                          @Valid @RequestBody Use useDetails) throws ResourceNotFoundException {
        Use user = userDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        user.setId(useDetails.getId());
        user.setName(useDetails.getName());
        final Use updatedUser = userDao.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
