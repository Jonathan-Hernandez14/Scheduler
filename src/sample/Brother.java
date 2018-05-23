package sample;

public class Brother<T> {

    private String name;
    private int uniqueID;
    private boolean underage;
    private boolean male;

    /**
     * Constructor to make Brother object
     * @param name Name of the individual. First and Last in that order
     * @param id Number sequence that distinguishes an individual. Also is place in the ArrayList of Brothers when list
     *           of all participating brothers are made.
     * @param underage Boolean stating if the person is underage, if so then this person cannot be paired with another
     *                 person that is also underage
     * @param male Boolean stating if the person is male or female. Pairings can only be same-gender there will be
     *             exceptions if not enough valid pairs are made.
     */
    public Brother(String name, int id, boolean underage, boolean male) {
        this.name = name;
        this.uniqueID = id;
        this.underage = underage;
        this. male = male;
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
    public boolean isMale() {
        return male;
    }
}
