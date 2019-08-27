public class Part1
{
    public String  findSimpleGene(String dna)
    {
        int startCodonIndex = dna.indexOf("ATG");
        int stopCodonIndex = dna.indexOf("TAA", startCodonIndex + 1);
        
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
            System.out.println(findSimpleGene(dna[i]));
        }
    }
    public static void main(String[] args) {
        Part1 part1 =new Part1();
        part1.testSimpleGene();
        
    }
}