/**
 * @author Pushkar Taday
 * SBU ID:114375166
 * Recitation:04
 */

package Homework4;

/**
 * This class helps create nodes for the queue passengers list.
 */

public class PassengerListNode {

    private Passenger data;
    private PassengerListNode next;

    /**
     * This is a parameterized constructor which gets invoked when object of the class is instantiated with the given set of parameters.
     * @param data
     * the data which is passed through the parameter
     * @throws IllegalArgumentException
     * if the data entered is null
     */
    PassengerListNode(Passenger data)throws IllegalArgumentException
    {
        if(data==null)
            throw new IllegalArgumentException();

        else
        this.data=data;

        next=null;
    }

    /**
     * This is an accessor method for the data of the node
     * @return
     * data in the node
     */

    public Passenger getData() {
        return data;
    }

    /**
     * This is an accessor method for the next node in the singly linked list
     * @return
     */
    public PassengerListNode getNext() {
        return next;
    }

    /**
     * This is mutator method which sets the data in the node
     * @param data
     * data of the node
     */

    public void setData(Passenger data) {
        this.data = data;
    }

    /**
     * This is a mutator method which sets the reference of the next node
     * @param next
     * reference of the next node
     */
    public void setNext(PassengerListNode next) {
        this.next = next;
    }
}
