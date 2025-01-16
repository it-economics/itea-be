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
        var paint = wallPaintRepository.byId(wallPaintId);
        var wall = room.walls().get(0);
        var wallArea = wall.width() * wall.height();
        var requiredPaint = paint.get().amountPerArea() * wallArea;
        return requiredPaint;
    }
}
