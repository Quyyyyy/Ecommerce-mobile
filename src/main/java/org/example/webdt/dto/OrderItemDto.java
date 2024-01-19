package org.example.webdt.dto;



public class OrderItemDto {
    private ProductDto product;
    private Integer quantity;
    private Long priceBuy;

    public OrderItemDto() {
    }

    public OrderItemDto(ProductDto product, Integer quantity, Long priceBuy) {
        this.product = product;
        this.quantity = quantity;
        this.priceBuy = priceBuy;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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
}
