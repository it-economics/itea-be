package com.ite.itea.presentation.request;

import java.util.List;

public record OrderRequest(List<ItemRequest> itemRequests) {

}
