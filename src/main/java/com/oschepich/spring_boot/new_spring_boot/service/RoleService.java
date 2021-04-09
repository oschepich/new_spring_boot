package com.oschepich.spring_boot.new_spring_boot.service;

import com.oschepich.spring_boot.new_spring_boot.model.Role;

import java.util.List;

public interface RoleService<T>{

//    T getRoleById(Long id);

    Role getRoleByName(String name);

    public List<Role> getListRole();

}
