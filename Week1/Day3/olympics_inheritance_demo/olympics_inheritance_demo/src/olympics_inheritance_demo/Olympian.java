package olympics_inheritance_demo;
//olypian class that represents olympian
public class Olympian {

	//member variables(attributes/caracteristiques)
	public String firstName;
	public int energyLevel;
	// def __init__(self,firstName):
	    //self.firstName=firstName
	//js://constructor(firstNmae){this.firstName = firstName}
	
	// constructor in JAVA 
	public Olympian(String firstName) {
		this.firstName=firstName;
		//start with full energy ^^
		this.energyLevel=100;
	}
	
	//methods : things that any object can do
	//how to declare method in java 
	// python : def displayData():
	// accessor Returntype name
	public void displayInfo() {
		//string.format
		System.out.printf("Player name : %s \nEnergy Level : %s \n",this.firstName,this.energyLevel);
	}
	// public abstract void displayInfo();
	
	//this is review 
	//inheritance : olympians different type what sport ? 
	//for eg : a basketball can do what ever an olympian can do but have someother properties
	//a basketball player have more methods 
	//create another class : i could copy the code and paste it :but remmeber DRY !!!
	//we have just to use the key word "extends" that will replace the copy paste 
	
}
