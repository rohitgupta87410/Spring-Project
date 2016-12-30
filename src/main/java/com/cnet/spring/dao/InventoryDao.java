package com.cnet.spring.dao;

import java.util.List;
import java.util.Set;

import com.cnet.spring.model.Inventory;
import com.cnet.spring.model.InventoryType;

public interface InventoryDao {

	public void save(Inventory inventory);
	public List<Inventory> getAllInventories();
	public List<InventoryType> getAllInventoryType();
	public Inventory getInventory(Integer inventoryId);
}
