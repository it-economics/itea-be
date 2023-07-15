package com.ite.itea.application.usecase;

import com.ite.itea.domain.user.User;
import com.ite.itea.domain.user.UserId;
import com.ite.itea.domain.user.UserRepository;
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

    public interface FullNamePresenter {
        String formatFullName(User user);
    }
}
