package com.zhangyiming.pojo;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.*;

public class User {//implements UserDetails {

    private Integer uid;
    private String username;
    private String password;
    private Integer age;
    private Date birthday;
    @Transient
    private Set<Role> roles = new HashSet<>();
    @Transient
    private Set<Module> modules = new HashSet<>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<>();
//        Set<Role> roles = this.getRoles();
//        for (Role role : roles) {
//            auths.add(new SimpleGrantedAuthority("ROLE_" + role.getRname()));
//        }
//        return auths;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(){
        this.age = 24;
        this.birthday = new Date();
    }
}