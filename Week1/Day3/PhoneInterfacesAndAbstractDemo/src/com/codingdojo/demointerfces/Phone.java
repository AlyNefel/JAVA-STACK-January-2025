package com.codingdojo.demointerfces;

public abstract class Phone {
     //everyphone has versionnumber
	private String versionNumber;
	//battery percentage
	private int batteryPercentage;
	
	//ringtone
	private String ringTone;
	
	//abstract method added 
	public abstract void displayInfo();
	
	
	
	// how to generate constructor using source  and getters and setters 
	public Phone(String versionNumber, int batteryPercentage, String ringTone) {
		
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
	
		this.ringTone = ringTone;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}
	
	public String getRingTone() {
		return ringTone;
	}
	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}
	
	
}
