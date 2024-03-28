package com.demo.chat.service;

import com.demo.chat.model.Role;
import com.demo.chat.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo repo;

    public Role findRoleByName(String name){
        if (name.equals("READER"))
            return repo.findRoleByName(name).get();
        return repo.findRoleByName(name).get();
    }
}
