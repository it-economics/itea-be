package com.ite.itea.endpoints;

import com.ite.itea.application.usecase.GetUserInfoUseCase;
import com.ite.itea.domain.user.UserId;
import com.ite.itea.persistence.FileSystemUserRepositoryImpl;
import com.ite.itea.presentation.UserInfoPresenter;
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

    private final GetUserInfoUseCase userInfoUseCase;

    UsersController() {
        URL usersFileUrl = getClass().getClassLoader().getResource("users.csv");
        String usersFilePath = Objects.requireNonNull(usersFileUrl).getFile();
        File file = new File(URLDecoder.decode(usersFilePath, StandardCharsets.UTF_8));

        userInfoUseCase = new GetUserInfoUseCase(
                new FileSystemUserRepositoryImpl(file),
                new UserInfoPresenter()
        );
    }

    @GetMapping(path = "/user/{id}/fullname")
    @ResponseBody
    public String getFullNameByUserId(@PathVariable String id) {
        return userInfoUseCase.execute(new UserId(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
