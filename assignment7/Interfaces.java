
// Author: Tek Chand
// Date: 8th July, 2019
/* Create three interfaces, each with two methods. Inherit a new interface
 that combines the three, adding a new method. Create a class by 
 implementing the new interface and also inheriting from a concrete class.
 Now write four methods, each of which takes one of the four interfaces as
 an argument. In main(), create an object of your class and pass it to 
 each of the methods.
*/

interface Physics {
	void p1();
	void p2();
}

interface Chemistry {
	void c1();
	void c2();
}

interface Mathematics {
	void m1();
	void m2();
}

interface Science extends Physics, Chemistry, Mathematics {
	void sc();
}

class Engineer {
	private int i = 0;
	public void eng() {}
}

class SoftwareEngineer extends Engineer implements Science {
	private int j = 0;
	public void p1() {
        System.out.println("Welcome to PHY101");
    }
	public void p2() {
        System.out.println("Welcome to PHY102");
    }
	public void c1() {
        System.out.println("Welcome to CHM201");
    }
	public void c2() {
        System.out.println("Welcome to CHM202");
    }
	public void m1() {
        System.out.println("Welcome to MTH101");
    }
	public void m2() {
        System.out.println("Welcome to MTH102");
    }
	public void sc() {
        System.out.println("Welcome to PCM");
    }
}

public class Interfaces {
	public static void method1(Physics physics) { 
        physics.p1(); 
    }
	public static void method2(Chemistry chemistry) { 
        chemistry.c1();
     }
	public static void method3(Mathematics mathematics) { 
        mathematics.m1(); 
    } 
	public static void method4(Science science) { 
        science.sc(); 
    }
	public static void main(String[] args) {
		SoftwareEngineer soft = new SoftwareEngineer();
		method1(soft);
		method2(soft);
		method3(soft);
		method4(soft);
	}
}