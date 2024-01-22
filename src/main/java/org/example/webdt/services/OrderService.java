package org.example.webdt.services;

import org.example.webdt.dto.OrderDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.SaleData;
import org.example.webdt.entities.UserEntity;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    Long totalOrderNew();
    Long getTotalOrderMonth();
    Long getTotalIncome();
    List<SaleData> getOrderCountByDay();
    ResultResponse getAllOrders(int pageNo, int pageSize, String sortBy, String sortDir);
    OrderDto getOrderById(Long id);
    ResultResponse getAllOrdersByStatus(String status,int pageNo, int pageSize);
    OrderDto updateOrder(Long id,String status);
    ResultResponse getAllOrdersBYUsers(UserEntity user,int pageNo, int pageSize, String sortBy, String sortDir);
    ResultResponse getAllOrdersByUsersAndStatus(Long userId,String status,int pageNo, int pageSize, String sortBy, String sortDir);
}
