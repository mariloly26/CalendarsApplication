// The ‘Month’ class simply keeps track of its string name, and its integer number 
// of days. It has a single method ‘isWithinDayMax’ which returns a boolean if 
// any particular day fits within this Month’s day count. 
import java.util.HashMap;
class Month
{
    String name;
    int days;
    //constructor
    Month(String newName)
    {
        name = newName;
        days = 30;
    }
    //gettrs
    String getMyFormat() // used to make Date object in EventInfo for StartDate/Time EndDate/Time
    {
        HashMap<String, String> myFormatter = new HashMap<>();
        myFormatter.put("january", "01");
        myFormatter.put("february", "02");
        myFormatter.put("march", "03");
        myFormatter.put("april", "04");
        myFormatter.put("may", "05");
        myFormatter.put("june", "06");
        myFormatter.put("july", "07");
        myFormatter.put("august", "08");
        myFormatter.put("september", "09");
        myFormatter.put("october", "10");
        myFormatter.put("november", "11");
        myFormatter.put("december", "12");
        return myFormatter.get(name.toLowerCase());
        
    }
    //other methods --
    boolean isWithinDayMax(int aDay)
    {
        return true;
    }
    
}