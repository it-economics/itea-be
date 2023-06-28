package com.ite.itea.domain.user;

import com.ite.itea.application.dto.UserDto;

import java.util.List;

public interface UserRepository {

    List<UserDto> all();
    UserDto byLastName(String lastName);
}
