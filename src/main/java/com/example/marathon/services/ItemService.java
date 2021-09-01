package com.example.marathon.services;

import com.example.marathon.entities.Cart;
import com.example.marathon.entities.Item;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {

     public  Item addItemToCart(Item item, int cartId) throws CartNotFoundException;
     public List<Item> getItemsFromTHeCart(int cartId) throws CartNotFoundException;

     public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;



}
