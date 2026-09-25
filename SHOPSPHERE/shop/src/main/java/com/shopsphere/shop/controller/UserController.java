// // // package com.shopsphere.shop.controller;

// // // import com.shopsphere.shop.entity.User;
// // // import com.shopsphere.shop.service.UserService;
// // // import org.springframework.web.bind.annotation.*;

// // // import java.util.List;

// // // @RestController
// // // @RequestMapping("/users")
// // // public class UserController {

// // //     private final UserService userService;

// // //     public UserController(UserService userService) {
// // //         this.userService = userService;
// // //     }

// // //     @PostMapping
// // //     public User createUser(@RequestBody User user) {
// // //         return userService.createUser(user);
// // //     }

// // //     @GetMapping
// // //     public List<User> getAllUsers() {
// // //         return userService.getAllUsers();
// // //     }

// // //     @GetMapping("/{id}")
// // //     public User getUserById(@PathVariable int id) {
// // //         return userService.getUserById(id);
// // //     }

// // //     @PutMapping("/{id}")
// // //     public User updateUser(@PathVariable int id, @RequestBody User user) {
// // //         return userService.updateUser(id, user);
// // //     }

// // //     @DeleteMapping("/{id}")
// // //     public void deleteUser(@PathVariable int id) {
// // //         userService.deleteUser(id);
// // //     }
// // //     @PostMapping("/login")
// // // public User login(@RequestBody User user) {
// // //     return userService.login(user.getEmail(), user.getPassword());
// // // }
// // // }
// // package com.shopsphere.shop.controller;

// // import com.shopsphere.shop.dto.UserDTO;
// // import com.shopsphere.shop.entity.User;
// // import com.shopsphere.shop.service.UserService;

// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;
// // import java.util.Optional;

// // @RestController
// // @RequestMapping("/users")
// // public class UserController {

// //     private final UserService userService;

// //     public UserController(UserService userService) {
// //         this.userService = userService;
// //     }

// //     @PostMapping
// //     public User createUser(@RequestBody User user) {
// //         return userService.createUser(user);
// //     }

// //     @GetMapping
// //     public List<UserDTO> getAllUsers() {
// //         return userService.getAllUsers();
// //     }

// //     @GetMapping("/{id}")
// //     public Optional<UserDTO> getUserById(@PathVariable int id) {
// //         return userService.getUserById(id);
// //     }

// //     @PutMapping("/{id}")
// //     public User updateUser(
// //             @PathVariable int id,
// //             @RequestBody User user) {

// //         return userService.updateUser(id, user);
// //     }

// //     @DeleteMapping("/{id}")
// //     public void deleteUser(@PathVariable int id) {
// //         userService.deleteUser(id);
// //     }

// //     @PostMapping("/login")
// //     public User login(
// //             @RequestParam String email,
// //             @RequestParam String password) {

// //         return userService.login(email, password);
// //     }
// // }
// package com.shopsphere.shop.controller;

// import com.shopsphere.shop.dto.UserDTO;
// import com.shopsphere.shop.entity.User;
// import com.shopsphere.shop.service.UserService;

// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/users")
// public class UserController {

//     private final UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping
//     public User createUser(@RequestBody User user) {
//         return userService.createUser(user);
//     }

//     @GetMapping
//     public List<UserDTO> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     @GetMapping("/{id}")
//     public Optional<UserDTO> getUserById(@PathVariable int id) {
//         return userService.getUserById(id);
//     }

//     @PutMapping("/{id}")
//     public User updateUser(
//             @PathVariable int id,
//             @RequestBody User user) {

//         return userService.updateUser(id, user);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteUser(@PathVariable int id) {
//         userService.deleteUser(id);
//     }

//     @PostMapping("/login")
//     public UserDTO login(
//             @RequestParam String email,
//             @RequestParam String password) {

//         return userService.login(email, password);
//     }
// }
package com.shopsphere.shop.controller;

import com.shopsphere.shop.entity.User;
import com.shopsphere.shop.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable int id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        return userService.login(email, password);
    }
}