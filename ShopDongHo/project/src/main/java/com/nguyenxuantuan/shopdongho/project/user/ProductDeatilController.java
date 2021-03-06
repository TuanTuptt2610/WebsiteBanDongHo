package com.nguyenxuantuan.shopdongho.project.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nguyenxuantuan.shopdongho.project.model.CategoriesDTO;
import com.nguyenxuantuan.shopdongho.project.model.ProductDTO;
import com.nguyenxuantuan.shopdongho.project.service.CategoriesService;
import com.nguyenxuantuan.shopdongho.project.service.ProductService;

@Controller
public class ProductDeatilController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping("/product-detail/{id}")
	public String getProductDeatil(@PathVariable()int id, HttpServletRequest request) {
		ProductDTO productDTO = productService.getById(id);
		request.setAttribute("productDTO", productDTO);
		
		request.setAttribute("categoriesDTOs", categoriesService.getAll());
		
		CategoriesDTO categoriesDTO = categoriesService.getCategoriesById(productDTO.getId_categories());
		request.setAttribute("categoriesName",categoriesDTO.getCategories() );
		
		List<ProductDTO> lProductDTOs = productService.getByIdCategories(categoriesDTO.getId());
		request.setAttribute("listProducts", lProductDTOs);
		return "user/product-details";
	}
}
