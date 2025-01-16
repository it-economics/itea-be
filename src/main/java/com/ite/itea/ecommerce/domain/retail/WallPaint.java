package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public record WallPaint(
        WallPaintId id,
        String name,
        EuroPrice pricePerLiter,
        float amountPerArea,
        PaintUnit unit
) {
}
