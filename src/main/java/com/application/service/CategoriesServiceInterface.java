package com.application.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.application.dto.CategoriesDTO;
import com.application.model.Categories;

public interface CategoriesServiceInterface {
	public List<Categories> viewCategoryList();
	
	public Page<Categories> getCategories(int pageSize);
	
	public boolean addCategories(CategoriesDTO dCtegoriesDTO);

	public boolean deleteCategoriesById(long id);

	public boolean updateCategories(CategoriesDTO categoriesDTO, long id);

	public Categories findbyCategoriesId(long id);
}
