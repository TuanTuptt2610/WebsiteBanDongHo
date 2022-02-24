package com.nguyenxuantuan.shopdongho.project.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoriesDTO {
	private int id;
	private int id_categories;
	private String sub_categories;
	private int status;
	private CategoriesDTO categoriesDTO;
	private List<ProductDTO> productDTOs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_categories() {
		return id_categories;
	}
	public void setId_categories(int id_categories) {
		this.id_categories = id_categories;
	}
	public String getSub_categories() {
		return sub_categories;
	}
	public void setSub_categories(String sub_categories) {
		this.sub_categories = sub_categories;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public CategoriesDTO getCategoriesDTO() {
		return categoriesDTO;
	}
	public void setCategoriesDTO(CategoriesDTO categoriesDTO) {
		this.categoriesDTO = categoriesDTO;
	}
	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}
	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}
	
	
}