package org.example.webdt.dto.mapper;

import org.example.webdt.dto.CommentDto;
import org.example.webdt.entities.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);
    @Mapping(source = "user", target = "user")
    CommentDto mapToCommentDto(CommentEntity comment);
    @Mapping(source = "user", target = "user")
    CommentEntity mapToCommentEntity(CommentDto commentDto);
}
