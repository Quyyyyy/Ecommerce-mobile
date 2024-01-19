package org.example.webdt.dto;


public class CartItem {
    private ProductDto product;
    private Integer quantity;
    private Long price;

    public CartItem() {
    }

    public CartItem(ProductDto product, Integer quantity, Long price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
