package com.oschepich.spring_boot.new_spring_boot.service;



import com.oschepich.spring_boot.new_spring_boot.model.Role;
import com.oschepich.spring_boot.new_spring_boot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService<T>{
     List<T> getAllUser();

    void saveUser(User user);

//    void updateUser(Long id, String name, String email);

    void creatUser(User user);

    T show(Long id);

     void deleteUser(Long id);

//    T getRoleById(Long id);


    Role getRoleByName(String name);

    public List<Role> getListRole();

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
