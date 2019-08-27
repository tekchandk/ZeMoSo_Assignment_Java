package tek.assignment.main;
import  tek.assignment.data.*;
import  tek.assignment.singleton.*;
public class Main{

    public static void main(String[] args)
    {
        // Create the new object of class Data and call the print method.
        Data obj1 = new Data();
        obj1.print();
        //obj1.printWithoutInit();

        // Create the new object of class Singleton and call the init method.
        Singleton obj2 = new Singleton();
        Singleton obj = obj2.init("abc");
        obj.printstr();
    } 
    
}
