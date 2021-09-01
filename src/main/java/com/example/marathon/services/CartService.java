package com.example.marathon.services;

import com.example.marathon.entities.Cart;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.UserNameNotFoundException;

public interface CartService {
    //add a new  cart
    public Cart createCart(Cart cart);
//delete cart
    public  boolean deleteCart(int cartId);
    // find
   public  Cart findByCartId(int CartId) throws CartNotFoundException;


  public Cart findByUserName(String userName) throws UserNameNotFoundException;



}
