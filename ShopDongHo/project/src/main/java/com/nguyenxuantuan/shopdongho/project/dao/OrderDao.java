package com.nguyenxuantuan.shopdongho.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenxuantuan.shopdongho.project.entity.OrderEntity;



public interface OrderDao {
	public List<OrderEntity> getAll();
	public List<OrderEntity> getOrderById_OrderDeatil(int order_id);
	public void addOrder(OrderEntity orderEntity);
	public void updateOrder(OrderEntity orderEntity);
	public void delete(OrderEntity orderEntity);
	public OrderEntity getById(int id);
}

@Transactional
@Repository
class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<OrderEntity> getAll() {
		String jql="Select o from OrderEntity o";
		return entityManager.createQuery(jql,OrderEntity.class).getResultList();
	}

	@Override
	public void addOrder(OrderEntity orderEntity) {
		entityManager.persist(orderEntity);
		
	}

	@Override
	public void updateOrder(OrderEntity orderEntity) {
		entityManager.merge(orderEntity);
		
	}

	@Override
	public void delete(OrderEntity orderEntity) {
		entityManager.remove(orderEntity);
	}

	@Override
	public OrderEntity getById(int id) {
		return entityManager.find(OrderEntity.class, id);
	}

	@Override
	public List<OrderEntity> getOrderById_OrderDeatil(int order_id) {
		String jql = "select o from OrderEntity o where o.orderDetailE.id = :order_id";
		return entityManager.createQuery(jql,OrderEntity.class).setParameter("order_id", order_id).getResultList();
	}
	
}

