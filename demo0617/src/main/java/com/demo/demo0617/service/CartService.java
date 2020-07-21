package com.demo.demo0617.service;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.domain.CartRepository;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartService {

    private CartRepository cartRepository;

    @Transactional
    public List<Cart> findAll(){
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }

    public Cart findById(Long id){

        Optional<Cart> optional = cartRepository.findById(id);
        Cart cart = null;

        if(optional.isPresent()){
            cart = optional.get();
        }else{
            throw new RuntimeException("Cart not found for id : " + id);
        }
        return cart;

    }

    @Transactional
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

}
