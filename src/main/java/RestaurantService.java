import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for(Restaurant r:restaurants){
            if(restaurantName.equals(r.getName())){
                return r;
            }
        }
        throw new restaurantNotFoundException(restaurantName +" is not found");
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    public float totalOrder(ArrayList<String>items,Restaurant r){
        float total_price=0f;
        Item item_obj;
        for(String item:items){
            item_obj=r.getItemObj(item);
            total_price=item_obj.getPrice()+total_price;
        }
        return total_price;
    }

}
