package com.askme.askme.service.Impl;

import com.askme.askme.models.User;
import com.askme.askme.models.UserRole;
import com.askme.askme.repository.jpa.JpaUserRepository;
import com.askme.askme.repository.jpa.JpaUserRoleRepository;
import com.askme.askme.service.UserRoleService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JpaUserRepository userRepository;

//    @Autowired
//    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User save(User u) {

//        u.setPassword(passwordEncoder.encode(u.getPassword()));
//        UserRole ur = userRoleService.findById(u.getUserRole().getId());
//        u.setUserRole(ur);
        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }

    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }


}

