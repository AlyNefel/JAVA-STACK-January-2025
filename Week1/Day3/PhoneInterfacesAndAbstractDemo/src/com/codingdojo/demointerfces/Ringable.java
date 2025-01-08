package com.codingdojo.demointerfces;
//access modifier / interface to create interface and the name with capital letter ^^ 
//have a punch of methods without body shared among classes 
public interface Ringable {
//non-implmented method to ring the phone 
public void ring();
//non-implemented method to unlock the phone 
public void unlockPhone(); 

//not everyphone has to implement this methods vs if we put them in abstract class : if they are not implemented this will cause an error 

}
