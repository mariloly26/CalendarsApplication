import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;

class Calendar
{
    int calendarID;
    IDGenerator idGenerator;
    ArrayList<Month> months;
    int monthCount;
    HashMap<Integer, Event> events;
    HashMap<String, ArrayList<Integer>> categories;
    private HashMap<Integer, User> users;
    Screen screen;
    boolean publicVisibility;
    //constructor
    Calendar()
    {
        idGenerator = new IDGenerator();
        months =  new ArrayList<>();
        monthCount = 12; // default is gregorian, this is an assumption
        events = new HashMap<>();
        categories = new HashMap<>();
        users = new HashMap<>();
        screen = new Screen(this);
        publicVisibility = false; // assume that the calendar is private unless the user explicitly makes it public
    }
    //gettrs
    Screen getScreen()
    {
        return screen;
    }
    //settrs

    void setCalendarID(int calendarId)
    {
        calendarID = calendarId;
    }
    void setPublicVisibility(char choice)
    {
        switch(choice)
        {
            case ('Y'):
                publicVisibility = true;
                break;
            case ('N'):
                publicVisibility = false;
                break;
                
        }
    }
    Event getEvent(int eventId)
    {
        return events.get(eventId);
    }
    //other methods --
    void addEvent(EventInfo e, boolean repeat)
    {
        Event myEvent = new Event();
        myEvent.setEventInfo(e);
        int eventid = idGenerator.generateNewID('E');
        myEvent.setEventID(eventid);
        events.put(eventid, myEvent); // 
    }
    void removeEvent(int eventID)
    {
        events.remove(eventID);
    }
    void updateEvent(int eventID, EventInfo EI)
    {
        Event updatedEvent = events.get(eventID);
        updatedEvent.setEventInfo(EI);
    }
    void addUser(User u)
    {
        users.put(u.userID, u);
    }
    void removeUser(int userID)
    {
        users.remove(userID);
    } 
    
     //come back and deal with this category stuff because idk tbh
    void addCategory(String category) // making the assumption that this will allow the user to view subset of events they 
            //are interested in within this particular calendar
    {
     //assumption: keys are eventID and values are eventtitle 
        categories.put(category, null);
    }
    ArrayList<Integer> getCategory(String category) 
    {
        return categories.get(category); // returns an event id
    }

    HashMap<Integer, Event> getEvents()
    {
        return events;
    }
    void addEventToCategory(int eventID, String category)
    {
        ArrayList<Integer> myCategoryList = categories.get(categories);
        myCategoryList.add(eventID);
    }
    // perhaps a way to display a calendar should lie within here so that each calendar can be displayed in its own way
    // each inherited calendar can then override this display function in order to make it their own
    void setCalendar()
    {
        //this is also overriden by every child class that inherits Calendar.java
    }

}