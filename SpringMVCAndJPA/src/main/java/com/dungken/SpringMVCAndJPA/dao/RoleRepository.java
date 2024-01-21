package com.dungken.SpringMVCAndJPA.dao;

import com.dungken.SpringMVCAndJPA.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
