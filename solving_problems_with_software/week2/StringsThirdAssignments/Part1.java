public class Part1
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

    public void printAllGenes(String dna) {
		while (true) {
			String gene = findGene(dna);
			if (gene.isEmpty()) {
				break;
			} else {
                System.out.println(gene);
                int startIndex = dna.indexOf("ATG");
                dna = dna.substring(gene.length() + startIndex);
			}

		}
    } 
    
    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
		while (true) {
			String gene = findGene(dna);
			if (gene.isEmpty()) {
				break;
			} else {
                //System.out.println(gene);
                sr.add(gene);
                int startIndex = dna.indexOf("ATG");
                dna = dna.substring(gene.length() + startIndex);
            }
        }
        return sr;
    } 
    
    public double cgRatio(String dna)
    {
        int startIndex = 0;
        int countCG = 0;
        while (startIndex <= dna.length())
        {
            if(dna.indexOf("C") != -1 && dna.indexOf("G") != -1)
            {
                countCG++;
            }
            
            startIndex ++;
        }
        return (float)countCG / dna.length();
    }

    public void processGenes() {
		String Longest = "";
		FileResource fr = new FileResource("GRch38dnapart.fa");
		String dna = fr.asString().toUpperCase();
		StorageResource sr = getAllGenes(dna);

		for(String s : sr.data()) {
			if(s.length() > Longest.length()) {
				Longest = s;
			}
		}
		System.out.println(Longest.length());
	}

    public void testProcessGenes ()
    {
        String dna = "ATGTAAGATGCCCTAGT";
        printAllGenes(dna);
        //System.out.println(findGene(dna));
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testProcessGenes();
        
    }
}