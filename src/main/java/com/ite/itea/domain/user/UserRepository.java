package com.ite.itea.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> all();
    Optional<User> byLastName(String lastName);
}
