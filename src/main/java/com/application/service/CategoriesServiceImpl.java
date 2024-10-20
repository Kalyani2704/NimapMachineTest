package com.application.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;
import com.application.model.Product;
import com.application.repository.CategoriesRopository;

@Service
public class CategoriesServiceImpl implements CategoriesServiceInterface {

	@Autowired
	CategoriesRopository catRepo;

	@Override
	public boolean addCategories(CategoriesDTO categoriesDTO) {
		Categories c = new Categories(categoriesDTO.getName());
		try {
			catRepo.save(c);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public List<Categories> viewCategoryList() {
		return catRepo.findAll();
	}
	
	@Override
	public Page<Categories> getCategories(int pageSize) {
		return catRepo.findAll(PageRequest.ofSize(pageSize));
	}

	@Override
	public boolean deleteCategoriesById(long id) {
		try {
			catRepo.deleteById(id);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateCategories(CategoriesDTO categoriesDTO, long id) {
		try {
			Categories c = catRepo.findById(id).get();
			c.setName(categoriesDTO.getName());
			catRepo.save(c);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Categories findbyCategoriesId(long id) {		
		return catRepo.findById(id).get();
	}
}
