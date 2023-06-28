package com.ite.itea.persistence.user;

import com.ite.itea.application.dto.UserDto;

public class UserMapper {

    public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.firstname(), userEntity.lastname(), userEntity.purchasedItems());
    }
}
