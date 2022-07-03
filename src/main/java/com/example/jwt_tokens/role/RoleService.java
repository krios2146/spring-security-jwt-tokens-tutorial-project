package com.example.jwt_tokens.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
