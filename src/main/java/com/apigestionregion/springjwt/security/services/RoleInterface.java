package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleInterface {
    List<Role> lire();
}
