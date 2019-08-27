package tek.assignment.singleton;
public class Singleton
{
    public  String str;
    private static Singleton init(String str) {
        Singleton obj = new Singleton(); 
        obj.str = str;
        return obj;
    }
    public void printstr () { 
        System.out.println("Print String: " + str);
    } 
}
