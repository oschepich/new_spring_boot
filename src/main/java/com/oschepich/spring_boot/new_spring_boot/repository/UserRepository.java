package com.oschepich.spring_boot.new_spring_boot.repository;

import com.oschepich.spring_boot.new_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findUserByEmail(String email);

}
