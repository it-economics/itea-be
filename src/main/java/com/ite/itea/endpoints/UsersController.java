package com.ite.itea.endpoints;

import com.ite.itea.application.usecase.GetFullNameUseCase;
import com.ite.itea.domain.user.UserId;
import com.ite.itea.persistence.CsvFileUserRepository;
import com.ite.itea.presentation.FullNamePresenter;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class UsersController {

    private final GetFullNameUseCase getFullNameUseCase;

    UsersController() {
        URL usersFileUrl = getClass().getClassLoader().getResource("users.csv");
        String usersFilePath = Objects.requireNonNull(usersFileUrl).getFile();
        File usersFile = new File(URLDecoder.decode(usersFilePath, StandardCharsets.UTF_8));

        getFullNameUseCase = new GetFullNameUseCase(
                new CsvFileUserRepository(usersFile),
                new FullNamePresenter()
        );
    }

    @GetMapping(path = "/user/{id}/fullname")
    @ResponseBody
    public String getFullNameByUserId(@PathVariable String id) {
        return getFullNameUseCase.execute(new UserId(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
