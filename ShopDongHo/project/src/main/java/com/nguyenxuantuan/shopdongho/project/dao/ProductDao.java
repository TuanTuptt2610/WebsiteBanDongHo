package com.nguyenxuantuan.shopdongho.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nguyenxuantuan.shopdongho.project.entity.ProductEntity;

public interface ProductDao {
	public List<ProductEntity> getDongHoNam();
	public List<ProductEntity> getDongHoNu();
	public List<ProductEntity> getSmartWatch();
	public List<ProductEntity> getAllAdminProduct();
	public void add(ProductEntity productEntity);
	public void delete(ProductEntity productEntity);
	public ProductEntity getProductById(int id);
	public void update(ProductEntity productEntity);
	public List<ProductEntity> getByIdCategories(int id_categories);
	public List<ProductEntity> getByIdSubCategories(int id_subcategories);
	public List<ProductEntity> searchProduct(String text);
	
}
@Transactional
@Repository
class ProductDaoImpl implements ProductDao{
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<ProductEntity> getDongHoNam() {
		String jql ="Select p from ProductEntity p Where p.id_categories=3 Order by p.id DESC";
		return entityManager.createQuery(jql,ProductEntity.class).setMaxResults(4).getResultList();
	}
	@Override
	public List<ProductEntity> getDongHoNu() {
		String jql ="Select p from ProductEntity p Where p.id_categories=4 Order by p.id DESC";
		return entityManager.createQuery(jql,ProductEntity.class).setMaxResults(4).getResultList();
	}
	@Override
	public List<ProductEntity> getSmartWatch() {
		String jql ="Select p from ProductEntity p Where p.id_categories=5 Order by p.id DESC";
		return entityManager.createQuery(jql,ProductEntity.class).setMaxResults(4).getResultList();
	}
	@Override
	public List<ProductEntity> getAllAdminProduct() {
		String jql ="Select p from ProductEntity p";
		return entityManager.createQuery(jql,ProductEntity.class).getResultList();
	}
	@Override
	public void add(ProductEntity productEntity) {
		entityManager.persist(productEntity);
		
	}
	@Override
	public void delete(ProductEntity productEntity) {
		entityManager.remove(productEntity);
		
	}
	@Override
	public ProductEntity getProductById(int id) {
		return entityManager.find(ProductEntity.class, id);
	}
	@Override
	public void update(ProductEntity productEntity) {
		entityManager.merge(productEntity);
		
	}
	@Override
	public List<ProductEntity> getByIdCategories(int id_categories) {
		String jql ="Select p from ProductEntity p where p.id_categories =: id_categories";
		return entityManager.createQuery(jql,ProductEntity.class).setParameter("id_categories", id_categories).getResultList();
	}
	@Override
	public List<ProductEntity> getByIdSubCategories(int id_subcategories) {
		String jql ="Select p from ProductEntity p where p.id_subcategories =: id_subcategories";
		return entityManager.createQuery(jql,ProductEntity.class).setParameter("id_subcategories", id_subcategories).getResultList();
	}
	@Override
	public List<ProductEntity> searchProduct(String text) {
		String jql ="Select p from ProductEntity p where p.name LIKE :text or p.price LIKE :text";
		return entityManager.createQuery(jql,ProductEntity.class).setParameter("text", '%'+text +'%').getResultList();
	}
	
}
