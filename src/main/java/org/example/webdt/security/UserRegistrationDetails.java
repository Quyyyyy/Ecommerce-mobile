package org.example.webdt.security;

import org.example.webdt.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRegistrationDetails implements UserDetails {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private Boolean isEnabled;
    private Set<GrantedAuthority> authorities;

    public UserRegistrationDetails(UserEntity user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isEnabled = user.getStatus();
        this.authorities = user.getRoles().stream()
                .map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
