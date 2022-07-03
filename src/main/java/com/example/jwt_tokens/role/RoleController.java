package com.example.jwt_tokens.role;

import com.example.jwt_tokens.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final AppUserService appUserService;

    @PostMapping(path = "/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleService.saveRole(role));
    }

    @PostMapping(path = "/add-role-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody String username, String roleName) {
        appUserService.addRoleToUser(username, roleName);
        return ResponseEntity.ok().build();
    }
}
