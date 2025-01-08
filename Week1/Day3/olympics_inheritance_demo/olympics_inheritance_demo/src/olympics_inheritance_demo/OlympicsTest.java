package olympics_inheritance_demo;

public class OlympicsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//control +space autocomplete
		//in js : let lebron = new Olympian("Lebron")
		
		Olympian lebron = new Olympian("Lebron") ;
		Olympian phelips = new Olympian("Michael") ;
      System.out.println("lets gooo!! "+phelips.firstName);
    //any question so far
      lebron.displayInfo();
      BasketBallPlayer basket=new BasketBallPlayer("Jordon",1.3);
      //i enherited from the olympian class this method
      basket.displayInfo();
      System.out.println(basket.verticalJumpHeight);
      basket.shootBall();
      basket.displayInfo();
      //on the scale to 1 to 10 : does that make sens 
      //inheritence : is when create a class that can do parent class can do and more 
      Swimmer swimmer1=new Swimmer("Phelips",10.5);
      swimmer1.displayInfo();
      swimmer1.swim100meters();
      swimmer1.displayInfo();
      
      
	}
	 

}
