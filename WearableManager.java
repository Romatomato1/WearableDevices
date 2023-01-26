import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
/**
 * Wearablemanager collects information and then displays it when necessary.
 *
 * @author Roman Gofman
 * @version 6/2/2020
 */
public class WearableManager
{
    //----------------------------------------------------------------------------------------
    //Instance Variables
    //----------------------------------------------------------------------------------------
    
    /** An array of wearables where read data is stored. */
    private Wearable[] wearables;

    /** TreeMap sorted by company names. */
    private TreeMap<String> companyNames;

    /** TreeMap sorted by company rankings. */
    private TreeMap<Integer> companyRankings;

    /** TreeMap sorted by wearable prices. */
    private TreeMap<Double> wearablePrices;

    /** Scanner to read file. */
    private Scanner fileReader;

    //----------------------------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------------------------
    
    /**
     * Constructor for objects of class WearableManager
     */
    public WearableManager()
    {
        companyNames = new TreeMap<String>();
        companyRankings = new TreeMap<Integer>();
        wearablePrices = new TreeMap<Double>();
        try{
            File dataFile = new File("wearables.txt");
            fileReader = new Scanner(dataFile);
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        int arrayLength = fileReader.nextInt();
        wearables = new Wearable[arrayLength];
        readFile();
    }

    //----------------------------------------------------------------------------------------
    //Get Data
    //----------------------------------------------------------------------------------------   
    
    /**
     * Method readFile  Reads a file to gather data filling arrays and TreeMaps.
     *
     */
    public void readFile(){
        fileReader.nextLine();
        fileReader.nextLine();
        int counter = 0;
        while (fileReader.hasNext()){
            String [] wearableParams = fileReader.nextLine().split("@");
            wearables[counter] = new Wearable(Integer.parseInt(wearableParams[0]),
                wearableParams[1], 
                Double.parseDouble(wearableParams[2]),
                wearableParams[3], wearableParams[4],
                wearableParams[5], wearableParams[6],
                wearableParams[7], wearableParams[8],
                wearableParams[9], wearableParams[10]);
            //System.out.println(wearables[counter].getCompanyName());
            companyNames.add(wearables[counter].getCompanyName());
            companyRankings.add(wearables[counter].getRanking());
            wearablePrices.add(wearables[counter].getPrice());
            counter += 1;
        }
    }

    //----------------------------------------------------------------------------------------
    //Accessors
    //----------------------------------------------------------------------------------------
    
    /**
     * Method getNamesIndex returns an array of indexes.
     *
     * @param order; get indexes in order or reverse.
     * @return an array of positions.
     */
    public int[] getNamesIndex(boolean order){
        int[] result;
        if (order){
            result = companyNames.getPositionData();
        } else {
            int[] tempArray = companyNames.getPositionData();
            for (int i = 0; i < tempArray.length/2; i++){
                int temp = tempArray[i];
                tempArray[i] = tempArray[tempArray.length - i - 1];
                tempArray[tempArray.length - i - 1] = temp;  
            }
            result = tempArray;
        }
        return result;
    }

    /**
     * Method getRankingsIndex returns an array of indexes.
     *
     * @param order; get indexes in order or reverse.
     * @return an array of positions.
     */
    public int[] getRankingsIndex(boolean order){
        int[] result;
        if (order){
            result = companyRankings.getPositionData();
        } else {
            int[] tempArray = companyRankings.getPositionData();
            for (int i = 0; i < tempArray.length/2; i++){
                int temp = tempArray[i];
                tempArray[i] = tempArray[tempArray.length - i - 1];
                tempArray[tempArray.length - i - 1] = temp;  
            }
            result = tempArray;
        }
        return result;
    }

    /**
     * Method getPriceIndex returns an array of indexes.
     *
     * @param order; get indexes in order or reverse.
     * @return an array of positions.
     */
    public int[] getPriceIndex(boolean order){
        int[] result;
        if (order){
            result = wearablePrices.getPositionData();
        } else {
            int[] tempArray = wearablePrices.getPositionData();
            for (int i = 0; i < tempArray.length/2; i++){
                int temp = tempArray[i];
                tempArray[i] = tempArray[tempArray.length - i - 1];
                tempArray[tempArray.length - i - 1] = temp;  
            }
            result = tempArray;
        }
        return result;
    }

    /**
     * Method getWearable
     *
     * @param index; index of needed wearable
     * @return The return value
     */
    public Wearable getWearable(int index){
        return wearables[index];
    }

    /**
     * Method getPrices returns a TreeMap of prices.
     *
     * @return wearablePrices; a TreeMap of prices.
     */
    public TreeMap<Double> getPrices(){
        return wearablePrices;
    }

    /**
     * Method getRankings returns a TreeMap of rankings.
     *
     * @return companyRankings; a TreeMap of rankings.
     */
    public TreeMap<Integer> getRankings(){
        return companyRankings;
    }

    /**
     * Method getCompanyNames returns a TreeMap of company names.
     *
     * @return companyRankings; a TreeMap of company names.
     */
    public TreeMap<String> getCompanyNames(){
        return companyNames;
    }

    //----------------------------------------------------------------------------------------
    //Other methods
    //----------------------------------------------------------------------------------------
    
    /**
     * Method generateCSV writes wearables in a given order to a csv file it creates 
     * with a given name.
     *
     * @param positions; array of indexes referring to the order of the wearables to wite.
     * @param fileName; name of file to be written to
     */
    public void generateCSV(int[] positions, String fileName){
        try {
            FileWriter write = new FileWriter(new File(fileName + ".csv"));
            for (int i = 0; i < positions.length; i++){
                Wearable wearable = wearables[positions[i]];
                String line = "";
                line += wearable.getRanking() + "," ;
                line += "\"" + (wearable.getName().replaceAll("\"", "\"\"")) + "\",";
                line += wearable.getPrice() + ",";
                line += "\"" + (wearable.getBodyLocation().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getCategory().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getCompanyName().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getURL().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getLocation().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getCity().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getState().replaceAll("\"", "\"\"")) + "\",";
                line += "\"" + (wearable.getCountry().replaceAll("\"", "\"\"")) + "\"\n";
                write.write(line);
                //System.out.print(line);
            }
            write.close();
        } catch(IOException e){
            System.out.println("error writiing to file.");
        }
    }
}