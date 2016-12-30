package com.cnet.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnet.spring.model.Inventory;
import com.cnet.spring.model.InventoryType;

@Repository
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Inventory> getAllInventories() {
		// TODO Auto-generated method stub
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Inventory.class);
	List<Inventory> inventories  = (List<Inventory>) criteria.list();
		return inventories;
	}


	@Override
	public List<InventoryType> getAllInventoryType() {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryType.class);
		List<InventoryType> inventoryTypes = (List<InventoryType>)criteria.list();
		return inventoryTypes;
	}

	@Override
	public void save(Inventory inventory) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().save(inventory);
	}


	@Override
	public Inventory getInventory(Integer inventoryId) {
		// TODO Auto-generated method stub
		Inventory inventory =  (Inventory)sessionFactory.getCurrentSession().get(Inventory.class, inventoryId);
		return inventory;
	}

}
