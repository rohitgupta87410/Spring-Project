package com.cnet.spring.service;

import java.util.List;

import com.cnet.spring.model.Inventory;
import com.cnet.spring.model.InventoryType;

public interface InventoryService {

	public void save(Inventory inventory);
	public List<Inventory> getAllInventory();
	public List<InventoryType> getAllInventoryType();
	public Inventory getInventory(Integer inventoryId);
}
