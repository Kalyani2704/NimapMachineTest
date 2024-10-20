package com.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.application.model.Categories;

public interface CategoriesRopository  extends JpaRepository<Categories, Long>{

}
