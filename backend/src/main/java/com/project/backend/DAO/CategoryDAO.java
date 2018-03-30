package com.project.backend.DAO;

import java.util.List;

import com.project.backend.domain.Cart;
import com.project.backend.domain.Category;

public interface CategoryDAO {
	public boolean save(Category category);
	public boolean update(Category category);
	public Category get(String id);
	public boolean delete(String id);
	public List<Category> list();
}
