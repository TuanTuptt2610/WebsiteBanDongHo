package com.nguyenxuantuan.shopdongho.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private int id;
	private int qty;
	private float price;
	private ProductDTO productDTO;
	private OrderDetailDTO orderDetailDTO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public OrderDetailDTO getOrderDetailDTO() {
		return orderDetailDTO;
	}
	public void setOrderDetailDTO(OrderDetailDTO orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}
	
	
}