/**
 * @author Pushkar Taday
 */


/**
 * This class represents a station where passengers embark the train from
 */

public class Station {

    private static int passengerCount=1;

    private int totalFirstClassPassengers=0;
    private int totalSecondClassPassengers=0;

    private PassengerQueue firstClass;
    private PassengerQueue secondClass;

    private BooleanSource firstArrival;
    private BooleanSource secondArrival;

    public int firstClassPeopleServed=0;

    public int secondClassPeopleServed=0;


    public double firstClassTotalWait=0.0;

    public double secondClassTotalWait=0.0;

    /**
     * This is a parameterized constructor for this class which gets instantiated with the appropriate parameters
     * @param firstArrivalProbability
     * The probability of passengers to arrive in the first class
     * @param secondArrivalProbability
     * The probability of passengers to arrive in the second class
     */

    Station(double firstArrivalProbability,double secondArrivalProbability)
    {
        firstArrival=new BooleanSource(firstArrivalProbability);
        secondArrival=new BooleanSource(secondArrivalProbability);

        firstClass=new PassengerQueue();
        secondClass=new PassengerQueue();

    }

    /**
     * This method simulates the scenario at the station for each min.
     */
    public void simulateTimestep()
    {

        if(firstArrival.occurs()&&LIRRSimulator.i<=LIRRSimulator.lastArrivalTime)
        {
            System.out.println("First class passenger "+passengerCount+" ID arrives");
            Passenger passenger=new Passenger(passengerCount,LIRRSimulator.i,true);
            firstClass.enqueue(passenger);
            passengerCount++;
            totalFirstClassPassengers++;
        }

        else
        {
            System.out.println("No first class passenger arrives");
        }

        if(secondArrival.occurs()&&LIRRSimulator.i<=LIRRSimulator.lastArrivalTime)
        {
            System.out.println("Second class passenger "+passengerCount+" ID arrives");
            Passenger passenger=new Passenger(passengerCount,LIRRSimulator.i,false);
            secondClass.enqueue(passenger);
            passengerCount++;
            totalSecondClassPassengers++;
        }

        else
        {
            System.out.println("No second class passenger arrives");
        }

        System.out.println("Queues:");
        System.out.print("First "+firstClass);
        System.out.println();
        System.out.println("Second "+secondClass);
        System.out.println();
    }

    /**
     * This is an accessor method for the total numbers of passengers which travelled through the trains during entire simulation.
     * @return
     * total number of passengers
     */

    public static int getPassengerCount() {
        return passengerCount;
    }

    /**
     * This is an accessor method for the total numbers of passengers which travelled through the first class of the trains during entire simulation.
     * @return
     * total number of first class passengers
     */

    public int getTotalFirstClassPassengers() {
        return firstClass.getCount();
    }

    /**
     * This is an accessor method for the total numbers of passengers which travelled through the second class of the trains during entire simulation.
     * @return
     * total number of second class passengers
     */
    public int getTotalSecondClassPassengers() {
        return secondClass.getCount();
    }

    /**
     * This is an accessor method for the queue of passengers in the first class
     * @return
     * first class passengers queue
     */
    public PassengerQueue getFirstClass() {
        return firstClass;
    }

    /**
     * This is an accessor method for the queue of passengers in the second class
     * @return
     * second class passengers queue
     */
    public PassengerQueue getSecondClass() {
        return secondClass;
    }


}
