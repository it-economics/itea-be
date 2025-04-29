package com.ite.itea.ecommerce.adapters.in.controller;

import com.ite.itea.ecommerce.adapters.out.persistence.CsvFileWallPaintRepository;
import com.ite.itea.ecommerce.domain.retail.WallPaintId;
import com.ite.itea.ecommerce.usecase.dto.Room;
import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountRequest;
import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountResponse;
import com.ite.itea.ecommerce.usecase.soapmodel.CalculateRequiredWallPaintAmountUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
@Tag(name="RoomPlanner")
public class RoomPlannerController {

    private final CalculateRequiredWallPaintAmountUseCase calculateRequiredWallPaintAmount =
            new CalculateRequiredWallPaintAmountUseCase(
                    new CsvFileWallPaintRepository(
                            new File(URLDecoder.decode(
                                    getClass().getClassLoader().getResource("wallpaints.csv").getFile(),
                                    StandardCharsets.UTF_8))
                    )
            );

    @Operation(summary = "determines required wall paint amount", description = "Helps determine the required amount of wall " +
            "paint based on room configuration and kind of paint")
    @ResponseBody
    @PostMapping(path = "/wallpaint",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WallPaintAmountResponse calculate(@RequestBody WallPaintAmountRequest request) {
        var room = mapToDomain(request.room());
        var requiredPaint = calculateRequiredWallPaintAmount.execute(room, new WallPaintId(request.paintProductId()));
        return new WallPaintAmountResponse(requiredPaint);
    }

    private com.ite.itea.ecommerce.domain.retail.Room mapToDomain(Room room) {
        var walls = room.walls().stream()
                .map(it -> new com.ite.itea.ecommerce.domain.retail.Room.Wall(it.width(), it.height()))
                .toList();
        return new com.ite.itea.ecommerce.domain.retail.Room(walls);
    }
}
