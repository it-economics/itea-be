package com.ite.itea.ecommerce.domain.retail;

public enum ProductName {
    PICTURE_FINLAND("Picture \"Finland\""),
    PICTURE_NORWAY("Picture \"Norway\""),
    PICTURE_SWEDEN("Picture \"Sweden\""),
    CHAIR_OLAF("Chair \"Olaf\""),
    CHAIR_LARS("Chair \"Lars\""),
    CHAIR_KNUT("Chair \"Knut\""),
    TABLE_LOTTA("Table \"Lotta\""),
    TABLE_LOLA("Table \"Lola\""),
    WARDROBE_INGEBORG("Wardrobe \"Ingeborg\"");

    private final String displayName;

    ProductName(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
