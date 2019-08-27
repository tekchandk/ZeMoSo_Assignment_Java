/* Author: Tek Chand
 * Date: 8th July, 2019
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent.
 * Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens.
 * Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
*/
package assignment7;
class Rodent
{
	void eat()
	{
		System.out.println("Rodent is eating");
	}
	void run()
	{
		System.out.println("Rodent is running");
	}
}

// Class Mouse is subclass of class Rodent (super class)
class Mouse extends Rodent
{
	void eat()
	{
		System.out.println("Mouse is eating");
	}
	void run()
	{
		System.out.println("Mouse is running");
	}
}

// Class Gerbil is subclass of class Rodent (super class)
class Gerbil extends Rodent
{
	void eat()
	{
		System.out.println("Gerbil is eating");
	}
	void run()
	{
		System.out.println("Gerbil is running");
	}
}

// Class Hamster is subclass of class Rodent (super class)
class Hamster extends Rodent
{
	void eat()
	{
		System.out.println("Hamster is eating");
	}
	void run()
	{
		System.out.println("Hamster is running");
	}
}
class RodentTest
{
	public static void main(String args[])
	{
		Rodent obj[] = new Rodent[3];
		obj[0] = new Mouse();
		obj[1] = new Gerbil();
		obj[2] = new Hamster();

		obj[0].eat();
		obj[0].run();

		obj[1].eat();
		obj[1].run();

		obj[2].eat();
		obj[2].run();
	}
}

