package com.ite.itea.ecommerce.usecase.port;

import com.ite.itea.ecommerce.domain.retail.WallPaint;
import com.ite.itea.ecommerce.domain.retail.WallPaintId;

import java.util.Optional;

public interface WallPaintRepository {

    Optional<WallPaint> byId(WallPaintId id);
}
