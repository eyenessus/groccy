package com.whaply.Groccy.interfaces;

import com.whaply.Groccy.infrastructure.entities.User;

public interface IUserService {
    int create(User user);
    User findByUsername(String username);
    void deleteByUsername(String username);
    User update(User user);
}
