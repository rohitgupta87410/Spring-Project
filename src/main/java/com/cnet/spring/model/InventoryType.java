package com.cnet.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Inventory_Type")
public class InventoryType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6410974511926435182L;
	
	private Integer id ; 
	private String Type;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="type", nullable = false)
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	@Override
	public String toString() {
		return "InventoryType [id=" + id + ", Type=" + Type + "]";
	}
	
	
}
