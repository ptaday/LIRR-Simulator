/**
 * @author Pushkar Taday
 * SBU ID:114375166
 * Recitation:04
 */

package Homework4;

/**
 * The class represents boolean source which helps with the probability of the people at the station
 */
public class BooleanSource {

        private double probability;

    /**
     * This a parameterized constructor for this class
     * @param p
     * the probability entered by the user
     * @throws IllegalArgumentException
     * if its not between 0.0 and 1.0
     */
    public BooleanSource(double p) throws IllegalArgumentException {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException();
        probability = p;
    }

    /**
     * This method return whether a passenger arrives at the station or not
     * @return
     * a boolean value
     */
        public boolean occurs() {
            return (Math.random() < probability);
        }

}
