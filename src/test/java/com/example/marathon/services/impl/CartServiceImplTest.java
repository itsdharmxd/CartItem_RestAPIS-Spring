package com.example.marathon.services.impl;


import com.example.marathon.daos.CartDao;
import com.example.marathon.entities.Cart;
import com.example.marathon.exceptions.CartNotFoundException;
import com.example.marathon.exceptions.UserNameNotFoundException;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CartServiceImplTest {

    @Mock
    CartDao cartDaoMock ;

    @InjectMocks
    CartServiceImpl cartService ;


    /**
     * Test for createCart
     */
    @Test
    public void testCreateCart(){
        // Create the data
        Cart cart = new Cart();
        cart.setCustomerName("Vishwa Mohan");

        Cart cart1 = new Cart();
        cart1.setCustomerName("Vishwa Mohan");
        cart1.setCartId(1);


        // Give the functionality to the mock
        Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

        //Execute
        Cart savedCart = cartService.createCart(cart);


        //Testing
        Assertions.assertNotNull(savedCart);
        Assertions.assertEquals(1, savedCart.getCartId());



    }

    /**
     * Test for deleteCart
     */
    @Test
    public void testDeleteCart(){

        //Data


        //Mock  -- When we have to mock a method that returns nothing
        Mockito.doNothing().when(cartDaoMock).deleteById(1);

        //Execution

        //Assertion

    }




    /**
     * Test for findByCartId
     */
    @Test
    public void testFindByCartId() throws CartNotFoundException {
        //Data
        Cart cart1 = new Cart();
        cart1.setCustomerName("Vishwa Mohan");
        cart1.setCartId(1);
        //Mock
        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1));



        //Execution
        Cart cart = cartService.findByCartId(1);


        //Assertion
        Assertions.assertNotNull(cart);
        Assertions.assertEquals("Vishwa Mohan" , cart.getCustomerName());
    }

    @Test
    public void testFindByCartIdThrowsExceptions() throws CartNotFoundException {
        //Data
        Cart cart1 = new Cart();
        cart1.setCustomerName("Vishwa Mohan");
        cart1.setCartId(1);

        //Mock
        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());

        //Execution
        try {
            Cart cart = cartService.findByCartId(1);
        }catch (Exception e){
            Assertions.assertEquals(CartNotFoundException.class , e.getClass());
        }
    }




    /**
     * Test for findByCustomerName
     */

    @Test
    public void testFindByCustomerName() throws UserNameNotFoundException{
        Cart cart1 = new Cart();
        cart1.setCustomerName("Vishwa Mohan");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findByCustomerName("Vishwa Mohan")).thenReturn(cart1);

        //Execution
        Cart cart = cartService.findByUserName("Dharmes");


        //Assertion
        Assertions.assertNotNull(cart);
        Assertions.assertEquals("Vishwa Mohan" , cart.getCustomerName());



    }


}


