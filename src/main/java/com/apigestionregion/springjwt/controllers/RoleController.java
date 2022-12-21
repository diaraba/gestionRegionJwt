package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Role;
import com.apigestionregion.springjwt.security.services.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/role")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class RoleController {
   @Autowired
    private final RoleInterface roleInterface;

    public RoleController(RoleInterface roleInterface) {
        this.roleInterface = roleInterface;
    }

    @GetMapping("/lire")
    public List<Role> LireRole() {
        return roleInterface.lire();
    }
}
