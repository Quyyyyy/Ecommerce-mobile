package org.example.webdt.controller;

import org.example.webdt.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class BaseController {
    protected boolean isLogined(){
        boolean isLogined = false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            isLogined = true;
        }
        return isLogined;
    }

    protected UserEntity userLogined(){
        Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userLogined != null && userLogined instanceof UserDetails) {
            return (UserEntity) userLogined;
        }
        return new UserEntity();
    }
}
