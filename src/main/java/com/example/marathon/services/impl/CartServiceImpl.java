package com.example.marathon.services.impl;

import com.example.marathon.daos.CartDao;
import com.example.marathon.entities.Cart;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.UserNameNotFoundException;
import com.example.marathon.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

  @Autowired
 private CartDao cartDao;


    @Override
    public Cart createCart(Cart cart) {

          cartDao.save(cart);


        return cart;
    }

    @Override
    public boolean deleteCart(int cartId) {

        cartDao.deleteById(cartId);
        return false;
    }

    @Override
    public Cart findByCartId(int CartId) throws CartNotFoundException {

       Cart cart=   cartDao.findById(CartId).orElseThrow(()->new CartNotFoundException("cart not found"));

        return cart;
    }

  //  @Override
    public Cart findByUserName(String userName) throws UserNameNotFoundException {

        Cart cart= cartDao.findByCustomerName(userName);
        if(cart==null){
            throw new UserNameNotFoundException("name no found");
        }else {
          return  cart;
        }



    }
}
