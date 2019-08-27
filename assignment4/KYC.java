package assignment4;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class KYC{

    public boolean leapYear(int year)
    {
        boolean leap = false;
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
        return leap;
    }

    public String rangeOfKYC(String signUpDateCurrentDate)
    {
       // System.out.println(signUpDateCurrentDate);
        String[] dates = signUpDateCurrentDate.split("\\s+");
        String dateParts1[] = dates[0].split("-");
        String dateParts2[] = dates[1].split("-");
        int day1  = Integer.parseInt(dateParts1[0]);
        int month1  = Integer.parseInt(dateParts1[1]);
        int year1 = Integer.parseInt(dateParts1[2]);
        int day2  = Integer.parseInt(dateParts2[0]);
        int month2  = Integer.parseInt(dateParts2[1]);
        int year2 = Integer.parseInt(dateParts2[2]);
        
        int day01 = 0;
        int month01 = 0;
        int year01 = 0;
        int day02 = 0;
        int month02 = 0;
        int year02 = 0;
        //System.out.println(year2);
        int[] monthsDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (leapYear(year2))
        {
            monthsDays[1] = 29;
        }

        if ((year1 > year2) || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 >= day2))
        {
            return "No range";
        }
        else
        {
            if(day1 - 30 <= 0)
            {
                month01 = month1 -1;
                if(month01 == 0)
                {
                    year01 = year2 -1;
                }
                else
                {
                    year01 = year2;
                }
                day01 = day1 - 30 + monthsDays[month01 - 1];
            }

            if(day1 + 30 > monthsDays[month1 - 1] )
            {
                year02 = year2;
                month02 = month1 + 1;
                if(month02 >= month2)
                {
                    month02 = month2;
                    day02 = day2;
                }
                else if(month02 == 13)
                {
                    month02 = 1;
                    day02 = day1 + 30 - monthsDays[month1 - 1];
                }
                else
                {
                    day02 = day1 + 30 - monthsDays[month1 - 1];
                }
                
            }
        }
        //day01+"-"+month01+"-"+year01+" "+day02+"-"+month02+"-"+year02;

        return day01+"-"+month01+"-"+year01+" "+day02+"-"+month02+"-"+year02;

    }


    public static void main(String[] arg)
    {
        KYC kyc = new KYC();
        
        try 
        { 
            Scanner in = new Scanner(System.in);
            System.out.print("Type an integer: ");
            int n = in.nextInt();
            for (int i = 0; i < n; i++)
            {  
                in = new Scanner(System.in);
                String str = in.nextLine();
                System.out.println(kyc.rangeOfKYC(str));
            }   
        }  
        catch (Exception e)  
        { 
            System.out.println("Typed value is not a valid integer number"); 
        } 
       
        
        
        
    }
}