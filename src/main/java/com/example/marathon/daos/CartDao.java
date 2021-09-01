package com.example.marathon.daos;

import com.example.marathon.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
    public  Cart findByCustomerName(String username);
}
