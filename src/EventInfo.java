// The ‘EventInfo’ class stores all relevant event details as member variables 
// for easy passing and reference.
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.TimeZone;
class EventInfo
{
    String title;
    String startTime; // java.util.time/date
    String endTime; // java.util.time/date
    HashMap<Month, Integer> startDate; // java.util.time/date
    HashMap<Month, Integer> endDate; // java.util.time/date
    boolean repeatWeekly;
    //i added these 
    Date startDateObject;
    Date endDateObject;
    SimpleDateFormat formatter = new SimpleDateFormat("M-dd-yyyy hh:mm:ss a");
    
    //constructor
    EventInfo()
    {
        repeatWeekly = false;
        title = "";
        startTime = "";
        endTime = "";
        startDate = new HashMap<>();
        endDate = new HashMap<>();
        startDateObject = new Date();
        endDateObject = new Date();
    }
    EventInfo(EventInfo EI) // finish this copy constructor for Event.java
    {
        title = EI.title;
        startTime = EI.startTime;
        endTime = EI.endTime;
        startDate = EI.startDate;
        endDate = EI.endDate;
        repeatWeekly = EI.repeatWeekly;
    }
    //gettrs
    String getTitle()
    {
        return title;
    }
    String getStartTime()
    {
        
        return startTime;
    }
    String getEndTime()
    {
        return endTime;
    }
    HashMap<Month, Integer> getStartDate()
    {
        return startDate;
    }
    HashMap<Month, Integer> getEndDate()
    {
        return endDate;
    }
    Date getStartDateObject() // i added this
    {
        return startDateObject;
    }
    Date getEndDateObject() // i added this
    {
        return endDateObject;
    }
    boolean getRepeatWeekly()
    {
        return repeatWeekly;
    }
    //settrs
    void setTitle(String newTitle)
    {
        title = newTitle;
    }
    void setStartTime(String newStart)
    {
        startTime = newStart;
        
    }
    void setEndTime(String newEnd)
    {
        endTime = newEnd;
    }
    void setStartDate(HashMap<Month, Integer> newStart)
    {
        startDate = newStart;
    }
    void setEndDate(HashMap<Month, Integer> newEnd)
    {
        endDate = newEnd;
    }
    void setRepeatWeekly(String choice)
    {
        switch(choice)
        {
            case("y"):
                repeatWeekly = true;
                break;
            case("n"):
                repeatWeekly = false;
                break;
        }
    }
    //i added the following --- 
    void setStartDateTimeObject() // just call these functions when the input for startTime, startDate have been received
    {
        //take string "hh:mm:ss a"
        //take <Month, Integer> and add a year yourself  + concatenate startTime
        String dateStr = "";
        for(Entry<Month, Integer> m: startDate.entrySet())
        {
            Month myMonth = m.getKey(); // get translation from January to 01 -- etc.
            int myVal = m.getValue();
            dateStr += myMonth.getMyFormat() + "-" + myVal + "-"; // returns the translation inside month from January to 01
           
            
        }
        dateStr += "2020 ";
        dateStr += startTime.toUpperCase();
        //instantiating Date Object based on User Input
        try {
            startDateObject = formatter.parse(dateStr);
            System.out.println(dateStr);
        } catch (ParseException ex) {
            System.out.print("Incorrect Start Date Format");
            Logger.getLogger(EventInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setEndDateTimeObject()
    {
        //take string "hh:mm:ss a"
        //take <Month, Integer> and add a year yourself  + concatenate startTime
        String dateStr = "";
        for(Entry<Month, Integer> m: endDate.entrySet())
        {
            Month myMonth = m.getKey(); // get translation from January to 01 -- etc.
            int myVal = m.getValue();
            dateStr += myMonth.getMyFormat() + "-" + myVal + "-"; // returns the translation inside month from January to 01
           
            
        }
        dateStr += "2020 ";
        dateStr += endTime.toUpperCase();
        //instantiating Date Object based on User Input
        try {
            endDateObject = formatter.parse(dateStr);
            //System.out.println(dateStr);
        } catch (ParseException ex) {
            System.out.print("Incorrect End Date Format");
            Logger.getLogger(EventInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void setTimeZoneObject(String tZ)
    {
        formatter.setTimeZone(TimeZone.getTimeZone(tZ));
    }
}