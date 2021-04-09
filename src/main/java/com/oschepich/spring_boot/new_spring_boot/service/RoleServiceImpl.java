package com.oschepich.spring_boot.new_spring_boot.service;

import com.oschepich.spring_boot.new_spring_boot.model.Role;
import com.oschepich.spring_boot.new_spring_boot.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }
//    @Override
//    public Role getRoleById(Long id) {
//        return (Role) this.roleDao.getRoleById(id);
//    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByRole(name);
    }

    @Override
    @Transactional
    public List<Role> getListRole() {
        return roleRepository.findAll();
    }


}
