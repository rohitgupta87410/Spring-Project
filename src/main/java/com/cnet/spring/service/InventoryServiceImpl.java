package com.cnet.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnet.spring.dao.InventoryDao;
import com.cnet.spring.model.Inventory;
import com.cnet.spring.model.InventoryType;


@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;
	
	@Override
	public void save(Inventory inventory) {
		// TODO Auto-generated method stub
		inventoryDao.save(inventory);
	}

	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryDao.getAllInventories();
	}

	@Override
	public List<InventoryType> getAllInventoryType() {
		// TODO Auto-generated method stub
		return inventoryDao.getAllInventoryType();
	}

	@Override
	public Inventory getInventory(Integer inventoryId) {
		// TODO Auto-generated method stub
		return inventoryDao.getInventory(inventoryId);
	}

}
