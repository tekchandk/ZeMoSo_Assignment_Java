import java.util.*;
public class CodonCount
{
    private HashMap<String, Integer> mapCodons;
    public CodonCount()
    {
       mapCodons = new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start, String dna)
    {
        mapCodons.clear();
        for(int i = start; i < dna.length()-2; i += 3)
        {
            String codon = dna.substring(i, i+3);
            if(!mapCodons.containsKey(codon))
            {
                mapCodons.put(codon, 1);
            }
            else
            {
                int count = mapCodons.get(codon);
                mapCodons.put(codon, count + 1);
            }
        }

    }

    public String getMostCommonCodon()
    {
        int count = 0;
        String maxCodon = "";
        for (String codon : mapCodons.keySet())
        {
            if(count < mapCodons.get(codon))
            {
                count = mapCodons.get(codon);
                maxCodon = codon;
            }
        }
        return maxCodon;
    }

    public void printCodonCounts(int start, int end)
    {
        for(String codon : mapCodons.keySet())
        {
            int count = mapCodons.get(codon);
            if(count >= start && count <= end)
            {
                System.out.println(codon);
            }
        }
    }

    public void tester()
    {
        String dna = "CGTTCAAGTTCAA";
        int start = 2;
        buildCodonMap(start, dna);
        System.out.println(getMostCommonCodon());
        printCodonCounts(1, 5);
    }
    public static void main(String[] args) {
        CodonCount codonCount = new CodonCount();
        codonCount.tester();
        
    }
}