package com.ite.itea.domain.request;

import com.ite.itea.domain.dto.ChairsDto;
import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.Material;
import com.ite.itea.domain.dto.TablesDto;

public enum ItemNameRequest {
    Chair(new ChairsDto(2000, 4000, 2999, 4, Material.WOOD)),
    ChairLars(new ChairsDto(1000L, 2000L, 3000L, 5, Material.METAL)),
    ChairKnut(new ChairsDto(1200L, 1000L, 1500L, 3, Material.WOOD)),
    ChairElsa(new ChairsDto(2000L, 500L, 500L, 4, Material.PLASTIC)),
    TableLotta(new TablesDto(1000L, 3000L, Material.PLASTIC)),
    TableLola(new TablesDto(2000L, 5000L, Material.WOOD)),

    Picture(new ChairsDto(2000, 4000, 2999, 4, Material.WOOD));




    private final ItemDto itemDto;

    private ItemNameRequest(ItemDto itemDto){
        this.itemDto = itemDto;
    }


}
