package com.ite.itea.ecommerce.adapters.out.presenter;

import com.ite.itea.ecommerce.domain.user.User;

public class FullNamePresenter implements com.ite.itea.ecommerce.usecase.port.FullNamePresenter {

    @Override
    public String formatFullName(User user) {
        return "Full name: " + user.firstname() + " " + user.lastname();
    }
}
