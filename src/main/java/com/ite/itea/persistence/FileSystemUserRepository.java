package com.ite.itea.persistence;

import com.ite.itea.domain.user.User;
import com.ite.itea.domain.user.UserId;
import java.util.List;
import java.util.Optional;

public interface FileSystemUserRepository {

    List<User> all();
    Optional<User> byId(UserId id);
    Optional<User> byLastName(String lastName);
}
