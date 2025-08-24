package com.whaply.Groccy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whaply.Groccy.infrastructure.entities.User;
import com.whaply.Groccy.infrastructure.repository.UserRepository;
import com.whaply.Groccy.interfaces.IUserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService implements  IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not Found"));
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new EntityNotFoundException("User not Found"));
        if(user.getName() != null) existingUser.setName(user.getName());
        if(user.getPassword() != null) existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
