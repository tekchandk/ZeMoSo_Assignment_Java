import java.io.*;
public class CSVReader
{
    FileReader fileReader;
    
    public CSVReader(FileReader fileReader)
    {
        this.fileReader = fileReader;
    }
    public String[] readNext() {
        BufferedReader objReader = null;
        String strCurrentLine = "";
        try {
        

        objReader = new BufferedReader(fileReader);

        strCurrentLine = objReader.readLine();

        

        } catch (IOException e) {

        e.printStackTrace();

        } finally {

        try {
            if (objReader != null)
            objReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
        String[] values = strCurrentLine.split(",");
        return values;   
    }
}