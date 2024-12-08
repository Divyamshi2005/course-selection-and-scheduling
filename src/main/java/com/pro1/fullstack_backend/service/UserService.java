package com.pro1.fullstack_backend.service;

import com.pro1.fullstack_backend.entity.User;
import com.pro1.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already exists!";
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }
 // Get all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if user not found
    }

    // Save or update user
    public User save(User user) {
        return userRepository.save(user);
    }

    // Update user by ID
    public User update(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null; // Return null if user doesn't exist
    }

    // Delete user by ID
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
