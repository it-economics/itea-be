package com.ite.itea.ecommerce.adapters.in.controller;

import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountRequest;
import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Tag(name="RoomPlanner")
public class RoomPlannerController {

    @Operation(summary = "determines required wall paint amount", description = "Helps determine the required amount of wall " +
            "paint based on room configuration and kind of paint")
    @ResponseBody
    @PostMapping(path = "/wallpaint",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WallPaintAmountResponse calculate(@RequestBody WallPaintAmountRequest request) {
        return new WallPaintAmountResponse(42.3f);
    }
}
