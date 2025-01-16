package com.ite.itea.ecommerce.usecase.soapmodel;

import com.ite.itea.ecommerce.domain.retail.Room;
import com.ite.itea.ecommerce.domain.retail.WallPaintId;
import com.ite.itea.ecommerce.usecase.port.WallPaintRepository;

public class CalculateRequiredWallPaintAmountUseCase {

    private final WallPaintRepository wallPaintRepository;

    public CalculateRequiredWallPaintAmountUseCase(WallPaintRepository wallPaintRepository) {
        this.wallPaintRepository = wallPaintRepository;
    }

    public float execute(Room room, WallPaintId wallPaintId) {
        var paint = wallPaintRepository.byId(wallPaintId).get();
        var wall = room.walls().get(0);
        var wallAreaInSquareMeters = wall.width() * wall.height();
        switch (paint.unit()) {
            case LITERS_PER_SQUARE_METER -> {
                var litersPerSquareMeter = paint.amountPerArea();
                var liters = litersPerSquareMeter * wallAreaInSquareMeters;
                return liters;
            }
            case GALLONS_PER_SQAURE_FOOT -> {
                var oneLiterInGallons = 0.2641720524f;
                var oneSquareMeterInSquareFeet = 10.7639104f;
                var gallonsPerSquareFoot = paint.amountPerArea();
                var wallAreaInSquareFeet = wallAreaInSquareMeters * oneSquareMeterInSquareFeet;
                var gallons = gallonsPerSquareFoot * wallAreaInSquareFeet;
                var liters = gallons * (1f / oneLiterInGallons);
                return liters;
            }
            default -> throw new IllegalStateException("Unexpected value: " + paint.unit());
        }
    }
}
