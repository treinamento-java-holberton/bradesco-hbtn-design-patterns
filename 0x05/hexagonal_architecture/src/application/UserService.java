package application;

import domain.User;
import ports.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(String id, String name) {
        userRepository.save(new User(id, name));
    }


    public User getUser(String id) {
        return userRepository.findById(id);
    }


    public List<User> listUsers() {
        return userRepository.findAll();
    }
}