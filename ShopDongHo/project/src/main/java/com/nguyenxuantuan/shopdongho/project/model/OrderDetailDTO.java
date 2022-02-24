package com.nguyenxuantuan.shopdongho.project.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
	private int id;
	private UserDTO user;
	private CouponDTO couponDTO;
	private String phone;
	private String address;
	private String city;
	private float total_price;
	private Date added_on;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public CouponDTO getCouponDTO() {
		return couponDTO;
	}
	public void setCouponDTO(CouponDTO couponDTO) {
		this.couponDTO = couponDTO;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public Date getAdded_on() {
		return added_on;
	}
	public void setAdded_on(Date added_on) {
		this.added_on = added_on;
	}
	
	
}

