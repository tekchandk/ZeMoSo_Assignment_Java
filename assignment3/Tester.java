package assignment3;
import assignment3.PingHost;
import java.util.Scanner;

public class Tester
{
    public static void main(String[] args) {
        
        PingHost pingHost = new PingHost();
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
		pingHost.runSystemCommand("ping " + ip);
	
	}
}
