package com.capitanbeto.sushi.config;

import com.capitanbeto.sushi.users.User;
import com.capitanbeto.sushi.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> res = userRepository.findUserByUsername(username);
        if (res.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        User userEntity = res.stream().findFirst().orElse(null);
        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername(userEntity.getUsername())
                .password("{noop}" + userEntity.getPassword())
                .authorities("USER")
                .build();
        return user;
    }
}
