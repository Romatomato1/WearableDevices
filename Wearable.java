/**
 * An object to store data of a wearabnle product.
 *
 * @author Roman Gofman
 * @version 6/2/2020
 */
public class Wearable
{
    //----------------------------------------------------------------------------------------
    //Instance Variables
    //----------------------------------------------------------------------------------------
    
    /** The ranking of the wearable. */
    private int ranking;

    /** The name of the wearable. */
    private String name;

    /** The price of the wearable. */
    private double price;

    /** Where on the body the wearable is worn. */
    private String bodyLocation;

    /** The category of the wearable. */
    private String category;

    /** The name of the company that produces the wearable. */
    private String companyName; 

    /** The url of the company that produces the wearable. */
    private String url;

    /** The location where the wearable is made. */
    private String location;

    /** The city where the wearable is made. */
    private String city;

    /** The state where the wearable is made. */
    private String state;

    /** The country where the wearable is made. */
    private String country;

    //----------------------------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------------------------
    
    /**
     * Wearable Constructor
     *
     * @param ranking       The ranking of the wearable.
     * @param name          The name of the wearable.
     * @param price         The price of the wearable.
     * @param bodyLocation  Where on the body the wearable is worn.
     * @param category      The category of the wearable.
     * @param companyName   The name of the company that produces the wearable.
     * @param url           The url of the company that produces the wearable.
     * @param location      The location where the wearable is made.
     * @param city          The city where the wearable is made.
     * @param state         The state where the wearable is made.
     * @param country       The country where the wearable is made.
     */
    public Wearable(int ranking, 
                    String name, 
                    double price, 
                    String bodyLocation, 
                    String category, 
                    String companyName, 
                    String url, 
                    String location, 
                    String city, 
                    String state, 
                    String country) {
        // initialise instance variables
        this.ranking = ranking;
        this.name = name; 
        this.price = price; 
        this.bodyLocation = bodyLocation;
        this.category = category; 
        this.companyName = companyName; 
        this.url = url; 
        this.location = location;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    //----------------------------------------------------------------------------------------
    //Accessors
    //----------------------------------------------------------------------------------------
    
    /**
     * Method getRanking    returns the ranking of the wearable.
     *
     * @return ranking; the ranking of the wearable.
     */
    public int getRanking(){
        return this.ranking;
    }

    /**
     * Method getName    returns the name of the wearable.
     *
     * @return name; the name of the wearable.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method getPrice  returns the price of the wearable.
     *
     * @return price; the price of the wearable.
     */
    public Double getPrice(){
        return this.price;
    }

    /**
     * Method getBodyLocation   returns where on the body the wearable is worn.
     *
     * @return bodyLocation; where on the body the wearable is worn.
     */
    public String getBodyLocation(){
        return this.bodyLocation;
    }

    /**
     * Method getCategory   returns the category of the wearable.
     *
     * @return category; the category of the wearable.
     */
    public String getCategory(){
        return this.category;
    }

    /**
     * Method getCompanyName    returns the name of the company that produces the wearable.
     *
     * @return companyName; the name of the company that produces the wearable.
     */
    public String getCompanyName(){
        return this.companyName;
    }

    /**
     * Method getURL    returns the url of the company that produces the wearable.
     *
     * @return url; the url of the company that produces the wearable.
     */
    public String getURL(){
        return this.url;
    }

    /**
     * Method getLocation   returns the location where the wearable is made.
     *
     * @return location; the location where the wearable is made.
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Method getCity   returns the city where the wearable is made.
     *
     * @return city; the city where the wearable is made.
     */
    public String getCity(){
        return this.city;
    }

    /**
     * Method getState  returns the state where the wearable is made.
     *
     * @return state; the state where the wearable is made.
     */
    public String getState(){
        return this.state;
    }

    /**
     * Method getCountry    returns the country where the wearable is made.
     *
     * @return country; the country where the wearable is made.
     */
    public String getCountry(){
        return this.country;
    }
}