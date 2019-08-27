public class Part2
{
    public int howMany (String stringa, String stringb)
    {
        int times = 0;
        int index = stringb.indexOf(stringa); 
        while (index != -1)
        {
            times++;
            index = stringb.indexOf(stringa, index + stringa.length());
        }
        return times;
    }
    public void testHowMany()
    {
        String stringa = "AA";
        String stringb = "ATAAAA";
        System.out.println(howMany(stringa, stringb));
    }
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testHowMany();
        
    }
}