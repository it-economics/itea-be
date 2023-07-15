package com.ite.itea.application.usecase;

import com.ite.itea.domain.user.User;
import com.ite.itea.domain.user.UserId;
import com.ite.itea.domain.user.UserRepository;
import java.util.Optional;

public class GetUserInfoUseCase {

    private final UserRepository userRepository;
    private final UserInfoPresenter userInfoPresenter;

    public GetUserInfoUseCase(UserRepository userRepository, UserInfoPresenter userInfoPresenter) {
        this.userRepository = userRepository;
        this.userInfoPresenter = userInfoPresenter;
    }

    public Optional<String> execute(UserId id) {
        final var user = userRepository.byId(id);
        return user.map(userInfoPresenter::formatUserInfo);
    }

    public interface UserInfoPresenter {
        String formatUserInfo(User user);
    }
}
