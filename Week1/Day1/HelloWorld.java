public class HelloWorld{


    //more explanation on how java works to do next time ^^ 
    //lets start for the begining 
    //when you write a java code it will be compiled with 0 execution failed 
    public static void main(String[] args){
        System.out.println("Hello world !");
     //Comment :Data type  
     //how declare variable  : Type name = value

     //Primitive type : // it  can not be null  default value 
     int num =2;// default value 0
     boolean test=true;// dafault value 
     char singleCharacter ='b';// ''
     double firstDouble=23.5;//0.0
     
     //System.out.println(num+' '+test+' '+singleCharacter);
     /*Multiline comment */
     //Object  class wrapper() it can be null : it has it own methoods we can access with .notation
     Integer num2=6;
     Double double2=23.5;
     String string1="Test";
     Boolean test1=false;
     Character char1 = 'A';
System.out.println(num2+' '+string1+' '+test1);
     int lengthCString=string1.length();
     System.out.println(lengthCString);
    }
}
