package com.ite.itea.domain.request;

import java.util.List;

public record OrderRequest(List<ItemRequest> itemRequests) {

}
