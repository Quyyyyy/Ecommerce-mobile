package org.example.webdt.dto;


import java.util.ArrayList;
import java.util.List;


public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    public Cart() {
    }
    public Cart(List<CartItem> items) {
        this.items = items;
    }

}
