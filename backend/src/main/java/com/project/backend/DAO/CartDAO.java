package com.project.backend.DAO;

import java.util.List;

import com.project.backend.domain.Cart;

public interface CartDAO {
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean update(String emailID);
	public boolean update(String productID, int qty);
	public Cart get(int id);
	public boolean delete(int id);
	public List<Cart> list(String emailID, char status);
	public List<Cart> list(String emailID);
}
