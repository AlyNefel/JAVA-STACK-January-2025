package com.stsdemo;

public abstract class Olympian {
// attributes 
	private String name;
	private double energy;
	
	// empty constructor
	public Olympian() {}
	// constructor with attributes 
	public Olympian(String name) {
		
		this.name = name;
		this.energy=100.0;
	}
	
	//getters & seters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	
	//abstract  display info method 
	public abstract void displayInfo();
	
	
	
}
