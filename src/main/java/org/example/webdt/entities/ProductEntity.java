package org.example.webdt.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class ProductEntity extends BaseEntity{
    private String title;
    private Long price;
    private Long discount;
    private String brand;
    private String details;
    private Integer quantity;
    private String avatar;
    private String symbol;
    private Integer pin;
    private Integer ram;
    private Integer rom;
    private String CPU;
    private String KTmanHinh;
    private String cameraTruoc;
    private String cameraSau;
    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoriesEntity categories;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImageEntity> productImageEntitySet = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getKTmanHinh() {
        return KTmanHinh;
    }

    public void setKTmanHinh(String KTmanHinh) {
        this.KTmanHinh = KTmanHinh;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public CategoriesEntity getCategories() {
        return categories;
    }

    public void setCategories(CategoriesEntity categories) {
        this.categories = categories;
    }

    public List<ProductImageEntity> getProductImageEntitySet() {
        return productImageEntitySet;
    }

    public void setProductImageEntitySet(List<ProductImageEntity> productImageEntitySet) {
        this.productImageEntitySet = productImageEntitySet;
    }
}
