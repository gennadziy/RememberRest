package pl.gennadziy.RememberRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gennadziy.RememberRest.DAO.UserDao;
import pl.gennadziy.RememberRest.model.Use;

import java.util.List;
import java.util.Optional;

@Service
public class USerServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Use> allUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<Use> getUser(Long id) {
        Optional<Use> users = userDao.findById(id);
        return users;
    }

    @Override
    public void delete() {
        
    }
}
