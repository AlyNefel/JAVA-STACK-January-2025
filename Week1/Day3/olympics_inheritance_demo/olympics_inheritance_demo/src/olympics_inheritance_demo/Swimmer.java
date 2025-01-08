package olympics_inheritance_demo;
// help me how to enherit all the code from the olympian ??
public class Swimmer extends Olympian {
  //a constructor give it 
	//if the parent class has params in its constructor we must super that 
	//look to the parent 
	//100m swimm speed 
	public double swimSpeed;
	//maybe they start with more energy (how much will be the energyLevel )
	public Swimmer(String name,double swimSpeed) {
		super(name);
		this.swimSpeed=swimSpeed;
		this.energyLevel=300;
	}
	//what can a swimmer do 
	
	//methods 
	public void swim100meters() {
		this.energyLevel-=25;
	}
	public void swim400meters() {
		this.energyLevel-=200;
	}
}
