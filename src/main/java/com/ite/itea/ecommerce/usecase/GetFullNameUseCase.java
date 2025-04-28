package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.user.UserId;
import com.ite.itea.ecommerce.usecase.port.FullNamePresenter;
import com.ite.itea.ecommerce.usecase.port.UserRepository;

import java.util.Optional;

public class GetFullNameUseCase {

    private final UserRepository userRepository;
    private final FullNamePresenter fullNamePresenter;

    public GetFullNameUseCase(UserRepository userRepository, FullNamePresenter fullNamePresenter) {
        this.userRepository = userRepository;
        this.fullNamePresenter = fullNamePresenter;
    }

    public Optional<String> execute(UserId id) {
        final var user = userRepository.byId(id);
        return user.map(fullNamePresenter::formatFullName);
    }
}
