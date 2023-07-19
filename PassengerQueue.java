/**
 * @author Pushkar Taday
 */

/**
 * This class represents queue of passengers
 */
public class PassengerQueue {

    PassengerListNode head;
    PassengerListNode tail;
     int count;

    /**
     * This method helps to add passengers in the queue
     * @param p
     * the passenger to be added in the queue
     */
    public void enqueue(Passenger p){
        if(p==null)
            throw new IllegalArgumentException("The system contains no information regarding the passenger.");

        else
        {
            PassengerListNode node=new PassengerListNode(p);

            if(head==null)
            {
                head=node;
                tail=node;

                head.setNext(null);
                count++;
            }

            else
            {
                tail.setNext(node);
                tail=node;
                count++;

            }

        }
    }

    /**
     * This method helps to remove a passenger from the queue
     * @return
     * the passenger removed
     */
    public Passenger dequeue() {

        if (head == null)
            return null;

        else
        {
            PassengerListNode returningNode = head;

            head=head.getNext();

            returningNode.setNext(null);
            count--;

            return returningNode.getData();

        }

    }

    /**
     * This method prints the passengers in the passengers queue
     * @return
     * String containing passengers in the queue
     */
    public String toString() {


        String s = "[";

        PassengerListNode tempHead = head;


        if (tempHead == null)
            return "[empty]";

        else {
            while (tempHead.getNext() != null) {
                s = s + "P" + tempHead.getData().getId() + "@T" + LIRRSimulator.i + ",";
                tempHead = tempHead.getNext();
            }


            s = s + "P" + tempHead.getData().getId() + "@T" + LIRRSimulator.i;

            return s;


        }
    }

    /**
     * This method removes the passenger at the head of the queue
     * @return
     * Passenger at the head of the queue
     */

    public Passenger peek(){

        if(head==null)
            return null;

        else {
            Passenger temp = this.head.getData();
            return temp;
        }

    }

    /**
     * This method checks whether the passenger queue is empty or not
     * @return
     * a boolean value
     */
    public boolean isEmpty(){

        if(count==0)
            return true;

        else
            return false;

    }

    /**
     * This method is an accessor method for the number of passengers in the queue
     * @return
     * the count of the passengers in the queue
     */
    public int getCount() {
        return count;
    }
}
