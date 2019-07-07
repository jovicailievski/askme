package com.askme.askme.web.rest;


import java.security.Principal;
import com.askme.askme.models.User;
import com.askme.askme.models.UserRole;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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


        ur = userRoleService.findById(2L);
        u.setUserRole(ur);
        u.setUsername("anonymous");
        u.setPassword(passwordEncoder.encode("anonymous"));
        userService.save(u);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
       return userService.findById(id);
    }

//    @PostMapping("/login")
//    public boolean login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        UserDetails ud = userService.loadUserByUsername(username);
//        return ud.getPassword().equals(passwordEncoder.encode(password));
//    }

    @GetMapping("/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
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
