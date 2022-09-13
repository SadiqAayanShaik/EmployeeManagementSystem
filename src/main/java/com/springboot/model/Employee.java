package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
@Table(name = "emp3")
public class Employee {
	
	@Id
	@GeneratedValue(generator = "emp_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="emp_seq",initialValue = 100,allocationSize = 1)     //,sequenceName = "emp"
	private Long eid;
	
	@NotNull
	@Size(min=2, max=10,message = "Employee name should start with uppercase and should not be less than 2 character")
	@Pattern(regexp = "^[A-Z][a-z]*",message = "Employee name should start with uppercase and should not be less than 2 character")
	private String ename;
	
	@NotEmpty
	private String dob;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	@Size(min=10, max=10,message = "Enter valid phone number")
	@Pattern(regexp = "^[6789][0-9]{9}",message = "Enter valid phone number")
	private String phone;
	
	 
	@Positive
	private int salary;
	
	
	public Employee(String ename, String dob, String gender, String phone, int salary) {
		super();
		this.ename = ename;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.salary = salary;
	}
	
	
	public Employee() {
		super();
	}


	public Employee(Long eid, @NotNull @Size(min = 2, max = 10) String ename, String dob, String gender,
			@NotEmpty @Size(min = 10, max = 10) String phone, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.salary = salary;
	}


	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

}
