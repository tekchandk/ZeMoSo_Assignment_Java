public class Part3
{
    public int findStopCodon (String dna, int startIndex, String stopCodon)
    {
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);

        while (stopIndex != -1)
        {   if((stopIndex - startIndex) % 3 == 0)
            {
                return stopIndex;
            }
            stopIndex = dna.indexOf(stopCodon, stopIndex + 1);
        }
        return dna.length();
    }

    public String findGene(String dna)
    {
        int startIndex = dna.indexOf("ATG");
        int stopIndexTAA = findStopCodon(dna, startIndex, "TAA");
        int stopIndexTAG = findStopCodon(dna, startIndex, "TAG");
        int stopIndexTGA = findStopCodon(dna, startIndex, "TGA");
        int stopIndex = dna.length();
       
        if (stopIndexTAA > stopIndexTAG)
        {
            if(stopIndexTAG > stopIndexTGA)
            {
                stopIndex = stopIndexTGA;
            }
            else
            {
                stopIndex = stopIndexTAG;
            }

        }
        else
        {
            if(stopIndexTAA < stopIndexTGA)
            {
                stopIndex = stopIndexTAA;
            }
            else
            {
                stopIndex = stopIndexTGA;
            }

        }
        
        if(startIndex == -1 || stopIndex == dna.length())
        {
            return "";
        }
        else
        {
            return dna.substring(startIndex, stopIndex + 3);
        }
    }


    public int countGenes (String dna)
    {
        int count = 0;
        while (true) {
			String gene = findGene(dna);
			if (gene.isEmpty()) {
				break;
			} else {
                count++;
                //System.out.println(gene);
                int startIndex = dna.indexOf("ATG");
                dna = dna.substring(gene.length() + startIndex);
			}

        }
        return count;
    }
 
    

    public void testFindStopCodon ()
    {
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna));
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testFindStopCodon();
        
    }
}