package com.cnet.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnet.spring.model.Inventory;
import com.cnet.spring.model.InventoryType;
import com.cnet.spring.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	
	@InitBinder  
	 public void initBinder(WebDataBinder binder)   
	 {  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	  dateFormat.setLenient(false);  
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	 }  
	
	/**
     * This method will list all existing inventories.
     */
	
    @RequestMapping(value = {"/inventory" }, method = RequestMethod.GET)
    public String listInventories(ModelMap model) {
    	List<InventoryType> inventoryTypes = inventoryService.getAllInventoryType();
        List<Inventory> inventories = inventoryService.getAllInventory();
        model.addAttribute("inventories", inventories);
        model.addAttribute("inventoryTypes", inventoryTypes);
        model.addAttribute("inventory", new Inventory());
        return "inventory";
    }
	
	@RequestMapping(value="/saveInventory", method=RequestMethod.POST)  
	public String saveInventory( @Valid @ModelAttribute("inventory") Inventory inventory, BindingResult result, ModelMap model) {
		
		
	    if(result.hasErrors()) {
	    	model.addAttribute("inventories", inventoryService.getAllInventory());
	    	model.addAttribute("inventoryTypes", inventoryService.getAllInventoryType());
			return "inventory";
		}
	    
		InventoryType inventoryType = new InventoryType();
		inventoryType.setId(inventory.getInventoryTypeId());
		inventory.setInventoryType(inventoryType);
		inventoryService.save(inventory);
		return "redirect:inventory";  
	}
	
	@RequestMapping(value="/inventory/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Inventory getInventory(@PathVariable int id) {
		Inventory inventory = inventoryService.getInventory(id);
		return inventory;
	}
}
