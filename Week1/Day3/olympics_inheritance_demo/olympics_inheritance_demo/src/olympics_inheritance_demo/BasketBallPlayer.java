package olympics_inheritance_demo;

public class BasketBallPlayer extends Olympian {
public double verticalJumpHeight;
	public BasketBallPlayer(String firstName,double verticalJumpHeight) {
		//the super keyword : do what ever the parent class do with this parameter
		//what parameter the parent class needs : firstName
		super(firstName);
		//overrride the energyLevel
		this.energyLevel=200;
		this.verticalJumpHeight=verticalJumpHeight;
		
	}
	
	//methods
	
	public void shootBall() {
		this.energyLevel-=10;
	}
	//override method 
	@Override // thius is to tell java  Hey this is a method that the parent class has but am modifing it 
	//### Annotations
	// functionality that can be added to functions built underneath
	// we already had a way to do that: comments, but these notes are not just for other humans to read, but for the compiler and build tools.
	public void displayInfo() {
		//string.format
		System.out.printf("Player name : %s \nEnergy Level : %s \nJump: %s\n",this.firstName,this.energyLevel,this.verticalJumpHeight);
	}
	
	//still work withou @ annotation use case ; this method is a new version of the parent class 

}
