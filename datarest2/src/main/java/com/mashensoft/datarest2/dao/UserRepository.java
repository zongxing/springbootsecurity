package com.mashensoft.datarest2.dao;

import com.mashensoft.datarest2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
