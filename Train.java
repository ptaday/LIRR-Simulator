/**
 * @author Pushkar Taday
 */

/**
 * This class represents a train on which passengers travel.
 */
public class Train {

    private int numberOfTrains;

    private int firstCapacity;
    private int secondCapacity;
    private int timeUntilNextArrival;

    private int[] trainsFirstClassCounter;
    private int[] trainsSecondClassCounter;

    int[] storeId;

    /**
     * This is a parameterized constructor for the object of the class which is instantiated with the appropriate parameters
     * @param numberOfTrains
     * the number of trains entered by the user
     * @param firstCapacity
     * maximum number of people that can travel through first class
     * @param secondCapacity
     * maximum number of people that can travel through the second class
     * @param timeUntilNextArrival
     * time after which train arrives
     */
    Train(int numberOfTrains, int firstCapacity, int secondCapacity, int timeUntilNextArrival) {
        this.numberOfTrains = numberOfTrains;
        this.firstCapacity = firstCapacity;
        this.secondCapacity = secondCapacity;
        this.timeUntilNextArrival = timeUntilNextArrival;

    }

    int[] count;

    /**
     * This method helps initialize some of the member variables for this class.
     */
    public void initialization() {
        count = new int[numberOfTrains];

        for (int i = 0; i < count.length; i++)
            count[i] = 4;

        trainsFirstClassCounter = new int[numberOfTrains];
        trainsSecondClassCounter = new int[numberOfTrains];

    }

    String[] Stations = {"Mineola", "Hicksville", "Syosset", "Huntington"};

    int countOfTrainLeavingOneStation = 0;

    /**
     * This method simulates the scenario of the train for each min.
     */
    public void simulateTimeStep() {
        int c = 0;
        int time = 0;
        int time2 = 0;

        for (int i = 0; i < numberOfTrains; i++) {
            if (LIRRSimulator.i % 5 == 0) {
                if (i == 0)
                    countOfTrainLeavingOneStation++;


                if (c < countOfTrainLeavingOneStation) {
                    if (count[i] != 0) {

                        System.out.println("Train " + (i + 1) + " arrives at " + Stations[count[i] - 1] + ". There are " + trainsFirstClassCounter[i] + " passengers in first class and " + trainsSecondClassCounter[i] + " passengers in second class");

                        boolean flag=false;

                        if(LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek()==null) {
                            System.out.print("Passengers embarking in first class: ");
                            System.out.println("none");
                        }

                        else
                        {
                            System.out.print("Passengers embarking in first class: ");

                            int firstClassRemainingSpace=0; int check=0;

                            firstClassRemainingSpace=firstCapacity- trainsFirstClassCounter[i];

                            if(firstClassRemainingSpace>LIRRSimulator.objOfStations[count[i] - 1].getTotalFirstClassPassengers()) {
                                check = LIRRSimulator.objOfStations[count[i] - 1].getTotalFirstClassPassengers();
                                trainsFirstClassCounter[i]=trainsFirstClassCounter[i]+LIRRSimulator.objOfStations[count[i] - 1].getTotalFirstClassPassengers();
                            }

                            else {
                                check = firstClassRemainingSpace;
                                trainsFirstClassCounter[i]=firstCapacity;
                            }

                            for(int m=0;m<check;m++)
                            {
                                if(check-m==1)
                                    System.out.println("P"+ LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek().getId());

                                  else
                                System.out.print("P"+ LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek().getId()+", ");

                                Passenger temp=LIRRSimulator.objOfStations[count[i]-1].getFirstClass().dequeue();

                                LIRRSimulator.objOfStations[count[i]-1].firstClassPeopleServed++;

                                LIRRSimulator.objOfStations[count[i]-1].firstClassTotalWait+=LIRRSimulator.i-temp.getArrivalTime();

                            }
                        }

                        if(secondCapacity<=trainsSecondClassCounter[i])
                        {
                            System.out.print("Passengers embarking in second class: ");
                            System.out.println("none");
                        }

                        else
                        {
                            System.out.print("Passengers embarking in second class: ");

                            boolean secondFlag=false;



                            if(LIRRSimulator.objOfStations[count[i]-1].getFirstClass().count!=0)
                            {

                                int secondClassRemainingSpace=0; int check=0;

                                secondClassRemainingSpace=secondCapacity- trainsSecondClassCounter[i];
                                secondFlag=true;
                                if(LIRRSimulator.objOfStations[count[i]-1].getFirstClass().count<secondClassRemainingSpace) {
                                    check = LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().count;
                                    trainsSecondClassCounter[i]=trainsSecondClassCounter[i]+LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().count;
                                   flag=true;
                                }

                                else {
                                    check = secondClassRemainingSpace;
                                    trainsSecondClassCounter[i]=secondCapacity;

                                }

                                for(int n=0;n<check;n++)
                                {
                                    if(check-n==1) {
                                        if(flag) {
                                            System.out.println("P" + LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek().getId());
                                        }
                                        else
                                            System.out.print("P" + LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek().getId());
                                    }

                                    else
                                        System.out.print("P"+ LIRRSimulator.objOfStations[count[i] - 1].getFirstClass().peek().getId()+", ");

                                    Passenger temp=LIRRSimulator.objOfStations[count[i]-1].getFirstClass().dequeue();

                                    LIRRSimulator.objOfStations[count[i]-1].firstClassPeopleServed++;

                                    LIRRSimulator.objOfStations[count[i]-1].firstClassTotalWait+=LIRRSimulator.i-temp.getArrivalTime();

                                }
                            }

                            if(LIRRSimulator.objOfStations[count[i] - 1].getSecondClass().peek()==null&&(!secondFlag))
                                System.out.println("none");

                            else
                            {
                                int secondClassRemainingSpace=0;

                                secondClassRemainingSpace=secondCapacity- trainsSecondClassCounter[i];
                                 int checkC=0;

                                if(secondClassRemainingSpace>LIRRSimulator.objOfStations[count[i] - 1].getTotalSecondClassPassengers()) {
                                    checkC = LIRRSimulator.objOfStations[count[i] - 1].getTotalSecondClassPassengers();
                                    trainsSecondClassCounter[i]=trainsSecondClassCounter[i]+LIRRSimulator.objOfStations[count[i] - 1].getTotalSecondClassPassengers();
                                }

                                else {
                                    checkC = secondClassRemainingSpace;
                                    trainsSecondClassCounter[i]=secondCapacity;
                                }

                                for(int m=0;m<checkC;m++)
                                {
                                    if(checkC-m==1)
                                        System.out.println("P"+ LIRRSimulator.objOfStations[count[i] - 1].getSecondClass().peek().getId());

                                    else
                                        System.out.print("P"+ LIRRSimulator.objOfStations[count[i] - 1].getSecondClass().peek().getId()+", ");

                                    Passenger temp=LIRRSimulator.objOfStations[count[i]-1].getSecondClass().dequeue();;

                                    LIRRSimulator.objOfStations[count[i]-1].secondClassPeopleServed++;

                                    LIRRSimulator.objOfStations[count[i]-1].secondClassTotalWait+=LIRRSimulator.i-temp.getArrivalTime();

                                }
                            }
                        }

                        System.out.println();
                        count[i]=count[i]-1;
                        c++;

                    } else {
                        if (count[i] == 0)
                            System.out.println("Train " + (i + 1) + " has completed its course.");
                    }
                } else {
                    if (count[i] == 0)
                        System.out.println("Train " + (i + 1) + " has completed its course.");

                    else {

                        time = time + 5;
                        System.out.println("Train " + (i + 1) + " will arrive at " + Stations[count[i] - 1] + " in " + time + " minutes.");
                    }
                }

            } else {
                if (count[i] == 0)
                    System.out.println("Train " + (i + 1) + " has completed its course.");

                else {
                    System.out.println("Train " + (i + 1) + " arrives at Station " + Stations[count[i] - 1] + " in " + ((time2) + (5 - LIRRSimulator.i % 5)) + " minutes");
                    time2 = time2 + 5;
                }
            }

        }
    }
}

