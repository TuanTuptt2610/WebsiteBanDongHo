package com.nguyenxuantuan.shopdongho.project.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {
	private int id;
	private String categories;
	private int status;
	private List<SubCategoriesDTO>subCategoriesDTOs;
	private List<ProductDTO>productDTOs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<SubCategoriesDTO> getSubCategoriesDTOs() {
		return subCategoriesDTOs;
	}
	public void setSubCategoriesDTOs(List<SubCategoriesDTO> subCategoriesDTOs) {
		this.subCategoriesDTOs = subCategoriesDTOs;
	}
	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}
	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}
	
	
}
