package com.example.marathon.controllers;

import com.example.marathon.dtos.CartDTO;
import com.example.marathon.dtos.ItemDTO;
import com.example.marathon.entities.Cart;
import com.example.marathon.entities.Item;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.ItemNotFoundException;
import com.example.marathon.services.CartService;
import com.example.marathon.services.ItemService;
import com.example.marathon.utils.DTOToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
/**
 * /carts
 */
public class CartController {
     @Autowired
    private CartService cartService;
@Autowired
     private ItemService itemService;

    @GetMapping
     public ResponseEntity hello(){
        return  new ResponseEntity("hello", HttpStatus.ACCEPTED);
     }

    /**
     *
     * @param cartDTO
     * @return
     */
    @PostMapping
  public ResponseEntity createCart (@RequestBody CartDTO cartDTO){
        System.out.println(cartDTO);

      Cart cart= DTOToEntityConverter.convertCartDTOtoCartEntity(cartDTO);
        System.out.println(cart);
      cart =cartService.createCart(cart);
      CartDTO cartResponse =DTOToEntityConverter.convertCartEntityToCartDTO(cart);

        return  new  ResponseEntity(cartResponse,HttpStatus.ACCEPTED);
  }
  @GetMapping("/{cart_id}")
 public ResponseEntity getCart(@PathVariable("cart_id") int cartId) throws CartNotFoundException {
        Cart cart =cartService.findByCartId(cartId);

        CartDTO cartResponsibility= DTOToEntityConverter.convertCartEntityToCartDTO(cart);

      return  new ResponseEntity(cartResponsibility,HttpStatus.OK);




  }


    /**
     * Add item in the cart
     */
@PostMapping("/{cart_id}/items")
  public  ResponseEntity addItemTOCart(@RequestBody ItemDTO itemDTO ,@PathVariable("cart_id") int cartId) throws CartNotFoundException, ItemNotFoundException {
     Item item= itemService.addItemToCart(DTOToEntityConverter.convertItemDTOTOItemEntity(itemDTO),cartId);

     Cart cart=itemService.getCartOfTheItem(item.getItemId());
    System.out.println(cart.toString());
     CartDTO cartDTO =DTOToEntityConverter.convertCartEntityToCartDTO(cart);
     return  new ResponseEntity(cartDTO,HttpStatus.ACCEPTED);

  }






}
