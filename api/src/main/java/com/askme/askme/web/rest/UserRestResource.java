package com.askme.askme.web.rest;

import com.askme.askme.models.User;
import com.askme.askme.models.UserRole;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserRestResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init(){
        User u = new User();
        UserRole ur = new UserRole();
        ur.setName("ROLE_ADMIN");
        userRoleService.save(ur);
        ur = new UserRole();
        ur.setName("ROLE_MEMBER");
        userRoleService.save(ur);


        ur = userRoleService.findById(1L);
        u.setUserRole(ur);
        u.setUsername("exfled");
        u.setPassword(passwordEncoder.encode("exfled123"));
        userService.save(u);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
       return userService.findById(id);
    }

    @PostMapping("/register")
    public User createNewUser(@RequestParam("username") String username, @RequestParam("password") String password){
        UserRole ur = userRoleService.findById(2l);
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setUserRole(ur);
        return userService.save(u);
    }
}