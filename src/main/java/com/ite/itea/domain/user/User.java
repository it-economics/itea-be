package com.ite.itea.domain.user;

import java.util.List;

public record User(String firstname, String lastname, List<String> purchasedItems) {

    public String formatFullName() {
        return firstname() + " " + lastname();
    }
}
