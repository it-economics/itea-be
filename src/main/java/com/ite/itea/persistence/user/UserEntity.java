package com.ite.itea.persistence.user;

import java.util.List;

public record UserEntity(String firstname, String lastname, List<String> purchasedItems) {
}
