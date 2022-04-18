package lpnt.cg.service;

import lpnt.cg.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
