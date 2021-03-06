package com.mashensoft.security.dao;

import com.mashensoft.security.model.Role;
import com.mashensoft.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select r.* from ms_user u,role r,user_role ur where u.user_id=ur.user_id and r.role_id=ur.role_id and  u.username=:username",nativeQuery = true)
    public List<Role> findRoles(@Param("username") String username);
}
