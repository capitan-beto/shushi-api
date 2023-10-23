package com.capitanbeto.sushi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    HashMap<String, Object> data;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public ResponseEntity<Object> getSingleUser(Long id) {
        data = new HashMap<>();
        Optional<User> res = this.userRepository.findById(id);
        if (res.isEmpty()) {
            data.put("error", true);
            data.put("message", "Product ID not found");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.NOT_FOUND
            );
        }

        data.put("message", res);
        return new ResponseEntity<>(
                data,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Object> newUser(User user) {
        HashMap<String, Object> data = new HashMap<>();
        Optional<User> res = userRepository.findUserByUsername(user.getUsername());
        Optional<User> email = userRepository.findUserByEmail(user.getEmail());

        if (res.isPresent()) {
            data.put("error", true);
            data.put("message", "Username is already in use");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        } else if (email.isPresent()) {
            data.put("error", true);
            data.put("message", "Email is already registered");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        data.put("message", "User successfully saved");
        if (user.getId() != null) {
            data.put("message", "User successfully updated");
        }

        userRepository.save(user);
        data.put("data", user);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteUser(Long id) {
        data = new HashMap<>();
        boolean exists = this.userRepository.existsById(id);

        if (!exists) {
            data.put("error", true);
            data.put("message", "There's no user with that ID");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.NOT_FOUND
            );
        }

        userRepository.deleteById(id);
        data.put("message", "User deleted successfully");
        return new ResponseEntity<>(
                data,
                HttpStatus.ACCEPTED
        );
    }
}
