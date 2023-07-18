package com.ite.itea.application.dto;

import java.util.List;

public record OrderRequest(List<ItemRequest> itemRequests) {

}
