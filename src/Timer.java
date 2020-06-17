import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Timer
{
    EventInfo eventInfo;
    Date startDate;
    Date endDate;
    public static int SECONDS_IN_A_DAY = 24*60*60;
    //constructor
    Timer(EventInfo newInfo) 
    {
        eventInfo = newInfo;
        startDate = eventInfo.getStartDateObject();
        endDate = eventInfo.getEndDateObject();
    }
    //gettrs
    EventInfo getEventInfo()
    {
        return eventInfo;
    }
    //other methods --
    void display()
    {
     //make a date object that holds information about NOW
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     formatter.format(endDate);
     Date date = new Date();
     formatter.format(date);
     long diff = endDate.getTime() - date.getTime();// fix this when you make the date object
     long diffSec = diff/1000;
     long days = diffSec / SECONDS_IN_A_DAY;
     long secondsDay = diffSec % SECONDS_IN_A_DAY;
     long seconds = secondsDay % 60;
     long minutes = (secondsDay / 60) % 60;
     long hours = (secondsDay / 3600);
     System.out.println(" ----------------------- COUNTDOWN TIMER ----------------------- ");
     System.out.println("              EVENT TITLE: " + eventInfo.getTitle() + "          ");
     System.out.println("              EVENT DATE: "+ endDate.toString() + "                             ");
     System.out.println("                         TIME REMAINING:                         ");
     System.out.printf("\t\t\t   Days: %d \n \t\t\t   Hours: %d \n \t\t\t   Minutes: %d \n \t\t\t   Seconds: %d \n", days, hours, minutes, seconds);
     System.out.println(" --------------------------------------------------------------- " );
    }
   
}