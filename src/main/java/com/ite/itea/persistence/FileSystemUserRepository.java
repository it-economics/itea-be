package com.ite.itea.persistence;

import com.ite.itea.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface FileSystemUserRepository {

    List<User> all();
    Optional<User> byLastName(String lastName);
}
