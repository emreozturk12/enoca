package com.example.enoca.Service;

import com.example.enoca.Model.Entity.Cart;
import com.example.enoca.Model.Entity.Product;
import com.example.enoca.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    CartRepository cartRepository;

    public Optional<Cart> getCart(Integer id) {
        return cartRepository.findById(id);
    }
    public void updateCart(Cart cart, Product product) {
        if (product.getStockNumber() > 0) {
            cartRepository.updateCart(cart);
        }
    }
    public void emptyCart() {
        cartRepository.deleteAll();
    }
    public void addProductToCart(Product product, Integer customerId, Integer cartId) {
        cartRepository.addProductToCart(product, customerId, cartId);
    }
    public void removeProductToCart(Integer id) {
        cartRepository.removeProductToCart(id);
    }
}
