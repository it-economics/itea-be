package com.ite.itea.presentation;

import com.ite.itea.application.usecase.GetFullNameUseCase;
import com.ite.itea.domain.user.User;

public class FullNamePresenter implements GetFullNameUseCase.FullNamePresenter {

    @Override
    public String formatFullName(User user) {
        return "Full name: " + user.firstname() + " " + user.lastname();
    }
}
