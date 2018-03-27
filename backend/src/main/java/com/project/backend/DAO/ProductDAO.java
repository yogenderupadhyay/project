package com.project.backend.DAO;

import java.util.List;

import com.project.backend.domain.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public Product get(String id);
	public boolean delete(String id);
	public List<Product> list();
}
