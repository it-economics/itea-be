package com.ite.itea.persistence;

import com.ite.itea.domain.dto.UserDto;
import com.ite.itea.persistence.entities.UserEntity;

public class ConverterEntityToDto {

    public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.firstname(), userEntity.lastname(), userEntity.purchasedItems());
    }
}
