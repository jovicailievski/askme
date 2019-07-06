package com.askme.askme.web.rest;

import com.askme.askme.models.User;
import com.askme.askme.models.UserRole;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Optional<UserRole> uro = userRoleService.findById(1L);
        ur = uro.get();
        u.setUserRole(ur);
        u.setUsername("exfled");
        u.setPassword(passwordEncoder.encode("exfled123"));
        userService.save(u);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }
}
