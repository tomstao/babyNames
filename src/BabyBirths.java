import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirths {


    public static void printNames()
    {
        FileResource fr = new FileResource();
        for(CSVRecord record:fr.getCSVParser(false)) // false means this data has no header.
        {
            int numBorn = Integer.parseInt(record.get(2));
            String name = record.get(0);
            String gender = record.get(1);
            String numBorn_s = record.get(2);
            if(numBorn <= 100)
            {
                System.out.println("Name: " + name + ", Gender: " + gender + ", Num Born: " + numBorn_s);
            }
        }
    }

    public static void totalBirths(FileResource fr)
    {   int totalBriths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int boyNames = 0;
        int girlNames = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBriths += numBorn;
            if(record.get(1).equals("M")){
                totalBoys += numBorn;
                boyNames++;
            } else {
                totalGirls += numBorn;
                girlNames++;
            }
        }
        System.out.println("Total Births: " + totalBriths);
        System.out.println("Total Boys: " + totalBoys);
        System.out.println("Total girls: " + totalGirls);
        System.out.println("Total boy Names: " + boyNames);
        System.out.println("Total girl Names: " + girlNames);
    }

    public static void testTotalbirths()
    {
       FileResource fr = new FileResource();
       totalBirths(fr);
    }

    public static int getRank(int year,String name,String gender)
    {
        String fileName= "us_babynames/us_babynames_test/yob" + year + "short.csv";
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        for(CSVRecord record:fr.getCSVParser(false))
        {
            String currGender = record.get(1);
            if(!(currGender.equals(gender))) continue;
            rank++;
            if(record.get(0).equals(name)) return rank;
        }
        return -1;
    }

    public static void testGetRank()
    {
        int year = 2012;
        String name = "Mason";
        //String gender = "M";
        String gender = "F";
        int rank = getRank(year,name,gender);
        if (rank == -1){
            System.out.println("No rank found for " + name + " year " + year);
        } else {
            System.out.println( "Name: " + name + ", Gender: " + gender + ", Rank: " + rank);
        }


    }

    public static String getName(int year, int rank, String gender)
    {
        String fileName= "us_babynames/us_babynames_test/yob" + year + "short.csv";
        FileResource fr = new FileResource(fileName);
        int rankNum = 0;
        for(CSVRecord record:fr.getCSVParser(false))
        {
            String currGender = record.get(1);
            if(!(currGender.equals(gender))) continue;
            rankNum++;

            String currName = record.get(0);
            if(rankNum == rank) return currName;
        }

        return "NO NAME";
    }

    public static void test_GetName()
    {
        int year = 2012;
        int rank = 2;
        int rank2 = 10;
        String gender = "M";
       String rank2ndName = getName(year,rank,gender);
       String rank10Name = getName(year,rank2,gender);
       System.out.println("Name: " + rank2ndName + ", Gender: " + gender + ", Rank: " + rank);
       System.out.println("Rank: " + rank10Name + ", Gender: " + gender + ", Rank: " + rank2);
    }
}
