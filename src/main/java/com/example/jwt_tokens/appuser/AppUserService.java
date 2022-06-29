package com.example.jwt_tokens.appuser;

import com.example.jwt_tokens.role.Role;
import com.example.jwt_tokens.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUserName(username)
                .orElseThrow(() -> new IllegalStateException("User " + username + "not found"));
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new IllegalStateException("Role " + roleName + "not found"));

        user.getRoles().add(role);
        appUserRepository.save(user);
    }

    public Optional<AppUser> getUser(String username) {
        return appUserRepository.findByUserName(username);
    }

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

}
