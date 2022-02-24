package com.nguyenxuantuan.shopdongho.project.model;

import java.util.List;

import com.nguyenxuantuan.shopdongho.project.model.OrderDTO;
import com.nguyenxuantuan.shopdongho.project.model.OrderDetailDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {

	private String total_orders;
	private String total_sell_products;
	private String tunovers;
	private List<OrderDTO>orderDTO;
	private List<OrderDetailDTO>orderDetailDTO;
	public String getTotal_orders() {
		return total_orders;
	}
	public void setTotal_orders(String total_orders) {
		this.total_orders = total_orders;
	}
	public String getTotal_sell_products() {
		return total_sell_products;
	}
	public void setTotal_sell_products(String total_sell_products) {
		this.total_sell_products = total_sell_products;
	}
	public String getTunovers() {
		return tunovers;
	}
	public void setTunovers(String tunovers) {
		this.tunovers = tunovers;
	}
	public List<OrderDTO> getOrderDTO() {
		return orderDTO;
	}
	public void setOrderDTO(List<OrderDTO> orderDTO) {
		this.orderDTO = orderDTO;
	}
	public List<OrderDetailDTO> getOrderDetailDTO() {
		return orderDetailDTO;
	}
	public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}
	
	
}
