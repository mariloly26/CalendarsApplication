

class IDGenerator
{
    int calendarIDCount;
    int eventIDCount; 
    int userIDCount;
    //constructor
    IDGenerator()
    {
        calendarIDCount = 0;
        eventIDCount = 0; 
        userIDCount = 0;
    }
    //gettrs
    int getCalendarIdCount()
    {
        return calendarIDCount;
 
    }
    int getEventIdCount(){
        return eventIDCount;
    }
    int getUserIdCount()
    {
        return userIDCount;
    }
    // no settrs
    //other methods -- 
    int generateNewID(char Type) // returns 0 for incorrect input 
    {
        switch (Type){
            case ('C'):
                calendarIDCount++;
                return calendarIDCount;
            case ('E'): 
                eventIDCount++;
                return eventIDCount;
            case ('U'):
                userIDCount++;
                return userIDCount;
        }
        return 0;
    }
}