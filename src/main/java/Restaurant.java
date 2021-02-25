import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime present=getCurrentTime();
        int openHour;
        int closeHour;
        int presentHour;
        if(openingTime.getHour()==0)
            openHour=24;
        else
            openHour= openingTime.getHour();
        if(closingTime.getHour()==0)
            closeHour=24;
        else
            closeHour= closingTime.getHour();
        if(present.getHour()==0)
            presentHour=24;
        else
            presentHour= present.getHour();
        if(presentHour==openHour){
            if(present.getMinute() > openingTime.getMinute())
                return true;
        }
        if(presentHour==closeHour){
            if(present.getMinute() < closingTime.getMinute())
                return true;
        }
        if(openHour<closeHour) {

            if ((presentHour > openHour) && (presentHour < closeHour)) {
                return true;
            }
        }
        if(openHour>closeHour){

            if((presentHour>=1 && presentHour<closeHour) || (presentHour>openHour && presentHour<=24)){
                return true;
            }
        }
        return false;
    }
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
