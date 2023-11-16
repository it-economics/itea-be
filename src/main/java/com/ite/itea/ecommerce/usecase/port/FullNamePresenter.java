package com.ite.itea.ecommerce.usecase.port;

import com.ite.itea.ecommerce.domain.user.User;

public interface FullNamePresenter {
    String formatFullName(User user);
}
