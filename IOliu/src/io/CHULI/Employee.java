/**
 * 
 */
package io.CHULI;

import java.io.Serializable;

/**
 * @author Gz
 *
 */
public class Employee implements java.io.Serializable{

	private String name;
	private double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(){
		
	}
	

}
