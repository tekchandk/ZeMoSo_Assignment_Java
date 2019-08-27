/*
 * Author: Tek Chand
 * Date: 24th July, 2019
 * Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized, add a method to print these variables. 
 * Add another method in the same class with two local variables and print their values without initializing them.
*/

package tek.assignment.data;

// Reading the variables
public class Data{
    public  static int intA;
    public  static char charB;

    // Print the variables of the Data class

    public void print() {
        System.out.println("int variable: "+intA);
        System.out.println("char variable: "+charB);
        } 
    /*
    public void printWithoutInit() {
        int locVar1;
        char locVar2;
        System.out.println("int local variable: "+locVar1);
        System.out.println("char local variable: "+locVar2);
        } 
    */
}
