package com.magellans.cardtrading.repository;


import com.magellans.cardtrading.resource.model.ERole;
import com.magellans.cardtrading.resource.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
