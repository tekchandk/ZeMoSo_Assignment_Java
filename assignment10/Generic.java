// Name: Tek Chand
// Date: 8th July, 2019
/*
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.
 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).
 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
*/

import java.util.*;

class SList<T> {
    private Link<T> headLink = new Link<T>(null);
    
    SListIterator<T> iterator() 
    { 
        return new SListIterator<T>(headLink); 
    }
    public String toString() 
    { 
        if(headLink.next == null) 
        {
            return "SList: []";
        }
		System.out.print("SList: [");
		SListIterator<T> it = this.iterator();
		StringBuilder s = new StringBuilder(); 
		while(it.hasNext()) {
			s.append(it.next() + (it.hasNext() ? ", " : ""));
		}
		return s + "]";
	}		
}

class SListIterator<T> {
	Link<T> current;
	SListIterator(Link<T> link) {
		current = link;
	}
	public boolean hasNext() {
		return current.next != null;
	}
	public Link<T> next() {
		current = current.next;
		return current;
	}
	public void insert(T e) {
		current.next = new Link<T>(e, current.next);
		current = current.next;
	}	
	public void remove() {
		if(current.next != null) {
			current.next = current.next.next;
		}
	}
}

class Link<T> {
	T e;
	Link<T> next;
	Link(T e, Link<T> next) { 
		this.e = e;
		this.next = next; 
	}
	Link(T e) {
		this(e, null);
	} 	
	public String toString() {
		if(e == null) return "null";
		return e.toString();
	}
}

public class Generic {
	public static void main(String[] args) {
		SList<String> sl = new SList<String>();
		System.out.println(sl);
		SListIterator<String> slIter = sl.iterator();
		System.out.println("inserting \"Hi\"");
		slIter.insert("Hi");
		System.out.println(sl);
		System.out.println("inserting \"there\"");
		slIter.insert("there");
		System.out.println(sl);
		System.out.println("inserting \"sweetie\"");
		slIter.insert("sweetie");
		System.out.println(sl);
		System.out.println("inserting \"pie\"");
		slIter.insert("pie");
		System.out.println(sl);
		SListIterator<String> slIter2 = sl.iterator();
		System.out.println("removing \"hi\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("inserting \"hello\"");
		slIter2.insert("hello");
		System.out.println(sl);
		System.out.println("removing \"there\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"sweetie\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"pie\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"hello\"");
		SListIterator slIter3 = sl.iterator();
		slIter3.remove();
		System.out.println(sl);		
	}
}