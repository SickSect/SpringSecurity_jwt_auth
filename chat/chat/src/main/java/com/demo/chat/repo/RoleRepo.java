package com.demo.chat.repo;

import com.demo.chat.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
    Optional<Role> findRoleByName(String name);
}
