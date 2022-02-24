package com.nguyenxuantuan.shopdongho.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenxuantuan.shopdongho.project.dao.StatisticDao;
import com.nguyenxuantuan.shopdongho.project.entity.OrderDetailEntity;
import com.nguyenxuantuan.shopdongho.project.model.OrderDetailDTO;
import com.nguyenxuantuan.shopdongho.project.model.StatisticDTO;

public interface StatisticService {
	public List<OrderDetailDTO> getOrderDetailByYear(int year);
	public List<OrderDetailDTO> getOrderDetailByMonth(int month, int year);
	public List<OrderDetailDTO> getOrderDetailByDay(int day, int month, int year);
	public StatisticDTO getStatisticByYear(int year); 
	public StatisticDTO getStatisticByMonth(int month, int year);
	public StatisticDTO getStatisticByDay(int day, int month, int year);
}

@Service
@Transactional
class StatisticServiceImpl implements StatisticService{
	@Autowired
	private StatisticDao statisticDao;
	
	@Autowired
	private UserServiceImpl adminUserService;
	
	@Autowired
	private CouponService couponService;
	
	@Override
	public List<OrderDetailDTO> getOrderDetailByYear(int year) {
		List<OrderDetailDTO> odDTOs = new ArrayList<OrderDetailDTO>();
		List<OrderDetailEntity> odEntities = statisticDao.getOrderDetailByYear(year);
		for(OrderDetailEntity odEntity : odEntities) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			orderDetailDTO.setId(odEntity.getId());
			orderDetailDTO.setUser(adminUserService.getUserById(odEntity.getUser_id()));
			orderDetailDTO.setCouponDTO(couponService.getCouponById(odEntity.getCoupon_id()));
			orderDetailDTO.setAdded_on(odEntity.getAdded_on());
			orderDetailDTO.setAddress(odEntity.getAddress());
			orderDetailDTO.setTotal_price(odEntity.getTotal_price());
			orderDetailDTO.setCity(odEntity.getCity());
			orderDetailDTO.setPhone(odEntity.getPhone());
			odDTOs.add(orderDetailDTO);
		}
		
		return odDTOs;
	}
	
	@Override
	public List<OrderDetailDTO> getOrderDetailByMonth(int month, int year) {
		List<OrderDetailDTO> odDTOs = new ArrayList<OrderDetailDTO>();
		List<OrderDetailEntity> odEntities = statisticDao.getOrderDetailByMonth(month, year);
		for(OrderDetailEntity odEntity : odEntities) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			orderDetailDTO.setId(odEntity.getId());
			orderDetailDTO.setUser(adminUserService.getUserById(odEntity.getUser_id()));
			orderDetailDTO.setCouponDTO(couponService.getCouponById(odEntity.getCoupon_id()));
			orderDetailDTO.setAdded_on(odEntity.getAdded_on());
			orderDetailDTO.setAddress(odEntity.getAddress());
			orderDetailDTO.setTotal_price(odEntity.getTotal_price());
			orderDetailDTO.setCity(odEntity.getCity());
			orderDetailDTO.setPhone(odEntity.getPhone());
			odDTOs.add(orderDetailDTO);
		}
		
		return odDTOs;
	}
	
	public List<OrderDetailDTO> getOrderDetailByDay(int day, int month, int year) {
		List<OrderDetailDTO> odDTOs = new ArrayList<OrderDetailDTO>();
		List<OrderDetailEntity> odEntities = statisticDao.getOrderDetailByDay(day, month, year);
		for(OrderDetailEntity odEntity : odEntities) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			orderDetailDTO.setId(odEntity.getId());
			orderDetailDTO.setUser(adminUserService.getUserById(odEntity.getUser_id()));
			orderDetailDTO.setCouponDTO(couponService.getCouponById(odEntity.getCoupon_id()));
			orderDetailDTO.setAdded_on(odEntity.getAdded_on());
			orderDetailDTO.setAddress(odEntity.getAddress());
			orderDetailDTO.setTotal_price(odEntity.getTotal_price());
			orderDetailDTO.setCity(odEntity.getCity());
			orderDetailDTO.setPhone(odEntity.getPhone());
			odDTOs.add(orderDetailDTO);
		}
		
		return odDTOs;
	}
	
	@Override
	public StatisticDTO getStatisticByYear(int year) {
		StatisticDTO stadto = new StatisticDTO();
		stadto.setTotal_orders(statisticDao.total_ordersByYear(year));
		stadto.setTotal_sell_products(statisticDao.total_sell_productsByYear(year));
		stadto.setTunovers(statisticDao.tunoversByYear(year));
		
		return stadto;
	}
	
	@Override
	public StatisticDTO getStatisticByMonth(int month, int year) {
		StatisticDTO stadto = new StatisticDTO();
		stadto.setTotal_orders(statisticDao.total_ordersByMonth(month, year));
		stadto.setTotal_sell_products(statisticDao.total_sell_productsByMonth(month, year));
		stadto.setTunovers(statisticDao.tunoversByMonth(month, year));
		
		return stadto;
	}
	
	@Override
	public StatisticDTO getStatisticByDay(int day, int month, int year) {
		StatisticDTO stadto = new StatisticDTO();
		stadto.setTotal_orders(statisticDao.total_ordersByDay(day, month, year));
		stadto.setTotal_sell_products(statisticDao.total_sell_productsByDay(day, month, year));
		stadto.setTunovers(statisticDao.tunoversByDay(day, month, year));
		
		return stadto;
	}
}