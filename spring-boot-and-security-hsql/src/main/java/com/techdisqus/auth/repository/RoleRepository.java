package com.techdisqus.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techdisqus.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
