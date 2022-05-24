package com.Capstone.BankingApp.security.repository;

import com.Capstone.BankingApp.security.models.ERole;
import com.Capstone.BankingApp.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
