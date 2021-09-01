package com.example.marathon.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    @JsonProperty("cart_id")
  private int cartId;

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                '}';
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public CartDTO() {
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public CartDTO(int cartId, String customerName, List<ItemDTO> items) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.items = items;
    }

    @JsonProperty("customer_name")
    private  String customerName;

       @JsonProperty("cart_items")
    private List<ItemDTO> items=new ArrayList<ItemDTO>();
}
