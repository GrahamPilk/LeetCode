import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings {
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, TreeSet<String>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }
        for(int i = 0; i < foods.length; i++) {
            String cuisine = cuisines[i];
            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                int r1 = foodToRating.get(a);
                int r2 = foodToRating.get(b);
                if (r1 != r2) return r2 - r1;
                return a.compareTo(b);
            }));
            cuisineFoods.get(cuisine).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(cuisine);
        set.remove(food);
        foodToRating.put(food, newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

 /*
  * Goal: Create a system to 
  - Keep track of foods, their cuisines and ratings. 
  - Efficiently update a foods rating. 
  - Retrieve the highese rated food in a given cuisine. 

  Explanation: 
  1. Maintain three mappings. 
    - food to cuisine (to know a foods cuisine)
    - food to rating (to quickly update/look up rating)
    - cuisine to ordered set of foods (sorted by rating, then lexicographically)
  2. When Initializing 
    - Populate the above maps with the input data. 
    - Use a custom comparator in the ordered set, Higher rating first, if ratings tie then lex. smaller name first. 
  3. changeRating(food, newRating)
    - Remove the food from its cuisine set. 
    - Update its rating. 
    - Reinsert the food with the updated rating. 
  4. highestRated(cuisine)
    - Return the first element in the cuisines ordered set. 

  Complexity: 
    1. Time Complexity O(log(n))
    2. Space Complexity O(n)
  */