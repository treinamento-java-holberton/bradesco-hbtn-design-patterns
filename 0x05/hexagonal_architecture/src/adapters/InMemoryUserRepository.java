// Adaptador (Implementação do repositório em memória)
package adapters;

import domain.User;
import ports.UserRepository;

import java.util.*;


public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> database = new HashMap<>();

    @Override
    public void save(User user) {
        if (existsById(user.getId())) {
            return;
        }
        database.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        User output = null;
        if (existsById(id)) {
            output = database.get(id);
        }
        return output;
    }

    @Override
    public List<User> findAll() {
        return database.values().stream().toList();
    }

    private boolean existsById(String id) {
        return database.containsKey(id);
    }
}