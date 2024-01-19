package org.example.webdt.dto.mapper;

import org.example.webdt.dto.UserDto;
import org.example.webdt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto mapToUserDto(UserEntity user);
    UserEntity mapToUserEntity(UserDto userDto);
}
