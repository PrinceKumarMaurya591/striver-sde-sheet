package Array1;

public class StockBuySell {

    public static void main(String[] args) {
        StockBuySell sbs = new StockBuySell();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = sbs.maxProfit(prices);
        System.out.println("Maximum profit is: " + maxProfit);
    }

    // Function to find the maximum profit from buying and selling a
    // stock at most once. The function takes an array of stock prices
    // where prices[i] is the price on day i and returns the maximum
    // profit achievable by buying on one day and selling on a later day.
    // The time complexity of the function is O(n), where n is the
    // number of days. The space complexity is O(1) as we are using a
    // constant amount of extra space.

    // Approach: We iterate through the array once, keeping track of
    // the minimum price seen so far. For each day, we calculate the
    // profit if we sold on that day (current price - minimum price
    // seen so far) and update the maximum profit accordingly. The
    // minimum price is updated whenever we find a lower price.
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if sold today and update maximum profit
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

}
