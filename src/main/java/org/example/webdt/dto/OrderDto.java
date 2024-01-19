package org.example.webdt.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class OrderDto {
    private Long id;
    private UserDto user;
    private Long total;
    private String orderCode;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String order_status;
    private String payment;
    private Date created;
    private Date updated;
    private Set<OrderItemDto> orderItems = new HashSet<OrderItemDto>();

    public OrderDto() {
    }

    public OrderDto(Long id, UserDto user, Long total, String orderCode, String customerName, String customerAddress, String customerPhone, String customerEmail, String order_status, String payment, Date created, Date updated, Set<OrderItemDto> orderItems) {
        this.id = id;
        this.user = user;
        this.total = total;
        this.orderCode = orderCode;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.order_status = order_status;
        this.payment = payment;
        this.created = created;
        this.updated = updated;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
