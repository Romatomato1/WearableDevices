/**
 * Executes other classes in a main method
 *
 * @author Roman Gofman
 * @version 6/2/2020
 */
public class Main
{
    public static void main(String[] args){
        WearableManager wm = new WearableManager();
        
        //In order by price
        // wm.generateCSV(wm.getPriceIndex(true), "wearables");
        
        //Reverse order by price
        // wm.generateCSV(wm.getPriceIndex(false), "wearables");
        
        //In order by ranking
        // wm.generateCSV(wm.getRankingsIndex(true), "wearables");
        
        //Reverse order by ranking
        // wm.generateCSV(wm.getRankingsIndex(false), "wearables");
        
        //In order by ranking
        wm.generateCSV(wm.getNamesIndex(true), "wearables");
        
        //Reverse order by ranking
        //wm.generateCSV(wm.getNamesIndex(false), "wearables");

        //Range from 1 - 15 (inclusively)
        //wm.generateCSV(wm.getRankings().getPositionData(1, 15), "wearables");

    }
}
