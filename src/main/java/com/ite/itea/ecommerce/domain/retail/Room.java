package com.ite.itea.ecommerce.domain.retail;

import java.util.List;

public record Room(List<Wall> walls) {

    public record Wall(float width, float height) {
    }
}
