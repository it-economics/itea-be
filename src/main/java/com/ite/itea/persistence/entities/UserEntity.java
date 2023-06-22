package com.ite.itea.persistence.entities;

import java.util.List;

public record UserEntity(String firstname, String lastname, List<String> purchasedItems) {
}
