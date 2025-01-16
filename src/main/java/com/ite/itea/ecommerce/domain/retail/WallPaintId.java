package com.ite.itea.ecommerce.domain.retail;

import java.util.UUID;

public record WallPaintId(String internalID) {

    public static WallPaintId random() {
        return new WallPaintId(UUID.randomUUID().toString());
    }
}
