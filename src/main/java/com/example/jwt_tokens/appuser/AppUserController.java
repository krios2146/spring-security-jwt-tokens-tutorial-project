package com.example.jwt_tokens.appuser;

import com.example.jwt_tokens.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<AppUser>> getUser() {
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping(path = "/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(user));
    }

    @PostMapping(path = "/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping(path = "/role/add-role-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody String username, String roleName) {
        appUserService.addRoleToUser(username, roleName);
        return ResponseEntity.ok().build();
    }
}
