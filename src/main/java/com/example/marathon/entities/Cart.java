package com.example.marathon.entities;



import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                '}';
    }

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    @Column(nullable = false, unique = false)
    private String customerName;

    public Cart(int cartId, String customerName, List<Item> items) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "cart")
    private List<Item> items ;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String  getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
