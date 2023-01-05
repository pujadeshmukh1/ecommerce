package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepo;
import com.masai.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo pr;
	
	@Autowired
	private CategoryRepo crepo;

	@Override
	public Product addProduct(Product product, int categoryId) throws ProductException, CategoryException {
		Optional<Category> cat=crepo.findById(categoryId);
		if(!cat.isPresent()) {
			throw new CategoryException("category not found with id "+categoryId);
		}
		Category category=cat.get();
		category.getProducts().add(product);
		
		product.setCategory(category);
		
		crepo.save(category);
		
		return product;
	}

	@Override
	public Product viewProduct(int productId) throws ProductException {
		Optional<Product>p=pr.findById(productId);
		if(p.isPresent()) {
			return p.get();
		}
		throw new ProductException("product not found with id "+productId);
	}

	@Override
	public List<Product> allProduct() throws ProductException {
		List<Product>list=pr.findAll();
		if(list.size()==0) {
			throw new ProductException("list is empty");
		}
		return list;
	}

	@Override
	public Product removeProduct(int productId) throws ProductException {
		Optional<Product>p=pr.findById(productId);
		if(p.isPresent()) {
			p.get().setCategory(null);
			pr.delete(p.get());
			return p.get();
		}
		throw new ProductException("product not found with id "+productId);
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		Optional<Product>p=pr.findById(product.getProductId());
		if(p.isPresent()) {
			Product pro=p.get();
			
			if(product.getDescription()!=null)
				pro.setDescription(product.getDescription());
			
			if(product.getPrice()!=null)
				pro.setPrice(product.getPrice());
			
			if(product.getProductName()!=null)
				pro.setProductName(product.getProductName());
			
			if(product.getQuantity()!=null)
				pro.setQuantity(product.getQuantity());
			
			return pr.save(pro);
		}
		throw new ProductException("product not found with id "+product.getProductId());
	}

	@Override
	public List<Product> productByName(String name) throws ProductException {
		List<Product>list=pr.findByProductName(name);
		if(list.size()==0) {
			throw new ProductException("product not found with name "+name);
		}
		return list;
	}

}
