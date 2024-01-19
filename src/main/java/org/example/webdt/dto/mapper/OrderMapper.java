package org.example.webdt.dto.mapper;

import org.example.webdt.dto.OrderDto;
import org.example.webdt.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
    OrderDto mapToOrderDto(OrderEntity order);
    OrderEntity mapToOrderEntity(OrderDto orderDto);
}
