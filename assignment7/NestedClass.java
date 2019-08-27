
// Author: Tek Chand
// Date: 8th July, 2019
/* 
Create a class with an inner class that has a non-default constructor (one that takes arguments).
 Create a second class with an inner class that inherits from the first inner class.
 */

class FirstOuterClass{
     class InnerClass{
         InnerClass(String str){
             System.out.println("The string is: "+str);

         }
     }
 }

class SecondOuterClass{
    class SecondInnerClass extends FirstOuterClass.InnerClass{
       
        SecondInnerClass(String str) {
            new FirstOuterClass().super(str);
        }
        void print() {
            System.out.println("Hello Everyone!");
        }
        
    }
}

public class NestedClass{
    public static void main (String[] args){
        SecondOuterClass secondOuterClass = new SecondOuterClass();
        SecondOuterClass.SecondInnerClass secondInnerClass = secondOuterClass.new SecondInnerClass("abc");
        secondInnerClass.print();
    }
}