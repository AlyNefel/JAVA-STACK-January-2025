package com.codingdojo.demointerfces;

public class PhoneTest {

	public static void main(String[] args) {
		Iphone iphone1=new Iphone("IOS1452",100,"Hello world");
       iphone1.displayInfo();
       Android android1=new Android("An656512",100,"Lets'do this ");
       android1.displayInfo();
	}

}
