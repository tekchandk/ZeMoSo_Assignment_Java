// Author: Tek Chand
// Date: 8th July, 2019
/*Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression 
 *that checks a sentence to see that it begins with a capital letter and ends with a period.
*/
package assignment9;
import java.io.*; 
import  java.util.regex.Pattern;
public class TypeInformation{

    public static void main(String[] argv) {
        String pattern = "^[A-Z][^\\.]*\\.$";
        String input = "Hi, my name is Tek Chand.";

        Pattern p = Pattern.compile(pattern);

        boolean found = p.matcher(input).lookingAt();

        System.out.println("'" + pattern + "'" +
            (found ? " matches '" : " doesn't match '") + input + "'");
    }
}
