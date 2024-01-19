package org.example.webdt.dto;

import org.example.webdt.entities.RoleEntity;

import java.util.Date;
import java.util.Set;

public class UserDto {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String username;
    private Boolean status;
    private Date created;
    private Date updated;
    private Set<RoleEntity> roles;
    private Set<OrderDto> orders;

    public UserDto() {
    }

    public UserDto(Long id, String name, String address, String email, String phone, String username, Boolean status, Date created, Date updated, Set<RoleEntity> roles, Set<OrderDto> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.roles = roles;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }
}
