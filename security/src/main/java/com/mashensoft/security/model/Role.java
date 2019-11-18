package com.mashensoft.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer roleId;
    private String roleName;

    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role() {

    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
