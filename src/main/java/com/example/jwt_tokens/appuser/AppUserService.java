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

    public void saveUser(AppUser user) {
        appUserRepository.save(user);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public void addRoleToUser(AppUser user, Role role) {
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
