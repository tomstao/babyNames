import edu.duke.FileResource;

import org.apache.commons.csv.CSVRecord;

public class BabyBirths {


    public static void printNames()
    {
        FileResource fr = new FileResource();
        for(CSVRecord record:fr.getCSVParser(false)) // false means this data has no header.
        {
            String name = record.get(0);
            String gender = record.get(1);
            String numBorn = record.get(2);
            System.out.println("Name: " + name + ", Gender: " + gender + ", Num Born: " + numBorn);
        }
    }

}
