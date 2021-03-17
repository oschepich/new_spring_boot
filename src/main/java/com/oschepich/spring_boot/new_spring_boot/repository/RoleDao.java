package com.oschepich.spring_boot.new_spring_boot.repository;



import com.oschepich.spring_boot.new_spring_boot.model.Role;

import java.util.List;

public interface RoleDao<T>{

//    T getRoleById(Long id);

    Role getRoleByName(String name) ;

    List<Role> getListRole();
}
