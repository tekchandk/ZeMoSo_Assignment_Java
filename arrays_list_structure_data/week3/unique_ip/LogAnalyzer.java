
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
//import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry> ();
     }

     // Count unique IPs
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le: records) {
             String ipAddress = le.getIpAddress();
            // if ip address is not unique
            if(!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
         }
         return uniqueIPs.size();
     }


     public void printAllHigherThanNum(int num) {
        for(LogEntry le: records) {
            int statusCode = le.getStatusCode();
            if(statusCode > num) {
                System.out.println(le);
            }
         }
     }

     public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueDayIPs = new ArrayList<String>();
        for(LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            Date d = le.getAccessTime();
            String day = d.toString();
           // System.out.println(day);
            if(day.contains(someday) && (!uniqueDayIPs.contains(ipAddress))){
                // if ip address is not unique
                uniqueDayIPs.add(ipAddress);
            }
        }
        return uniqueDayIPs;
     }


     public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueStatusIPs = new ArrayList<String>();
        for(LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if((statusCode >= low && statusCode <= high) && !uniqueStatusIPs.contains(ipAddress)) {
                uniqueStatusIPs.add(ipAddress);  
            }
         }
         return uniqueStatusIPs.size();
     }


       
        
     public void readFile(String filename) {
         // complete method
        File f = new File(filename);
        try{
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine = "";
       // System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                LogEntry l = WebLogParser.parseEntry(readLine);
                this.records.add(l);
                //System.out.println(readLine);
            }
            b.close();
        } catch (IOException e){
            e.printStackTrace();
        }

     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
