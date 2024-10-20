package com.application.model;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoriesId;
	private String Name;
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private Set<Product> product;
	public Categories(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Categories [categoriesId=" + categoriesId + ", Name=" + Name + "]";
	}
}
