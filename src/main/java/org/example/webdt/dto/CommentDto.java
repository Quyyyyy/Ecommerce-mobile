package org.example.webdt.dto;


import java.util.Date;


public class CommentDto {
    private Long id;
    private ProductDto product;
    private UserDto user;
    private String review;
    private Integer star;
    private Date created;
    private Date updated;

    public CommentDto() {
    }

    public CommentDto(Long id, ProductDto product, UserDto user, String review, Integer star, Date created, Date updated) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.review = review;
        this.star = star;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
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
}
