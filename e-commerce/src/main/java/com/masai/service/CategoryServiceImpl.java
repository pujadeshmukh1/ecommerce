package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo cr;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		return cr.save(category);
	}

	@Override
	public Category viewCategory(int categoryId) throws CategoryException {
		Optional<Category> c=cr.findById(categoryId);
		if(c.isPresent()) {
			return c.get();
		}
		throw new CategoryException("category not found with id "+categoryId);
	}

	@Override
	public Category deleteCategory(int categoryId) throws CategoryException {
		Optional<Category> c=cr.findById(categoryId);
		if(c.isPresent()) {
			cr.delete(c.get());
			return c.get();
		}
		throw new CategoryException("category not found with id "+categoryId);
	}

	@Override
	public List<Category> allCategory() throws CategoryException {
		List<Category>list=cr.findAll();
		if(list.size()==0) {
			throw new CategoryException("list empty");
		}
		return list;
	}

	@Override
	public List<Product> productByCategory(int categoryId) throws CategoryException {
		Optional<Category> c=cr.findById(categoryId);
		if(c.isPresent()) {
			return c.get().getProducts();
		}
		throw new CategoryException("category not found with id "+categoryId);
	}

}
