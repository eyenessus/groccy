package com.whaply.Groccy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whaply.Groccy.dtos.requests.UserRequest;
import com.whaply.Groccy.dtos.responses.UserResponse;
import com.whaply.Groccy.exceptions.NotFoundException;
import com.whaply.Groccy.infrastructure.entities.User;
import com.whaply.Groccy.infrastructure.repository.UserRepository;
import com.whaply.Groccy.interfaces.IUserService;
import com.whaply.Groccy.mappers.UserMapper;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService implements  IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper; 

    @Override
    public UserResponse create(UserRequest user) {
        User userEntity = userMapper.toEntity(user);
        User userCreated = userRepository.save(userEntity);
        return userMapper.toResponse(userCreated);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not Found"));
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new NotFoundException("User not Found"));
        if(user.getName() != null) existingUser.setName(user.getName());
        if(user.getPassword() != null) existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
