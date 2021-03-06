package com.nguyenxuantuan.shopdongho.project.admin.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenxuantuan.shopdongho.project.model.SubCategoriesDTO;
import com.nguyenxuantuan.shopdongho.project.service.SubCategoriesService;

@RestController
public class RestAdminSubCategories {
	
	@Autowired
	private SubCategoriesService subCategoriesService;
	
	@GetMapping("/api/admin/subcategories")
	public List<SubCategoriesDTO> getAll() {
		List<SubCategoriesDTO> subCategoriesDTOs = subCategoriesService.getAll();
		return subCategoriesDTOs;
	}
	
	
	@PostMapping("/api/admin/add-subcategories")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addSubCategories(@RequestBody SubCategoriesDTO subCategoriesDTO) {
		try {
			subCategoriesService.add(subCategoriesDTO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@PutMapping("/api/admin/update-subcategories")
	public SubCategoriesDTO updateSubCategories(@RequestBody SubCategoriesDTO subCategoriesDTO) {
		try {
			subCategoriesService.update(subCategoriesDTO);
			return subCategoriesDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
