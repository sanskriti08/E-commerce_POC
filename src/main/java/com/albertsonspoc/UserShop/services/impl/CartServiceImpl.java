package com.albertsonspoc.UserShop.services.impl;

import com.albertsonspoc.UserShop.dto.CartItem;
import com.albertsonspoc.UserShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.models.Status;
import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.CartRepository;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import com.albertsonspoc.UserShop.services.CartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	public void addToCart(int productId, String userName) {
		Product product =productRepository.findById(productId);
		User user = userRepository.findByUserName(userName);
		Cart cart = cartRepository.findByProductAndUser(product,user).orElse(new Cart());
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(cart.getQuantity()+1);
		cart.setPricePerUnit(product.getPrice());
		cart.setOrderPlaced(false);
		cartRepository.save(cart);

	}


	public  List<CartItem> getCartItem(String userName)
	{
		User user = userRepository.findByUserName(userName);
		return cartRepository.findByUser(user).stream().map((cart)->{return new CartItem(cart.getProduct().getName(),cart.getProduct().getPrice(),cart.getQuantity(),cart.getId());}).collect(Collectors.toList());
	}
	public Cart getCartItem(int id)
	{
		System.out.println("method running");
		return cartRepository.findById(id).orElse(null);
	}


		public void changeCount(boolean incrementFlag,int id )
		{
			Cart cart =cartRepository.findById(id).orElse(null);
			if (cart==null)
				return;
			cart.setQuantity(incrementFlag?cart.getQuantity()+1:cart.getQuantity()-1);
			cartRepository.save(cart);
		}

		public  void remove(int id)
		{
			Cart cart =cartRepository.findById(id).orElse(null);
			if (cart==null)
				return;
			cartRepository.delete(cart);
		}
	public void updateCart() {

	}

}

