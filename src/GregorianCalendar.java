// The ‘GregorianCalendar’ class inherits all of Calendar’s functionalities but 
// simply sets a constant arraylist of Months, associated with the appropriate 
// Gregorian Calendar months and days, as well as a constant ‘monthCount’ of 12.
// This class helps easier create a GregorianCalendar specifically instead of 
// keeping track of which Calendars have the same kind of Months & monthCount.
import java.util.ArrayList;
import java.util.HashMap;

class GregorianCalendar extends 
        Calendar
{
    int monthCount;
    ArrayList<Month> months; 
    HashMap<Integer, String> organizedMonths = new HashMap<>();
    GregorianCalendar()
    {
        super();
        monthCount = 12;
        months = new ArrayList<>();
    }
    void setCalendar()
    {
        //add all integers and their corresponding month names to hashmap
        organizedMonths.put(1, "January");
        organizedMonths.put(2, "February");
        organizedMonths.put(3, "March");
        organizedMonths.put(4, "April");
        organizedMonths.put(5, "May");
        organizedMonths.put(6, "June");
        organizedMonths.put(7, "July");
        organizedMonths.put(8, "August");
        organizedMonths.put(9, "September");
        organizedMonths.put(10, "October");
        organizedMonths.put(11, "November");
        organizedMonths.put(12, "December");
        
        for (int i = 1; i <= monthCount; i++)
        {
            String month = organizedMonths.get(i);
            months.add(new Month(month));
        }
    }

    
    
}