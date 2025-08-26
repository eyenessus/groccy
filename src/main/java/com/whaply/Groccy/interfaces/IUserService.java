package com.whaply.Groccy.interfaces;

import com.whaply.Groccy.dtos.requests.UserRequest;
import com.whaply.Groccy.dtos.responses.UserResponse;
import com.whaply.Groccy.infrastructure.entities.User;

public interface IUserService {
    UserResponse create(UserRequest user);
    User findByUsername(String username);
    void deleteByUsername(String username);
    User update(User user);
}
