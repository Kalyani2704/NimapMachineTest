package com.application.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {
	private String BookName;
	private String AuthorName;
	private String Publication;
	private long Price;
	private long CategoriesId;
}
