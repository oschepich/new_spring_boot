package com.oschepich.spring_boot.new_spring_boot.repository;

import com.oschepich.spring_boot.new_spring_boot.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public Role getRoleById(Long id) {
//        Role role = entityManager.find(Role.class, new Long(id));
//        entityManager.detach(role);
//        return role;
//    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from  Role role where role.role =: name",Role.class)
                .setParameter("name",name)
                .getSingleResult();
    }

    @Override
    public List<Role> getListRole() {
        return entityManager.createQuery("from Role").getResultList();
    }
}