
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }

    public void testCountVisitsPerIP() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println(la.iPsmostVisits(la.countVisitsPerIP()));
    }

    public void testIPsForDays() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println(la.iPsWithMostVisitsOnDay(la.iPsForDays(), "Mar 17"));

    }
    
    public static void main(String[] args) {
        Tester tester =new Tester();
        tester.testIPsForDays();
    }
}
