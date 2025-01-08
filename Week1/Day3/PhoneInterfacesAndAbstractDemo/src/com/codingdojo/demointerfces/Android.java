package com.codingdojo.demointerfces;

public class Android extends Phone implements Ringable{

	public Android(String versionNumber, int batteryPercentage, String ringTone) {
		super(versionNumber, batteryPercentage, ringTone);
		
	}

	@Override
	public void displayInfo() {
		System.out.printf("Androind details: \nVersion number: %s\nBattery: %s\nRing: %s\n",this.getVersionNumber(),this.getBatteryPercentage(),this.getRingTone());
			
		}
	public void ring() {
		System.out.println("Android ring"+this.getRingTone());
		
	}

	
	public void unlockPhone() {
		System.out.println("put ur secret number ....! it's unlocked ! ");
	}
}
