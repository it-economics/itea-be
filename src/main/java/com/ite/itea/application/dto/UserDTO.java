package com.ite.itea.application.dto;

import java.util.List;

public record UserDTO(String firstname, String lastname, List<String> purchasedItems) {

    public String formatUserToString() {
        return firstname() + " " + lastname();
    }
}
