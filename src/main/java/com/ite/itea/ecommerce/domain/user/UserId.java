package com.ite.itea.ecommerce.domain.user;

import java.util.UUID;

public record UserId(String internalID) {

    public static UserId random() {
        return new UserId(UUID.randomUUID().toString());
    }
}
