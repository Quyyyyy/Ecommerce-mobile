package org.example.webdt.services.impl;

import jakarta.transaction.Transactional;
import org.example.webdt.dto.OrderDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.SaleData;
import org.example.webdt.dto.mapper.OrderMapper;
import org.example.webdt.entities.OrderEntity;
import org.example.webdt.entities.OrderItemEntity;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.repositories.OrderEntityRepository;
import org.example.webdt.repositories.OrderItemEntityRepository;
import org.example.webdt.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderEntityRepository orderRepository;
    private OrderItemEntityRepository orderItemRepository;

    public OrderServiceImpl(OrderEntityRepository orderRepository, OrderItemEntityRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity order = OrderMapper.MAPPER.mapToOrderEntity(orderDto);
        OrderEntity order1 = orderRepository.save(order);
        for(OrderItemEntity item:order1.getOrderItems()){
            item.setOrder(order1);
            orderItemRepository.save(item);
        }
        return OrderMapper.MAPPER.mapToOrderDto(order1);
    }

    @Override
    public Long totalOrderNew() {
        Long p = orderRepository.getTotalOrderNews();
        return p;
    }

    @Override
    public Long getTotalOrderMonth() {
        Long p = orderRepository.getTotalOrderByMonth();
        return p;
    }

    @Override
    public Long getTotalIncome() {
        Long totalPrice = orderRepository.getTotalRevenueForCurrentMonth();
        return totalPrice;
    }

    @Override
    public List<SaleData> getOrderCountByDay() {
        List<SaleData> list = orderRepository.getByMonth();
        return list;
    }

    @Override
    public ResultResponse getAllOrders(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<OrderEntity> orders = orderRepository.findAll(pageable);
        List<OrderEntity> orderEntities = orders.getContent();
        List<OrderDto> contents = orderEntities.stream()
                .map(order -> OrderMapper.MAPPER.mapToOrderDto(order)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(orders.getNumber());
        resultResponse.setPageSize(orders.getSize());
        resultResponse.setTotalElements(orders.getTotalElements());
        resultResponse.setTotalPages(orders.getTotalPages());
        resultResponse.setLast(orders.isLast());
        return resultResponse;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).get();
        return OrderMapper.MAPPER.mapToOrderDto(order);
    }

    @Override
    public ResultResponse getAllOrdersByStatus(String status,int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<OrderEntity> orders = orderRepository.findAllByStatus(status,pageable);
        List<OrderEntity> orderEntities = orders.getContent();
        List<OrderDto> contents = orderEntities.stream()
                .map(order -> OrderMapper.MAPPER.mapToOrderDto(order)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(orders.getNumber());
        resultResponse.setPageSize(orders.getSize());
        resultResponse.setTotalElements(orders.getTotalElements());
        resultResponse.setTotalPages(orders.getTotalPages());
        resultResponse.setLast(orders.isLast());
        return resultResponse;
    }

    @Override
    public OrderDto updateOrder(Long id, String status) {
        OrderEntity order = orderRepository.findById(id).get();
        order.setOrder_status(status);
        OrderEntity order1 = orderRepository.save(order);
        return OrderMapper.MAPPER.mapToOrderDto(order1);
    }

    @Override
    public ResultResponse getAllOrdersBYUsers(UserEntity user, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<OrderEntity> orders = orderRepository.findByUser(user,pageable);
        List<OrderEntity> orderEntities = orders.getContent();
        List<OrderDto> contents = orderEntities.stream()
                .map(order -> OrderMapper.MAPPER.mapToOrderDto(order)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(orders.getNumber());
        resultResponse.setPageSize(orders.getSize());
        resultResponse.setTotalElements(orders.getTotalElements());
        resultResponse.setTotalPages(orders.getTotalPages());
        resultResponse.setLast(orders.isLast());
        return resultResponse;
    }

    @Override
    public ResultResponse getAllOrdersByUsersAndStatus(Long userId, String status, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<OrderEntity> orders = orderRepository.findByUserAndOrder_status(userId,status,pageable);
        List<OrderEntity> orderEntities = orders.getContent();
        List<OrderDto> contents = orderEntities.stream()
                .map(order -> OrderMapper.MAPPER.mapToOrderDto(order)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(contents);
        resultResponse.setPageNo(orders.getNumber());
        resultResponse.setPageSize(orders.getSize());
        resultResponse.setTotalElements(orders.getTotalElements());
        resultResponse.setTotalPages(orders.getTotalPages());
        resultResponse.setLast(orders.isLast());
        return resultResponse;
    }
}
