package com.oschepich.spring_boot.new_spring_boot.repository;



import com.oschepich.spring_boot.new_spring_boot.model.User;

import java.util.List;

public interface UserDao <T>{
    List<T> getAllUser();

    void saveUser(User user);

//    void updateUser(Long id, String name, String email);

    T show(Long id);

    void deleteUser(Long id);

    T getUserByUsername(String username);

}
