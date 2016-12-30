package com.cnet.spring.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Inventory")
public class Inventory implements Serializable {

	private static final long serialVersionUID = -896797345382996520L;
	private Integer id;
	@NotEmpty(message = "Please enter inventory name.")
	private String inventaryName;
	@Valid
	private Department department;
	@Valid
	private InventoryType inventoryType;
	private Date expiryDate ;
	private Integer inventoryTypeId;
	
	public Inventory() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inventory_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="inventory_name", nullable= false)
	public String getInventaryName() {
		return inventaryName;
	}
	public void setInventaryName(String inventaryName) {
		this.inventaryName = inventaryName;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinColumn(name="department")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="inventoryType")
	public InventoryType getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}
	
	@Transient
	public Integer getInventoryTypeId() {
		return inventoryTypeId;
	}
	
	public void setInventoryTypeId(Integer inventoryTypeId) {
		this.inventoryTypeId = inventoryTypeId;
	}
	
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", inventaryName=" + inventaryName
				+ ", department=" + department + ", inventoryType="
				+ inventoryType + "]";
	}

	@Column(name="expiry_date", nullable= false)
	@Temporal(TemporalType.DATE)
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
