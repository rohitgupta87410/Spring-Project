package com.cnet.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4853674599395434753L;
	
	private Integer id;
	@NotEmpty(message = "Please enter department name.")
	private String departmentName;
	@NotEmpty(message = "Please enter department address.")
	private String address;
	@NotEmpty(message = "Please enter department email.")
	@Email
	private String ownerEmail;
	
	public Department() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "dept_name", nullable = false)
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Column(name = "dept_address", nullable = false)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "owner_email", nullable = false)
	public String getOwnerEmail() {
		return ownerEmail;
	}
	
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", Address="
				+ address + ", ownerEmail=" + ownerEmail + "]";
	}

}
