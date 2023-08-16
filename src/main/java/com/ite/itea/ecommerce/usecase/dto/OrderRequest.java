package com.ite.itea.ecommerce.usecase.dto;

import java.util.List;

public record OrderRequest(List<ItemRequest> itemRequests) {

}
