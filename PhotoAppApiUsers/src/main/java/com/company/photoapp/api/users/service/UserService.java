package com.company.photoapp.api.users.service;

import com.company.photoapp.api.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
