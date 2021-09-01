package com.example.marathon.utils;

import com.example.marathon.dtos.CartDTO;
import com.example.marathon.dtos.ItemDTO;
import com.example.marathon.entities.Cart;
import com.example.marathon.entities.Item;

import java.util.List;

public class DTOToEntityConverter {


    public  static Cart convertCartDTOtoCartEntity(CartDTO cartDTO){

         Cart cart =new Cart();

        cart.setCartId(cartDTO.getCartId());

        cart.setCustomerName(cartDTO.getCustomerName());
        cartDTO.getItems();
        List<ItemDTO> td=cartDTO.getItems();

        if(td!=null)
        for(int i=0;i<td.size();i++){

            convertItemDTOTOItemEntity( td.get(i));
           cart.getItems().add( convertItemDTOTOItemEntity( td.get(i)));
         }
      return  cart;
    }


    public static Item convertItemDTOTOItemEntity(ItemDTO item) {
      Item item1=new Item();
      item1.setItemDescription(item.getItemDescription());
      item1.setItemName(item.getItemDescription());
      item1.setItemId(item.getItemId());
        item1.setMfgDate(item.getMfgDate());
        item1.setCost(item.getCost());

        return item1;

    }

    public static  CartDTO convertCartEntityToCartDTO(Cart cartDTO){

        CartDTO cart =new CartDTO();

        System.out.println(cart.toString());

        cart.setCartId(cartDTO.getCartId());

        cart.setCustomerName(cartDTO.getCustomerName());

        if(cartDTO.getItems()!=null)
        for(Item item :cartDTO.getItems()){
            System.out.println(item.toString());
            cart.getItems().add( convertItemEntityToItemDTO( item));
        }
        System.out.println(cart.toString());
        return  cart;
    }

    public static ItemDTO convertItemEntityToItemDTO(Item item) {
        ItemDTO item1=new ItemDTO();

        item1.setItemDescription(item.getItemDescription());

        item1.setItemName(item.getItemDescription());

        item1.setItemId(item.getItemId());

        item1.setMfgDate(item.getMfgDate());

        item1.setCost(item.getCost());
        return item1;
    }



}
