package com.codingdojo.demointerfces;
//we start by extends 
public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, String ringTone) {
		super(versionNumber, batteryPercentage,ringTone);
		
	}

	@Override
	public void displayInfo() {
	System.out.printf("Iphone details: \nVersion number: %s\nBattery: %s\nRing: %s\n",this.getVersionNumber(),this.getBatteryPercentage(),this.getRingTone());
		
	}
	//specific method to iphone only new interface
	public void sendImessage() {
		
	}

	
	public void ring() {
		System.out.println("Iphone ring with siri message");
		
	}

	
	public void unlockPhone() {
		System.out.println("Scan your face ....! it's unlocked ! ");
		
	}

}
