package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.resource.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	Boolean existsByPhonenumber(String phoneNumber);

	Boolean existsByUsernameAndStatus(String username, Boolean status);
}
