package com.mashensoft.datarest.dao;

import com.mashensoft.datarest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
