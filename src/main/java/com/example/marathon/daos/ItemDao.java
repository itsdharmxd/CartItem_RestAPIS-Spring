package com.example.marathon.daos;

import com.example.marathon.entities.Cart;
import com.example.marathon.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDao extends JpaRepository<Item,Integer> {
       public List<Item> findItemsByCart(Cart cart);
}
