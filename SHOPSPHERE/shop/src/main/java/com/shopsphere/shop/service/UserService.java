// // package com.shopsphere.shop.service;

// // import com.shopsphere.shop.dto.UserDTO;
// // import com.shopsphere.shop.dto.UserMapper;
// // import com.shopsphere.shop.entity.User;
// // import com.shopsphere.shop.repository.UserRepository;

// // import org.springframework.stereotype.Service;

// // import java.util.List;
// // import java.util.Optional;

// // @Service
// // public class UserService {

// //     private final UserRepository userRepository;

// //     public UserService(UserRepository userRepository) {
// //         this.userRepository = userRepository;
// //     }

// //     public User createUser(User user) {
// //         return userRepository.save(user);
// //     }

// //     public List<UserDTO> getAllUsers() {

// //         List<User> users = userRepository.findAll();

// //         return users.stream()
// //                 .map(UserMapper::toDTO)
// //                 .toList();
// //     }

// //     public Optional<UserDTO> getUserById(int id) {

// //         Optional<User> user = userRepository.findById(id);

// //         if (user.isPresent()) {
// //             return Optional.of(UserMapper.toDTO(user.get()));
// //         }

// //         return Optional.empty();
// //     }

// //     public User updateUser(int id, User user) {

// //         User existingUser = userRepository.findById(id).orElse(null);

// //         if (existingUser != null) {

// //             existingUser.setEmail(user.getEmail());
// //             existingUser.setPassword(user.getPassword());

// //             return userRepository.save(existingUser);
// //         }

// //         return null;
// //     }

// //     public void deleteUser(int id) {
// //         userRepository.deleteById(id);
// //     }

// //     public User login(String email, String password) {

// //         User user = userRepository.findByEmail(email);

// //         if (user != null && user.getPassword().equals(password)) {
// //             return user;
// //         }

// //         return null;
// //     }
// // }
// package com.shopsphere.shop.service;

// import com.shopsphere.shop.dto.UserDTO;
// import com.shopsphere.shop.dto.UserMapper;
// import com.shopsphere.shop.entity.User;
// import com.shopsphere.shop.repository.UserRepository;

// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class UserService {

//     private final UserRepository userRepository;

//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public User createUser(User user) {
//         return userRepository.save(user);
//     }

//     public List<UserDTO> getAllUsers() {

//         List<User> users = userRepository.findAll();

//         return users.stream()
//                 .map(UserMapper::toDTO)
//                 .toList();
//     }

//     public Optional<UserDTO> getUserById(int id) {

//         Optional<User> user = userRepository.findById(id);

//         if (user.isPresent()) {
//             return Optional.of(UserMapper.toDTO(user.get()));
//         }

//         return Optional.empty();
//     }

//     public User updateUser(int id, User user) {

//         User existingUser = userRepository.findById(id).orElse(null);

//         if (existingUser != null) {

//             existingUser.setEmail(user.getEmail());
//             existingUser.setPassword(user.getPassword());

//             return userRepository.save(existingUser);
//         }

//         return null;
//     }

//     public void deleteUser(int id) {
//         userRepository.deleteById(id);
//     }

//     public UserDTO login(String email, String password) {

//         User user = userRepository.findByEmail(email);

//         if (user != null && user.getPassword().equals(password)) {
//             return UserMapper.toDTO(user);
//         }

//         return null;
//     }
// }
package com.shopsphere.shop.service;

import com.shopsphere.shop.entity.User;
import com.shopsphere.shop.exception.ResourceNotFoundException;
import com.shopsphere.shop.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));
    }

    public User updateUser(int id, User user) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new ResourceNotFoundException(
                    "User not found with email: " + email);
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}