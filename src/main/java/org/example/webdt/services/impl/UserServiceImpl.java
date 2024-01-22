package org.example.webdt.services.impl;

import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.UserDto;
import org.example.webdt.dto.mapper.UserMapper;
import org.example.webdt.dto.request.ChangePassword;
import org.example.webdt.dto.request.RegisterRequest;
import org.example.webdt.dto.request.UserRequest;
import org.example.webdt.entities.RoleEntity;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.repositories.RoleEntityRepository;
import org.example.webdt.repositories.UserEntityRepository;
import org.example.webdt.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserEntityRepository userRepository;
    private RoleEntityRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserEntityRepository userRepository, RoleEntityRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return UserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<RoleEntity> getRoles() {
        List<RoleEntity> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public Long getToTalUser() {
        Long total = userRepository.getToTalUser();
        return total;
    }

    @Override
    public ResultResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<UserEntity> users = userRepository.findAll(pageable);
        List<UserEntity> userEntities = users.getContent();
        List<UserDto> contents = userEntities.stream()
                .map(user -> UserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(users.getNumber());
        resultResponse.setPageSize(users.getSize());
        resultResponse.setTotalElements(users.getTotalElements());
        resultResponse.setTotalPages(users.getTotalPages());
        resultResponse.setLast(users.isLast());
        return resultResponse;
    }

    @Override
    public UserDto createUser(UserRequest userDto) {
        UserEntity user = new UserEntity();
        if(userDto.getId()!=null){
            user = userRepository.findById(userDto.getId()).get();
        }
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setUsername(userDto.getUsername());
        if(userDto.getPassword()!=null){
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        Set<RoleEntity> roless = new HashSet<>();
        for(String ro: userDto.getRoles()){
            RoleEntity role = roleRepository.findById(Long.parseLong(ro)).get();
            roless.add(role);
        }
        user.setRoles(roless);
        UserEntity user1 = userRepository.save(user);
        return UserMapper.MAPPER.mapToUserDto(user1);
    }

    @Override
    public String deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        user.setStatus(false);
        userRepository.save(user);
        return "Xóa thành công";
    }

    @Override
    public void register(RegisterRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        Set<RoleEntity> roless = new HashSet<>();
        RoleEntity role = roleRepository.findByName("GUEST");
        roless.add(role);
        user.setRoles(roless);
        userRepository.save(user);
    }

    @Override
    public UserEntity findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username,email).orElse(null);
    }

    @Override
    public String editProfile(UserEntity user, UserRequest userRequest) {
        if(!user.getEmail().equals(userRequest.getEmail()) && !userRepository.existsByEmail(userRequest.getEmail())){
            user.setEmail(userRequest.getEmail());
        }
        if(!user.getEmail().equals(userRequest.getEmail()) && userRepository.existsByEmail(userRequest.getEmail())){
            return "email đã tồn tại";
        }
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        user.setAddress(userRequest.getAddress());
        UserEntity user1 =userRepository.save(user);
        return "cập nhật thành công";

    }

    @Override
    public String changePassword(UserEntity user, ChangePassword changePassword) {
        if (!passwordEncoder.matches(changePassword.getPassword(), user.getPassword())) {
            return "Mật khẩu không đúng";
        }
        if(!changePassword.getNew_pass().equals(changePassword.getNew1_pass())){
            return "password không trùng";
        }
        user.setPassword(passwordEncoder.encode(changePassword.getNew_pass()));
        UserEntity user1 =userRepository.save(user);
        return "cập nhật thanh công";
    }
}
