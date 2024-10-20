package com.application.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.application.dto.ProductDTO;
import com.application.model.Categories;
import com.application.model.Product;
import com.application.repository.CategoriesRopository;
import com.application.repository.ProdcutRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProdcutRepository proRepo;
	
	@Autowired
	CategoriesRopository catRepo; 
	
	@Override
	public boolean addProductDetails(ProductDTO productDTO) {
		try {
			Categories category =  catRepo.findById(productDTO.getCategoriesId()).get();	
			Product p = new Product(productDTO.getBookName(), productDTO.getPublication(), productDTO.getPrice(), productDTO.getAuthorName(), category);
			proRepo.save(p);
			return true;
		} 
		catch (Exception ex) {
			System.out.println("Repository Exception is " + ex);
			return false;
		}
	}

	@Override
	public List<Product> viewProductList() {
		return proRepo.findAll();
	}
	
	@Override
	public Page<Product> getProducts(int pageSize) {
		return proRepo.findAll(PageRequest.ofSize(pageSize));
	}

	@Override
	public boolean deleteProductById(long id) {
		try {
			proRepo.deleteById(id);
			return true;
		} 
		catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public boolean updateProductById(ProductDTO productDTO, long id) {
		try {
			Product p = proRepo.findById(id).get();
			p.setBookName(productDTO.getBookName());
			p.setAuthorName(productDTO.getAuthorName());
			p.setPrice(productDTO.getPrice());
			p.setPublication(productDTO.getPublication());
			proRepo.save(p);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Product findProductById(long id) {
		return proRepo.findById(id).get();
	}
}
