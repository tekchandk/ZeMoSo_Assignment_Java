public class Part2
{
   public String findSimpleGene(String dna, String startCodon, String stopCodon)
   {
        int startCodonIndex = dna.toUpperCase().indexOf(startCodon);
        int stopCodonIndex = dna.toUpperCase().indexOf(stopCodon, startCodonIndex + 1);
        
        if(startCodonIndex == -1 || stopCodonIndex == -1)
        {
            return "";
        }
        else if((stopCodonIndex - (startCodonIndex+3)) % 3 == 0)
        {
                return dna.substring(startCodonIndex, stopCodonIndex+3);
        }
        else
        {
            return "";
        }
    }


    public void testSimpleGene()
    {
        String[] dna = {"GTACTGSTGAATAATAA", "GTACTGSTGAAATGATG", "ATGCTGATGTAA", "ATGCTGATGTAA", "ATGCTGTGTAA"};
        for (int i = 0; i < dna.length; i++)
        {
            System.out.println(findSimpleGene(dna[i], "ATG", "TAA"));
        }
    }
    public static void main(String[] args) {
        Part2 part2 =new Part2();
        part2.testSimpleGene();
        
    }
}