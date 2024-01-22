package org.example.webdt.services;

import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.UserDto;
import org.example.webdt.dto.request.ChangePassword;
import org.example.webdt.dto.request.RegisterRequest;
import org.example.webdt.dto.request.UserRequest;
import org.example.webdt.entities.RoleEntity;
import org.example.webdt.entities.UserEntity;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<RoleEntity> getRoles();
    Long getToTalUser();
    ResultResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
    UserDto createUser(UserRequest userRequest);
    String deleteUser(Long id);
    void register(RegisterRequest userRequest);
    UserEntity findByUsernameOrEmail(String username,String email);
    String editProfile(UserEntity user,UserRequest userRequest);
    String changePassword(UserEntity user,ChangePassword changePassword);
}
