import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;

class User
{
    int userID;
    IDGenerator idGenerator;
    HashMap<Integer, Calendar> calendars;
    ArrayList<Event> eventsSharedToUser;
    //constructor
    User()
    {
        // the user's id is initialized in the main class, so that each user
        // can be tracked in the main class
        idGenerator = new IDGenerator();
        calendars = new HashMap<>();
        eventsSharedToUser = new ArrayList<>();
    }
    //gettrs
    Calendar getCalendar(int calendarID) // -- i added this 
    {
        return calendars.get(calendarID);
    }
    HashMap<Integer, Calendar> getCalendars()
    {
        return calendars;
    }
    //settrs
    void setUserID(int userId)
    {
        userID = userId;
    }
    // other methods -- 
    int addCalendar(boolean darkTheme) /// figure out what to do with darkTheme -- i added the returning of calendarId
    {
        int calendarId = idGenerator.generateNewID('C');
        Calendar newCal = new GregorianCalendar();
        newCal.setCalendarID(calendarId);
        calendars.put(calendarId, newCal);
        return calendarId;
    }
    void removeCalendar(int calendarID)
    {
        calendars.remove(calendarID);
    }

    void displaySharedEvents()
    {
        // display all of the events that have a public setting and have a non empty list of users 
        
    }

    HashMap<Integer, Event> searchEvents(String query) // changed the return value to be able to return multiple options for queries that have multiple 
            //events related to it
    {
        //for every calendar this user has, check each calendar's events hash map for a title 
        //containing the query
        //if str1.toLowerCase().contains(str2.toLowerCase()) -- then add this event into the array list 
        HashMap<Integer, Event> containQuery = new HashMap<>();
        for(Calendar cals: calendars.values())
        {
            for ( Event events: cals.getEvents().values())
            {
                //events
                String eventTitle = events.getEventInfo().getTitle();
                if (eventTitle.toLowerCase().contains(query.toLowerCase()))
                {
                    containQuery.put(events.getEventID(), events);
                }
            }
            
        }
        return containQuery; //will be empty if there are no events that match this query
    }
}