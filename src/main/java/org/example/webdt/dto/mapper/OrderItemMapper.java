package org.example.webdt.dto.mapper;

import org.example.webdt.dto.OrderItemDto;
import org.example.webdt.entities.OrderItemEntity;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper MAPPER = Mappers.getMapper(OrderItemMapper.class);
    OrderItemDto mapToOrderItemDto(OrderItemEntity orderItemEntity);
    OrderItemEntity mapToOrderItemEntity(OrderItemDto orderItemDto);
}
