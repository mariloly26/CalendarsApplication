// The ‘Event’ class is given its eventID member variable by the Calendar class,
// and its eventInfo. It has a list of Users associated to this Event, these 
// include users whom this Event has been shared to and any users who have this 
// Event through the parent Calendar. (Users can be added through its corresponding
// method, ‘addUser’). The Event can add a Timer, saved in its ‘myTimer’ member 
// variable, and can return event details with its getEventDetails method.
import java.util.ArrayList;

class Event
{
    int eventID;
    EventInfo eventInfo;
    ArrayList<User> users;
    Timer myTimer;
    boolean hasTimer; // i added this
    //constructor
    Event()
    {
        eventInfo = new EventInfo();
        users = new ArrayList<>();
    }
    //copy constructor
    Event(Event event)
    {
        eventID = event.eventID;
        eventInfo = event.eventInfo;
        users = event.users;
        myTimer = event.myTimer;
        hasTimer = false;
    }
    //gettrs
    int getEventID()
    {
        return eventID;
    }
    EventInfo getEventInfo()
    {
        return eventInfo;
    }
    ArrayList<User> getUsers()
    {
        return users;
    }
    Timer getTimer()
    {
        return myTimer;
    }
    boolean hasEventTimer()
    {
        return hasTimer;
    }
    //settrs
    void setEventID(int Id)
    {
        eventID = Id;
    }
    void setEventInfo(EventInfo EI)
    {
        eventInfo.title = EI.title;
        eventInfo.startTime = EI.startTime;
        eventInfo.endTime = EI.endTime;
        eventInfo.startDate = EI.startDate;
        eventInfo.endDate = EI.endDate;
        eventInfo.repeatWeekly = EI.repeatWeekly;
    }
    //other methods --
    void addUser(User u)
    {
        users.add(u);
    }
    void addTimer(EventInfo EI)
    {
        myTimer = new Timer(EI); // makes sure to time this particular event
        hasTimer = true;
    }


}