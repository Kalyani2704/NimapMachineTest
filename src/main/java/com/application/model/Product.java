package com.application.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookId;
	private String BookName;
	private String AuthorName;
	private String Publication;
	private long Price;	
	@ManyToOne()
	@JoinColumn(name = "categories_id", nullable = false)
	private Categories categories;	
	
	public Product(String bookName, String publication, long price, String authorName, Categories categories) {
		BookName = bookName;
		Publication= publication;
		Price = price;
		AuthorName = authorName;
		this.categories = categories;
	}
	
	@Override
	public String toString() {
		return "Product [BookId=" + BookId + ", BookName=" + BookName + ", Publication=" + Publication + ", Price="
				+ Price + ", AuthorName=" + AuthorName + ", categories=" + categories + "]";
	}
}
