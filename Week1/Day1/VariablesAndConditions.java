/*
 * => define a class this is like a template + In java every file is a class (most of the times)
 */
public class VariablesAndConditions {
    /*method main needs to be called this 
    way to be executed  
    *public :The scope in java : who can reach any of the method they are defined in java file 
- public 
- privte 
- protected
*static : we don't need to create an instance of this object ,call it directly 
*void : return type we wont return anything*/
    public static void main(String[] args) {

        //Primitive  cannot be nulled
        /**Declare & assign type name = values */
        int age=20; // default 0
        age=40;
        boolean test = true ; //false => default
        double number = 10.85; // default 0.0
        char letter = 'b';  //we should use single quotes default ''
System.out.println(age +" "+test+" "+number+" "+letter );  //operator overloading in JAVA => the output will be a string
     

         // Wrapper Classes

        //  Object -> can be nulled
        // built in functions

         
          Integer number1 =52;
          Double double1=65.23;
          Long long1 = 12L;
          String name1 ="Dev";
          String name2 = new String("Dev");
          Boolean test1 =false;
          Character character1 ='T';
          System.out.println(number1 +" "+double1+" "+name1+" "+test1+" "+ character1+" "+long1); 


        // Aritmethic operators * / + - % ++ --  += -= *= /=
        //relational operators  == != < <= > >=  && || !

        /**Conditions */ 
        if(age<50){
            System.out.println("You are Less then 50 years!");
        }else {
            System.out.println("You are more than 50 years !");
        }
        System.out.println(name1==name2);
        System.out.println(name1.equals(name2));
    }
}
