public class SwitchAndTernery {
    public static void main(String[] args) {
        int month =9;
 switch(month){
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:System.out.println("31 Days");
       break;
    case 2 : System.out.println("29 Days");  
       break;
    case 4:
    case 6:
    case 9:
    case 11: System.out.println("30 Days"); 
    break;
    default: System.out.println("Invalid month");
 }

  // Ternary -> condition ? result if the condition is true : result if condition is false
      
  boolean isHumain = false;
  String exampleString = isHumain == true ? "He is a humain" : "!! He is an Alien !!";
  System.out.println(exampleString);

    }
}
