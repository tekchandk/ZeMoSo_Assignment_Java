/* Author: Tek Chand
 * Date: 22nd July, 2019
 * Write a java function that will ping any host ( given as input ) and computes 
 * the median of the time taken to ping.
*/
package assignment3;
import java.io.*;
import java.util.*; 
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingHost {

  public static void runSystemCommand(String command) {
	ArrayList<Float> times = new ArrayList<Float>();

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			s = inputStream.readLine();
			// reading output stream of the command
			for (int i = 0; i <= 10; i++)
			{
				s = inputStream.readLine();
				System.out.println(s);
				String timeString = s.substring(s.indexOf("time") +5, s.indexOf(" ms"));
				float time = Float.parseFloat(timeString);
				times.add(time);
			}
			Collections.sort(times);
			System.out.println(times.get(5)+" ms");
			}
			catch (Exception e) {
			e.printStackTrace();
		}
	}

}