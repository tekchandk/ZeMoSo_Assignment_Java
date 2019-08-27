public class Part3
{
    public boolean twoOccurrences (String stringa, String stringb)
    {
        int index1 = stringb.indexOf(stringa);
        int index2 = stringb.indexOf(stringa, index1+1);
        if(index1 == -1 || index2 == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String lastPart (String stringa, String stringb)
    {
        int index = stringb.indexOf(stringa);
        if(index == -1)
        {
            return stringb;

        }
        return stringb.substring(index + stringa.length());
    }
    
    public void testing()
    {
        String stringa = "zoo";
        String stringb = "forest";
        System.out.println(lastPart(stringa, stringb));
        System.out.println(stringa + " is" + " found in " + stringb + " two times: " + twoOccurrences(stringa, stringb));
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testing();
    }
}