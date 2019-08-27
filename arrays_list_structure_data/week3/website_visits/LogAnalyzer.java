
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

     public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for(LogEntry le : records) {
            String ip = le.getIpAddress();
            if(! counts.containsKey(ip)) {
                counts.put(ip, 1);
            }
            else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;

     } 

    public int mostNumberVisitsByIP(HashMap<String, Integer> visits) {
        int max = 0;
        for (String ip : visits.keySet()) {
            // Obtain its number of visits
            int curr = visits.get(ip);
            if (curr > max) {
                max = curr; 
            }
        }
        return max;
    }

    public ArrayList<String> iPsmostVisits(HashMap<String, Integer> visits) {
        ArrayList<String> mostVisitedIPs = new ArrayList<String>();
        int maxVisit = mostNumberVisitsByIP(visits);
        for (String ip : visits.keySet()) {
            if(maxVisit == visits.get(ip)) {
                mostVisitedIPs.add(ip);
            }
        }
        return mostVisitedIPs;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> dateIP = new HashMap<String, ArrayList<String>>(); 
        ArrayList<String> ips = new ArrayList<String>();
        for(LogEntry le : records) {
            String ip = le.getIpAddress();
            String d = le.getAccessTime().toString().substring(4, 10);
            //ArrayList<String> ips = new ArrayList<String>();
            if(!dateIP.containsKey(d)) {
                ips = new ArrayList<String>();
                ips.add(ip);
                dateIP.put(d, ips);
            }
            else {
                ips = dateIP.get(d);
                ips.add(ip);
                dateIP.put(d, ips);
            }   
        }
        return dateIP;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dateIP ) {
        String maxDay = "";
         // For each day in dateMap
         for (String date : dateIP.keySet()) {
             // Retrieve its ArrayList of IP addresses
             ArrayList<String> ips = dateIP.get(date);
             // If on first day or if current day has more visits than on maxDay
             if (maxDay.equals("") || ips.size() > dateIP.get(maxDay).size()) {
                 maxDay = date;
             }
         }
         return maxDay;
     }


     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dateIP, String day) {
        ArrayList<String> ips = dateIP.get(day);
         // For each day in dateMap
         HashMap<String, Integer> visits = new HashMap<String, Integer>();
         for (String ip : ips) {
            if (!visits.containsKey(ip)) {
                visits.put(ip, 1);    
            } 
            else {
                visits.put(ip, visits.get(ip) + 1);
            }
        }
         return iPsmostVisits(visits);
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
