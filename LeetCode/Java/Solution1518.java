public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        while (empty > numExchange - 1) {
            int newBottles = empty / numExchange;
            total += newBottles;
            empty = empty % numExchange + newBottles;
        }
        return total;
    }
}

/*
 * 1518. Water Bottles
 * Question: Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle. The operation of drinking a full water bottle turns it into an empty bottle.
 * - Return the maximum number of water bottles you can drink.
 * 
 * You do drink then exchange then drink then excahnge and so on. 
 */