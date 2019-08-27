/* 
Date: 8th July, 2019
Author: Tek Chand
Problem: 
Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to 
Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast 
them to an array of Cycle. Try to call balance( ) on each element of the array and observe 
the results. Downcast and call balance( ) and observe what happens.
*/

class Cycle
{
	/*void balance()
	{
		System.out.println("Cycle is balance");
	}
	*/

	public static void main(String args[])
	{
		Cycle obj[] = new Cycle[3];
		
		// Upcasting
		Unicycle obj1 = new Unicycle(); 
		Bicycle obj2 = new Bicycle();
		Tricycle obj3 = new Tricycle();
		
		obj[0] = (Cycle) obj1;
		obj[1] = (Cycle) obj2;
		obj[2] = (Cycle) obj3;

		obj[0].balance();
        obj[1].balance();
		obj[2].balance();
		
		
		/*
		// Downcasting

		obj[0] = new Cycle();
		Unicycle obj1 = (Unicycle) obj[0];

		obj[1] = new Cycle();
		Bicycle obj2 = (Bicycle) obj[1];

		obj[2] = new Cycle();
		Tricycle obj3 = (Tricycle) obj[2];

		obj1.balance();
        obj2.balance();
		obj3.balance();
		*/
		
	}
	
}
class Unicycle extends Cycle
{
	void balance()
	{
		System.out.println("Unicycle is balance");
	}
}
class Bicycle extends Cycle
{
	void balance()
	{
		System.out.println("Bicycle is balance");
	}
}
class Tricycle extends Cycle
{
	
}

class CycleMain
{
	public static void main(String args[])
	{
		Cycle obj[] = new Cycle[3];
		
		// Upcasting
		Unicycle obj1 = new Unicycle(); 
		Bicycle obj2 = new Bicycle();
		Tricycle obj3 = new Tricycle();
		
		obj[0] = (Cycle) obj1;
		obj[1] = (Cycle) obj2;
		obj[2] = (Cycle) obj3;

		obj[0].balance();
        obj[1].balance();
		obj[2].balance();
		
		
		/*
		// Downcasting

		obj[0] = new Cycle();
		Unicycle obj1 = (Unicycle) obj[0];

		obj[1] = new Cycle();
		Bicycle obj2 = (Bicycle) obj[1];

		obj[2] = new Cycle();
		Tricycle obj3 = (Tricycle) obj[2];

		obj1.balance();
        obj2.balance();
		obj3.balance();
		*/
		
	}
}