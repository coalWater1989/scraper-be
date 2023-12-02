package com.charbz.sendzbe.service;

import com.charbz.sendzbe.entity.User;
import com.charbz.sendzbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public Boolean login(String username, String password) {
        Optional<User> optUser = userRepository.findById(username);

        if (optUser.isPresent()) {
            User user = optUser.get();
            if (encoder.matches(user.getSalt() + password, user.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public Boolean signup(String username, String password) {
        Optional<User> optUser = userRepository.findById(username);

        if (!optUser.isPresent()) {
            User user = new User();
            user.setUsername(username);

            String salt = RandomStringUtils.randomAlphanumeric(16);
            user.setSalt(salt);

            String encodedPassword = encoder.encode(salt + password);
            user.setPassword(encodedPassword);

            userRepository.save(user);

            return true;
        }

        return false;
    }

    public User getUser(String username) {
        return userRepository.findById(username).get();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
