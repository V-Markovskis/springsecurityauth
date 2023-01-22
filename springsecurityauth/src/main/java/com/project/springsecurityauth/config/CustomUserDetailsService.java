package com.project.springsecurityauth.config;


import com.project.springsecurityauth.model.Role;
import com.project.springsecurityauth.model.UserEntity;
import com.project.springsecurityauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//we don't want to use implementation that is provided by
//Spring Security. We want to create our own
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //We are going into the DB => we need UserDetailsService => we need to return UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load by username
        //go into DB - into UserRepository => return user
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        //user.getRoles (we need to pass in granted authorities but these are actually roles)
        //granted authorities housed within roles
        //granted authorities are more granular form of Roles
        //we need to convert Roles into granted authorities
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        //for each role we are going to turn them into Authority(SimpleGrantedAuthority())
        //.collect(Collectors.toList()) => means turn it into a list =>
        //list that we can then pass in to => user.getRoles()
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
