package com.ite.itea.ecommerce.usecase.port;

import com.ite.itea.ecommerce.domain.user.User;
import com.ite.itea.ecommerce.domain.user.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> all();
    Optional<User> byId(UserId id);
    Optional<User> byLastName(String lastName);
}
