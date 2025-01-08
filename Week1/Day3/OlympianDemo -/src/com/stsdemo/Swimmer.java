package com.stsdemo;

public class Swimmer extends Olympian{
	//specific attribute for swimmer class
	private int swimSpeed;


	//constructor for child class 
	public Swimmer(int swimSpeed,String name) {
		super(name);
		this.swimSpeed = swimSpeed;
	}
	public  void displayInfo() {
		System.out.println(String.format("Name: %s\nEnergy: %s\nSwimSpeed: %s", this.getName(),this.getEnergy(),this.swimSpeed));
	};
	
//swim method 
	public void swim() {
		this.setEnergy(this.getEnergy()-10);
	}
}
