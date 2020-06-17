//this class will be used to test each class
import java.util.Scanner;
import java.util.HashMap;
class Driver
{
    public static void main(String args[]){
        /*
        //TESTING Calendar.java, Month.java, Timer.java
        EventInfo myInfo = new EventInfo();
        myInfo.setTitle("Doctor's Appointment");
        myInfo.setStartTime("01:00:00 pm");
        Month m = new Month("June"); // 06
        HashMap<Month, Integer> date = new HashMap<>();
        date.put(m, 12);
        myInfo.setStartDate(date);
        myInfo.setStartDateTimeObject();
        myInfo.setEndTime("2:00:00 pm");
        myInfo.setEndDate(date);
        myInfo.setEndDateTimeObject();
        Timer timer = new Timer(myInfo);
        
        timer.display();
        */
        
        
        //RUNS THE WHOLE PROGRAM
        Main main = new Main();
        main.runMain();
    }
    
}