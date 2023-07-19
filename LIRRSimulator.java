/**
 * @author Pushkar Taday
 * SBU ID:114375166
 * Recitation:04
 */

package Homework4;

import java.util.Scanner;

/**
 * This method acts as a simulator for the trains. The simulator runs until the last train has reached the last station
 */
public class LIRRSimulator {

    public static int i;
    public static String[] stations;
    public static Station[] objOfStations;
    public static int lastArrivalTime;

    /**
     * The method is the main method which runs the simulation
     * @param args
     */

    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);

            System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");

            System.out.println();

            System.out.println("Mineola");

            System.out.print("Please enter first class arrival probability: ");
            double firstProbabilityMineola = input.nextDouble();

            System.out.print("Please enter second class arrival probability: ");
            double secondProbabilityMineola = input.nextDouble();

            Station Mineola = new Station(firstProbabilityMineola, secondProbabilityMineola);

            System.out.println();

            System.out.println("Hicksville");

            System.out.print("Please enter first class arrival probability: ");
            double firstProbabilityHicksville = input.nextDouble();

            System.out.print("Please enter second class arrival probability: ");
            double secondProbabilityHicksville = input.nextDouble();

            Station Hicksville = new Station(firstProbabilityHicksville, secondProbabilityHicksville);

            System.out.println();

            System.out.println("Syosset");

            System.out.print("Please enter first class arrival probability: ");
            double firstProbabilitySyosset = input.nextDouble();

            System.out.print("Please enter second class arrival probability: ");
            double secondProbabilitySyosset = input.nextDouble();

            Station Syosset = new Station(firstProbabilitySyosset, secondProbabilitySyosset);

            System.out.println();

            System.out.println("Huntington");

            System.out.print("Please enter first class arrival probability: ");
            double firstProbabilityHuntington = input.nextDouble();

            System.out.print("Please enter second class arrival probability: ");
            double secondProbabilityHuntington = input.nextDouble();

            Station Hungtington = new Station(firstProbabilityHuntington, secondProbabilityHuntington);

            System.out.println();

            System.out.print("Please enter first class capacity: ");
            int firstClassCapacity = input.nextInt();

            System.out.println();

            System.out.print("Please enter second class capacity: ");
            int secondClassCapacity = input.nextInt();

            System.out.println();

            System.out.print("Please enter number of trains: ");
            int numberOfTrains = input.nextInt();

            System.out.println();

            int oneTrain = 15;

            boolean check = true;

            while (check) {

                System.out.print("Please enter last arrival time of passengers: ");
                lastArrivalTime = input.nextInt();

                if (lastArrivalTime < (15 + ((numberOfTrains - 1) * 5)))
                    check = false;

                else
                    System.out.println("The last arrival is after last station arrival of last train. Hence, enter again.");

            }

            System.out.println();

            System.out.println("Begin Simulation:");
            System.out.println("---------------------------------------");


            stations = new String[]{"Mineola", "Hicksville", "Syosset", "Hungtington"};

            objOfStations = new Station[]{Mineola, Hicksville, Syosset, Hungtington};

            Train train = new Train(numberOfTrains, firstClassCapacity, secondClassCapacity, 5);

            train.initialization();


            for (i = 0; i <= (15 + ((numberOfTrains - 1) * 5)); i++) {

                System.out.println("Time " + i);
                System.out.println();

                System.out.println("Station Overview:");

                System.out.println();

                for (int j = 0; j < 4; j++) {

                    System.out.println(stations[j]);
                    objOfStations[j].simulateTimestep();


                }

                System.out.println("Trains:");

                System.out.println();


                train.simulateTimeStep();

                System.out.println("----------------------------------");


            }

            System.out.println("At the end of the simulation:");

            System.out.println();

            int totalFirstClassPassengersWithoutASeat = 0;
            int totalSecondClassPassengersWithoutASeat = 0;

            for (int i = 0; i < 4; i++) {
                totalFirstClassPassengersWithoutASeat = totalFirstClassPassengersWithoutASeat + objOfStations[i].getFirstClass().count;
                totalSecondClassPassengersWithoutASeat = totalSecondClassPassengersWithoutASeat + objOfStations[i].getSecondClass().count;
            }
            System.out.println("A total of " + Station.getPassengerCount() + " passengers were served, " + totalFirstClassPassengersWithoutASeat + " first class passengers were left without a seat, " + totalSecondClassPassengersWithoutASeat + " second class passengers were left without a seat.");

            System.out.println();

            for (int i = 0; i < 4; i++) {

                double firstClassAverageWaitTime = 0.0;
                double secondClassAverageWaitTime = 0.0;

                int firstClassLeftWithout = 0;
                int secondClassLeftWithout = 0;

                firstClassLeftWithout = objOfStations[i].getTotalFirstClassPassengers();
                secondClassLeftWithout = objOfStations[i].getTotalSecondClassPassengers();

                firstClassAverageWaitTime = Math.round((objOfStations[i].firstClassTotalWait) / objOfStations[i].firstClassPeopleServed);
                secondClassAverageWaitTime = Math.round((objOfStations[i].secondClassTotalWait) / objOfStations[i].secondClassPeopleServed);


                System.out.println("At " + stations[i] + ", " + objOfStations[i].firstClassPeopleServed + " first class passengers were served with an average wait time of " + firstClassAverageWaitTime + " min, " + objOfStations[i].secondClassPeopleServed + " second class passengers were served with an average wait time of " + secondClassAverageWaitTime + " min. " + firstClassLeftWithout + " first class passengers and " + secondClassLeftWithout + " second class passengers were left without a seat.");

                System.out.println();

            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }


    }
















