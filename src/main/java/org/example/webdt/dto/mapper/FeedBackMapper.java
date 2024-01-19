package org.example.webdt.dto.mapper;

import org.example.webdt.dto.FeedBackDto;
import org.example.webdt.entities.FeedBackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeedBackMapper {
    FeedBackMapper MAPPER = Mappers.getMapper(FeedBackMapper.class);
    FeedBackDto mapToFeedBackDto(FeedBackEntity feedBack);
    FeedBackEntity mapToFeedBackEntity(FeedBackDto feedBackDto);
}
