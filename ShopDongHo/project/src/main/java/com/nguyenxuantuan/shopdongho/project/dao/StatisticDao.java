package com.nguyenxuantuan.shopdongho.project.dao;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenxuantuan.shopdongho.project.entity.OrderDetailEntity;
import com.nguyenxuantuan.shopdongho.project.entity.OrderEntity;

@Transactional
@Repository
public interface StatisticDao extends CrudRepository<OrderDetailEntity, Integer> {
	//order
	@Query(value = "Select od From OrderDetailEntity od "
			+ "Where YEAR(od.added_on) = :year")
	public List<OrderDetailEntity> getOrderDetailByYear(@Param("year") int year);
	
	@Query(value = "Select od From OrderDetailEntity od "
			+ "Where MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public List<OrderDetailEntity> getOrderDetailByMonth(@Param("month") int month, @Param("year") int year);
	
	@Query(value = "Select od From OrderDetailEntity od "
			+ "Where DAY(od.added_on) = :day And MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public List<OrderDetailEntity> getOrderDetailByDay(@Param("day") int day, @Param("month") int month, @Param("year") int year);
	
	//thống kê
	//Thống kê theo năm
	@Query(value = "Select COUNT(od.id) From OrderDetailEntity od "
			+ "Where YEAR(od.added_on) = :year")
	public String total_ordersByYear(@Param("year") int year);
	
	@Query(value = "Select SUM(o.qty) From OrderDetailEntity od inner join od.orderEntity o "
			+ "Where YEAR(od.added_on) = :year")
	public String total_sell_productsByYear(@Param("year") int year);
	
	@Query(value = "Select SUM(od.total_price) From OrderDetailEntity od "
			+ "Where YEAR(od.added_on) = :year")
	public String tunoversByYear(@Param("year") int year);
	
	//Thống kê theo tháng
	@Query(value = "Select COUNT(od.id) From OrderDetailEntity od "
			+ "Where MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String total_ordersByMonth(@Param("month") int month, @Param("year") int year);
	
	@Query(value = "Select SUM(o.qty) From OrderDetailEntity od inner join od.orderEntity o "
			+ "Where MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String total_sell_productsByMonth(@Param("month") int month, @Param("year") int year);

	@Query(value = "Select SUM(od.total_price) From OrderDetailEntity od "
			+ "Where MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String tunoversByMonth(@Param("month") int month, @Param("year") int year);
	
	//Thống kê theo ngày
	@Query(value = "Select COUNT(od.id) From OrderDetailEntity od "
			+ "Where DAY(od.added_on) = :day And MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String total_ordersByDay(@Param("day") int day, @Param("month") int month, @Param("year") int year);
	
	@Query(value = "Select SUM(o.qty) From OrderDetailEntity od inner join od.orderEntity o "
			+ "Where DAY(od.added_on) = :day And MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String total_sell_productsByDay(@Param("day") int day, @Param("month") int month, @Param("year") int year);
	
	@Query(value = "Select SUM(od.total_price) From OrderDetailEntity od "
			+ "Where DAY(od.added_on) = :day And MONTH(od.added_on) = :month And YEAR(od.added_on) = :year")
	public String tunoversByDay(@Param("day") int day, @Param("month") int month, @Param("year") int year);
}
