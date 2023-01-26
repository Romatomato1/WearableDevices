/**
 * Object to keep track of index.
 *
 * @author Roman Gofman
 * @version 6/7/2020
 */
public class Index
{
    /** The index value that is kept track of. */
    public int index;

    /**
     * Constructor for objects of class Index
     */
    public Index()
    {
        index = 0;
    }
    
    /**
     * Method getIndex gets the index
     *
     * @return index; the index
     */
    public int getIndex(){
        return this.index;
    }
    
    /**
     * Method setIndex changes the index value()
     *
     * @param value; the new index value
     */
    public void setIndex(int value){
        this.index = value;
    }
}
