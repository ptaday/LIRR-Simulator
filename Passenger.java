/**
 * @author Pushkar Taday
 */

/**
 * This class represents a passenger with a id, arrival time and a boolean for isFirstClass.
 */

public class Passenger {

    int id;
    int arrivalTime;
    boolean isFirstClass;

    /**
     * This is a parameterized constructor which gets invoked when object of the class is instantiated with the given set of parameters.
     * @param id
     * id of a passenger
     * @param arrivalTime
     * arrival time of the passenger
     * @param isFirstClass
     * whether the passenger is travelling first class or not
     */

    Passenger(int id,int arrivalTime, boolean isFirstClass)
    {
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.isFirstClass=isFirstClass;
    }

    /**
     * This is an accessor method for passengers arrival time.
     * @return
     * arrivalTime of the passenger
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * This is an accessor method for passengers Id.
     * @return
     * id of the passenger
     */

    public int getId() {
        return id;
    }

    /**
     * This is an accessor method for boolean isFirstClass
     * @return
     * whether passenger is travelling first class or not
     */

    public boolean getIsFirstClass()
    {
        return isFirstClass;
    }

    /**
     * This is a mutator method for passengers arrival time
     * @param arrivalTime
     * arrivalTime of the passenger
     */

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * This is a mutator method for passengers travelling class
     * @param firstClass
     * travelling class of the passenger
     */
    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    /**
     * This is a mutator method for passengers id
     * @param id
     * id of the passenger
     */

    public void setId(int id) {
        this.id = id;
    }


}
