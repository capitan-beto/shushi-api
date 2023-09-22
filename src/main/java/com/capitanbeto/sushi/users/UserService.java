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

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public ResponseEntity<Object> newUser(User user) {
        HashMap<String, Object> data = new HashMap<>();
        Optional<User> res = userRepository.findUserByUsername(user.getUsername());

        if (res.isPresent() && user.getId() == null) {
            data.put("error", true);
            data.put("message", "There's already a product with that name");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        data.put("message", "Product successfully saved");
        if (user.getId() != null) {
            data.put("message", "Product successfully updated");
        }

        userRepository.save(user);
        data.put("data", user);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }
}
