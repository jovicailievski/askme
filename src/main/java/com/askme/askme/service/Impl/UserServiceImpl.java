package com.askme.askme.service.Impl;

import com.askme.askme.models.User;
import com.askme.askme.repository.jpa.JpaUserRepository;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JpaUserRepository repo;


    @Override
    public User save(User u) {
        return repo.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repo.findByUsername(s);
    }

    @Override
    public List<User> findAll() {
       return repo.findAll();
    }


}

