package com.niit.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBackEnd.dao.CartLineDAO;
import com.niit.EcomBackEnd.dao.ProductDAO;
import com.niit.EcomBackEnd.dao.UserDAO;
import com.niit.EcomBackEnd.dto.Cart;
import com.niit.EcomBackEnd.dto.CartLine;
import com.niit.EcomBackEnd.dto.Product;
import com.niit.EcomBackEnd.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.EcomBackEnd");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
				
	}	
		
	@Test
	public void testAddNewCartLine() {
		
		// 1. getting the user
		user = userDAO.getByEmail("chetanpujary@gmail.com");
		
		// 2. fetching the cart
		cart = user.getCart();
		
		// 3. getting the product
		product = productDAO.get(1);
		
		// 4. creating a new cartline
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());

		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		// update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
	}
	
}
