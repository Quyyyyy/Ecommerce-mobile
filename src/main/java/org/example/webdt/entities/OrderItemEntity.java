package org.example.webdt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItemEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;
    private Integer quantity;
    private Long priceBuy;
    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity order;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Long priceBuy) {
        this.priceBuy = priceBuy;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
