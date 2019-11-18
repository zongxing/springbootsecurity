package com.mashensoft.security.service;

import com.mashensoft.security.dao.RoleRepository;
import com.mashensoft.security.dao.UserRepository;
import com.mashensoft.security.model.Role;
import com.mashensoft.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MsUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        org.springframework.security.core.userdetails.User userSpring = null;
        if(user!=null){
          List<Role>  roleList = roleRepository.findRoles(username);
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
          if(roleList!=null&&roleList.size()>0){
              roleList.forEach(role->{
                  authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
              });
//              PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//              String passwordAfterEncoder = passwordEncoder.encode(user.getPassword());
              userSpring = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
          }
        }
        return userSpring;
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this);

    }
}
