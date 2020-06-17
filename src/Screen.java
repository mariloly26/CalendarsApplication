import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
class Screen
{
    boolean darkMode;
    String visualizationMode;
    String timeZone;
    Calendar myCalendar;  // i made the decision to change this rather than holding a class instance itself Calendar myCalendar
    
    // constructor 
    Screen(Calendar instance)
    {
        darkMode = false;
        visualizationMode = "month";
        timeZone = "PST";
        myCalendar = instance;
        
    }
    // gettrs
    String getTimeZone() // i added this
    {
        return timeZone;
    }
    // settrs
    // other methods -- 
    void turnOnDarkMode()
    {
        darkMode = true;
    }
    void turnOffDarkMode()
    {
        darkMode = false;
    }
    void adjustTimeZone( int newTimeZone ) // changed the input to integer so 
            //that the input can be easier and have no errors in regards to 
            //having the user input a string specifying the timeZone
    {

        HashMap<Integer, String> tzones = new HashMap<>();
        tzones.put(1, "US/Hawaii");
        tzones.put(2, "US/Alaska");
        tzones.put(3, "US/Pacific");
        tzones.put(4, "US/Mountain");
        tzones.put(5, "US/Central");
        tzones.put(6, "US/Eastern");
        
        timeZone = tzones.get(newTimeZone);
        //for every event in Calender.getEvents()
        //get the event info for each event and set the timeZone to newTimeZone.
        for(Event event: myCalendar.getEvents().values())
        {
            EventInfo info = event.getEventInfo();
            info.setTimeZoneObject(timeZone);
        }
    }
    void showSubset(String category ) 
    {
        System.out.println("-------- EVENTS FOR CATEGORY: " + category + " ---------");
        for(Integer eventId :myCalendar.getCategory(category))
        {
            System.out.println("\tEVENT ID: " + eventId);
            System.out.println("\tEVENT TITLE: " + myCalendar.getEvent(eventId));
        }
    }
    void changeVisualizationMode( String VM )
    {
        //calls either Calendar's month setting (all year)
        //or calls Month's weekly setting 
        //or calls Month's daily setting
        visualizationMode = VM;
        
    }
    void displayCalendarYearly()
    {
        //get a list of all of the events for the entire year being January 2020-December 2020
        //(have not implemented the ability to have a calendar past hte year 2020) -- go back and fix this in EventInfo
        HashMap<Integer, Event> events = myCalendar.getEvents();
        for(Entry<Integer, Event> e: events.entrySet())
        {
          HashMap<Month, Integer> month =  e.getValue().getEventInfo().getStartDate();
          for(Month m: month.keySet())
          {
              if("January".equals(m.name))
              {
                  System.out.println("JANUARY:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("February".equals(m.name))
              {
                  System.out.println("FEBRUARY:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("March".equals(m.name))
              {
                  System.out.println("MARCH:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("April".equals(m.name))
              {
                  System.out.println("APRIL:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("May".equals(m.name))
              {
                  System.out.println("MAY:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("June".equals(m.name))
              {
                  System.out.println("JUNE:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("July".equals(m.name))
              {
                  System.out.println("JULY:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("August".equals(m.name))
              {
                  System.out.println("AUGUST:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("September".equals(m.name))
              {
                  System.out.println("SEPTEMBER");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("October".equals(m.name))
              {
                  System.out.println("OCTOBER:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("November".equals(m.name))
              {
                  System.out.println("NOVEMBER:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
              if("December".equals(m.name))
              {
                  System.out.println("DECEMBER:");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
                                                                                                                                                          
              
          }
        }
        
    }
    void displayCalendarMonthly(String month)
    {
       //display all events that are within month name for a calendar
        HashMap<Integer, Event> events = myCalendar.getEvents();
        for(Entry<Integer, Event> e: events.entrySet())
        {
          HashMap<Month, Integer> m =  e.getValue().getEventInfo().getStartDate();
          for(Month mo: m.keySet())
          {
              if(month.equals(mo.name))
              {
                  System.out.println(month.toUpperCase() + ":");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }  
          }
        }
    }
    void displayCalendarWeekly(String week)
    {
        // not implemented
    }
    void displayCalendarDaily(String month_name, int day)
    {
        //display all events that are within day name for a calendar   
        HashMap<Integer, Event> events = myCalendar.getEvents();
        for(Entry<Integer, Event> e: events.entrySet())
        {
          HashMap<Month, Integer> m =  e.getValue().getEventInfo().getStartDate();
          for(Entry<Month, Integer> date : m.entrySet())
          {
              if(date.getKey().name.equals(day) && date.getValue().equals(day));
              {
                  System.out.println(month_name.toUpperCase() + ":");
                  System.out.println("\t" + e.getValue().getEventInfo().getTitle());
                  System.out.println("");
              }
          }
        }
    }
}