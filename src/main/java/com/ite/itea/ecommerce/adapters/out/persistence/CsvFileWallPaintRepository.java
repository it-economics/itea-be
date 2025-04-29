package com.ite.itea.ecommerce.adapters.out.persistence;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.domain.retail.PaintUnit;
import com.ite.itea.ecommerce.domain.retail.WallPaintId;
import com.ite.itea.ecommerce.domain.retail.WallPaint;
import com.ite.itea.ecommerce.usecase.port.WallPaintRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public class CsvFileWallPaintRepository implements WallPaintRepository {

    private final File wallPaintsFile;

    public CsvFileWallPaintRepository(File wallPaintsFile) {
        this.wallPaintsFile = wallPaintsFile;
    }

    @Override
    public Optional<WallPaint> byId(WallPaintId id) {
        return parse(wallPaintsFile).stream()
                .filter(wallPaint -> wallPaint.id().equals(id))
                .findFirst();
    }

    private List<WallPaint> parse(File usersFile) {
        try {
            return Files.readAllLines(usersFile.toPath()).stream()
                    .map(this::parseSingle)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private WallPaint parseSingle(String line) {
        var cells = line.split(",");
        var id = new WallPaintId(cells[0]);
        var name = cells[1];
        var price = parsePrice(cells[2]);
        var usagePerArea = Float.parseFloat(cells[3]);
        var unit = parseUnit(cells[4]);
        return new WallPaint(id, name, price, usagePerArea, unit);
    }

    private EuroPrice parsePrice(String string) {
        var eurosCents = string.split("\\.");
        var eurosPart = Integer.parseInt(eurosCents[0]);
        var centsPart = Integer.parseInt(eurosCents[1]);
        return EuroPrice.ofEurosAndCents(eurosPart, centsPart);
    }

    private PaintUnit parseUnit(String string) {
        return switch (string) {
            case "L/m²" -> PaintUnit.LITERS_PER_SQUARE_METER;
            case "gal/ft²" -> PaintUnit.GALLONS_PER_SQAURE_FOOT;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}
