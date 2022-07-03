package com.example.jwt_tokens.appuser;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AppUser>> getUser() {
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/register").toUriString());
        return ResponseEntity.created(uri).body(appUserService.register(user));
    }
}
