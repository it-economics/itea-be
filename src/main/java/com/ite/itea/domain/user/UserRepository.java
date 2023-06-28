package com.ite.itea.domain.user;

import com.ite.itea.application.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<UserDto> all();
    Optional<UserDto> byLastName(String lastName);
}
