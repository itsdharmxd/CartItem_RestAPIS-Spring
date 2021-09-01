package com.example.marathon.services.impl;

import com.example.marathon.daos.ItemDao;
import com.example.marathon.entities.Cart;
import com.example.marathon.entities.Item;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.ItemNotFoundException;
import com.example.marathon.services.CartService;
import com.example.marathon.services.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ItemServiceImpl.class);

@Autowired
    private ItemDao itemDao;
@Autowired
      private CartService cartService;
    private Object ItemNotFoundException;

    @Override
    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException {
       LOGGER.debug("Debug");
        LOGGER.info("item added") ;

        Cart cart =cartService.findByCartId(cartId);

        item.setCart(cart);
        LOGGER.info("Returning");
return  itemDao.save(item);



    }

    @Override
    public List<Item> getItemsFromTHeCart(int cartId) throws CartNotFoundException {

        Cart cart = cartService.findByCartId(cartId);


       List<Item> items=  itemDao.findItemsByCart(cart);

       return  items;





    }

    @Override
    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException {

          Item item=itemDao.findById(itemId).orElseThrow(()->new ItemNotFoundException(""));
      Cart cart =item.getCart();
        return cart;
    }
}























