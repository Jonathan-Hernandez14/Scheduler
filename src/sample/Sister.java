package sample;

public class Sister {
    private String name;
    private int uniqueID;
    private boolean underage;


    /**
     * Constructor to make Brother object
     * @param name Name of the individual. First and Last in that order
     * @param id Number sequence that distinguishes an individual. Also is place in the ArrayList of Sister when list
     *           of all participating sisters are made.
     * @param underage Boolean stating if the person is underage, if so then this person cannot be paired with another
     *                 person that is also underage
     */
    public Sister(String name, int id, boolean underage) {
        this.name = name;
        this.uniqueID = id;
        this.underage = underage;

    }

    /**
     * Getter methods for the information that will be used to classify and sort brothers
     * They do not take parameters
     */
    public String getName() {
        return name;
    }
    public int getID() {
        return uniqueID;
    }
    public boolean isUnderAge() {
        return underage;
    }
}
