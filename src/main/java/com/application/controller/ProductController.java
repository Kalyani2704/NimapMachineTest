package com.application.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.CategoriesDTO;
import com.application.dto.ProductDTO;
import com.application.model.Categories;
import com.application.model.Product;
import com.application.service.ProductServiceInterface;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

	@Autowired
	private ProductServiceInterface serv;

	@GetMapping
	public List<Product> viewProduct() {
		return serv.viewProductList();
	}

	@GetMapping("pagination/{pageSize}")
	public Page<Product> getProducts(@PathVariable int pageSize) {
		return serv.getProducts(pageSize);		
	}
	
	@PostMapping("/")
	public ProductDTO addProducts(@RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.toString());
		if (serv.addProductDetails(productDTO))
			return productDTO;
		else
			return null;
	}

	@GetMapping("findById/{id}")
		public ResponseEntity<String> findbyId(@PathVariable("id") long id){   
			Product p = serv.findProductById(id);
			return new ResponseEntity<String>(p.toString(), HttpStatus.FOUND);
		}

	@DeleteMapping("{id}")
	public String deleteByProductId(@PathVariable("id") long id) {
		if (serv.deleteProductById(id))
			return "product deleted.........";
		else
			return "product not deleted..........";
	}
	
	@PutMapping("{id}")
	public String updateProduct(@PathVariable("id") long id, @RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.toString());
		System.out.println(id);
		if (serv.updateProductById(productDTO, id))
			return "product updated....";
		else
			return "product not updated....";
	}
}
