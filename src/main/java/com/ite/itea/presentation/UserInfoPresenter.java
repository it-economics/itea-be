package com.ite.itea.presentation;

import com.ite.itea.application.usecase.GetUserInfoUseCase;
import com.ite.itea.domain.user.User;

public class UserInfoPresenter implements GetUserInfoUseCase.UserInfoPresenter {

    @Override
    public String formatUserInfo(User user) {
        return "Full name: " + user.firstname() + " " + user.lastname();
    }
}
