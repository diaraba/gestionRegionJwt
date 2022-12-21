package com.apigestionregion.springjwt.repository;

import java.util.Optional;

import com.apigestionregion.springjwt.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apigestionregion.springjwt.models.ERole;
import com.apigestionregion.springjwt.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
  Role findByName(String name);

}
