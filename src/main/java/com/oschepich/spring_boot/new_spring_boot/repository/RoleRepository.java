package com.oschepich.spring_boot.new_spring_boot.repository;

import com.oschepich.spring_boot.new_spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRole(String role);
}
