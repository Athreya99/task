package com.demo.task.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword("default_password"); // You might want to handle password differently
        user.setRole(User.UserRole.valueOf(userDTO.getRole()));

        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }
    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getUser_id(),
                user.getUsername(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
