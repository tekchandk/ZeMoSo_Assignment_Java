// Author: Tek Chand
// Date: 8th July, 2019
/*
Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. 
Create factories for each type of Cycle, and code that uses these factories.
*/

interface Cycle {
	void ride();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	public void ride() { 
        System.out.println("Ride Unicycle"); 
    }
}

class Bicycle implements Cycle {
	public void ride() { 
        System.out.println("Ride Bicycle"); 
    }
}

class Tricycle implements Cycle {
	public void ride() { 
        System.out.println("Ride Tricycle");
     }
}

class UnicycleFactory implements CycleFactory {
	public Cycle getCycle() {
		return new Unicycle();
	}
}

class BicycleFactory implements CycleFactory {
	public Cycle getCycle() {
		return new Bicycle();
	}
}


class TricycleFactory implements CycleFactory {
	public Cycle getCycle() {
		return new Tricycle();
	}
}

public class Cycle_Interface {
	public static void rideCycle(CycleFactory factory) {
		Cycle c = factory.getCycle();
		c.ride();
	}
	public static void main(String [] args) {
		rideCycle(new UnicycleFactory());
		rideCycle(new BicycleFactory());
		rideCycle(new TricycleFactory());	
	}
}