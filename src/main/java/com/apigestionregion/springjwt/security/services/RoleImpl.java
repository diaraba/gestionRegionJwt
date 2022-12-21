package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Role;
import com.apigestionregion.springjwt.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleImpl implements RoleInterface {
    private final RoleRepository roleRepository;

    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> lire() {
        return roleRepository.findAll();
    }
}
