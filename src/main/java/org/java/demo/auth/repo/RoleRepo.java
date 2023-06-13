package org.java.demo.auth.repo;

import org.java.demo.auth.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}