package org.example.webdt.dto.request;



public class ProductRequest {
    private Long id;
    private String title;
    private Long price;
    private Long discount;
    private String brand;
    private String details;
    private Integer quantity;
    private String symbol;
    private Integer pin;
    private Integer ram;
    private Integer rom;
    private String CPU;
    private String KTmanHinh;
    private String cameraTruoc;
    private String cameraSau;
    private Long categories;

    public ProductRequest() {
    }

    public ProductRequest(Long id, String title, Long price, Long discount, String brand, String details, Integer quantity, String symbol, Integer pin, Integer ram, Integer rom, String CPU, String KTmanHinh, String cameraTruoc, String cameraSau, Long categories) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.brand = brand;
        this.details = details;
        this.quantity = quantity;
        this.symbol = symbol;
        this.pin = pin;
        this.ram = ram;
        this.rom = rom;
        this.CPU = CPU;
        this.KTmanHinh = KTmanHinh;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCategories() {
        return categories;
    }

    public void setCategories(Long categories) {
        this.categories = categories;
    }
}
