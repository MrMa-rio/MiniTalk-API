package com.marsn.minitalkapi.entrypoint.auth;

import com.marsn.minitalkapi.entrypoint.auth.dto.UserPasswordRequestDTO;
import com.marsn.minitalkapi.entrypoint.auth.dto.UserPasswordResponseDTO;
import com.marsn.minitalkapi.entrypoint.shared.PathsController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(PathsController.TOKEN_TAG)
@RequestMapping(PathsController.TOKEN_PATH)
public class LoginController {


    @PostMapping(PathsController.GENERATE_TOKEN_PATH)
    public ResponseEntity<UserPasswordResponseDTO> generateToken(
            @RequestBody UserPasswordRequestDTO dto) {


        return ResponseEntity.ok().body(
                new UserPasswordResponseDTO("_TOKEN_")
        );
    }


}
