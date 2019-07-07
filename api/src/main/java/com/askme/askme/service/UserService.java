package com.askme.askme.service;

import com.askme.askme.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(User u);
    UserDetails loadUserByUsername(String s);
    List<User> findAll();
    User findById(Long id);

}
