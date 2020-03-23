package Amazon.StackAndQueues;


// OWN IMPLEMENTED SOLUTION - without queues https://practice.geeksforgeeks.org/problems/circular-tour/1
public class CircularTour {

    static int tour(int petrol[], int distance[])
    {
        int startIndex = 0;

        int i = 0;
        int petrolLeft = 0;
        boolean found = false;
        while (startIndex < petrol.length) {

            petrolLeft += petrol[i] - distance[i];

            if(petrolLeft < 0) {
                petrolLeft = 0;
                startIndex++;
                i = startIndex;
            } else {
                i = i == petrol.length - 1 ? 0 : i+1;
                if(i == startIndex) {
                    found = true;
                    break;
                }
            }

        }

        if(found)
            return startIndex;

        return -1;
    }

    public static void main(String[] args) {
        int petrol[] = {4,6 ,7 ,4};
        int distance[] = { 6,5,3,5};

        System.out.println("ANSWER  -> " + tour(petrol, distance));
    }
}
