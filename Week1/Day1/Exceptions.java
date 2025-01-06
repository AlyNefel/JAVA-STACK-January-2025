public class Exceptions {
    public static void main(String[] args) {
       int numbers[]={1,2,3,4,5} ;
       //handel the exception so it wont block the rest of execution
       try {
        System.out.println(numbers[10]);
        System.out.println("this will be skiped");
        //Exeption handel what ever error happens but we can add from most specific to most generic 
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e);
        // TODO: handle exception
       }
    /*  catch (Exception error) {
        System.out.println(error);
        // TODO: handle exception
       }
*/
//always execute whether there is an error or not
finally{
    System.out.println("This will always execute !");
}
      
     
       // it's blocked because we have exception
       System.out.println("This wont show !!");
    }
}

//
