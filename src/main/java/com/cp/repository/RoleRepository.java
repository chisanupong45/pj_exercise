package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
