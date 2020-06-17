import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

class Main
{
    private IDGenerator IDGen;
    private ArrayList<User> allUsers;
    Scanner scanner = new Scanner(System.in);
    //constructor
    Main()
    {
        IDGen = new IDGenerator();
        allUsers = new ArrayList<>();
    }
    //main
    void runMain()
    {
        handleUserMenuChoices();
        
    }
    //
    void displayCalendarScreenSettings(User newUser, int calId)
    {  
        Calendar newCal = newUser.getCalendar(calId);
        //timeZone settings
        System.out.println("Select Time Zone for Calendar ( 1: Hawaiian Standard Time (HST) ");
        System.out.println("                                2: Alaska Standard Time (AST) ");
        System.out.println("                                3: Pacific Standard Time (PST) ");
        System.out.println("                                4: Mountain Standard Time (MST) ");
        System.out.println("                                5: Central Standard Time (CST) ");
        System.out.println("                                6: Eastern Standard Time (EST) ) ");
        
        System.out.print("Type Selection: \t");
        int timeZone = Integer.parseInt(scanner.nextLine());
        newCal.getScreen().adjustTimeZone(timeZone);

        //darkMode settings
        System.out.println("Select Screen Mode for Calendar ");
        System.out.println("       D: Dark Theme            ");
        System.out.println("       L: Light Theme           ");
        System.out.print("Type Selection: \t");
        String screenMode = scanner.nextLine();
        switch(screenMode.toLowerCase())
        {
            case("d"):
                newCal.getScreen().turnOnDarkMode();
                break;
            case("l"):
                newCal.getScreen().turnOffDarkMode();
                break;
        }
        
        //visualization settings
        System.out.println("Select Visual Mode for Calendar ");
        System.out.println("       Y: Yearly                ");
        System.out.println("       M: Monthly               ");
        System.out.println("       W: Weekly                ");
        System.out.println("       D: Daily                 ");
        System.out.print("Type Selection: \t");
        
        String visualMode = scanner.nextLine();
        switch(visualMode.toLowerCase())
        {
            case("y"):
                newCal.getScreen().changeVisualizationMode("yearly");
                break;
            case("m"):
                newCal.getScreen().changeVisualizationMode("monthly");
                break;
            case("w"):
                newCal.getScreen().changeVisualizationMode("weekly");
                break;
            case("d"):
                newCal.getScreen().changeVisualizationMode("daily");
                break;
        }
    }
    
    void displayCalendarSettings(User newUser, int calId)
    {
        //publicVisibility settings
        System.out.println("Choose Calendar Visibility Settings ");
        System.out.println("         Y: Public                  ");
        System.out.println("         N: Private                 ");
        System.out.print("Type Selection: \t");
        
        Calendar newCal = newUser.getCalendar(calId);
        String v = scanner.nextLine();
        switch(v.toLowerCase())
        {
            case("y"):
                newCal.setPublicVisibility('Y');
                break;
            case("n"):
                newCal.setPublicVisibility('N');
                break;
        }
        
    }
    void addCalendar(User newUser)
    {
        int calId = newUser.addCalendar(false);
        displayCalendarScreenSettings(newUser, calId);
        displayCalendarSettings(newUser, calId);
        System.out.println("CALENDAR ADDED SUCCESSFULLY.");
        System.out.print("Press 'M' to return to Main Menu\n");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
    }
    
    void deleteCalendar(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select A Calendar: \t");
        int calID = Integer.parseInt(scanner.nextLine());
        newUser.removeCalendar(calID);
        System.out.println("CALENDAR (WITH ID: " + calID + ") DELETED SUCCESSFULLY.");
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
        
    }
    void updateCalendar(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select A Calendar: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        displayCalendarScreenSettings(newUser, calId);
        displayCalendarSettings(newUser, calId);
        System.out.println("CALENDAR (WITH ID: " + calId + ") UPDATED SUCCESSFULLY.");
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
        
    }
    void viewCalendar(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.println("Type selection: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calId);
        Screen myScreen = myCal.getScreen();
        if ("yearly".equals(myScreen.visualizationMode))
        {
            myScreen.displayCalendarYearly();
        }
        if ("monthly".equals(myScreen.visualizationMode))
        {
            System.out.println("Please type month that you would like to view (format -- March): \t");
            String format = scanner.nextLine();
            myScreen.displayCalendarMonthly(format.toLowerCase());
        }     
        if( "daily".equals(myScreen.visualizationMode))
        {
            System.out.println("Please type the Month and Day that you would like to view ( format -- March 3) : \t");
            String format = scanner.nextLine();
            String s[] = format.split("");
            String month = s[0];
            int day = Integer.parseInt(s[1]);
            myScreen.displayCalendarDaily(month.toLowerCase(), day);
        }
    }
    void addEvent(User newUser)
    {
        displayEventInfoMenu(newUser);
        System.out.println("EVENT ADDED SUCCESSFULLY");
        System.out.println("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
    }
    void updateEvent(User newUser)
    {
        displayEventMenu(newUser);
        displayEventInfoUpdateMenu(newUser); 
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
        
    }
    void deleteEvent(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.println("Type Selection for Calendar in which the Event Will Be Deleted: \t");
        int calID = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calID);
        displayAllEventsForCalendarMenu(newUser, calID);
        System.out.print("Type Selection: \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        myCal.removeEvent(eventId);
        System.out.println("EVENT DELETED SUCCESSFULLY");
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
        
    }
    void viewEvent(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.println("Type Selection for Calendar in which the Events Will be Viewed");
        int calID = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calID);
        displayAllEventsForCalendarMenu(newUser, calID);
        System.out.print("Type Selection: \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        displayEvent(myCal, eventId);
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
    }
    void searchForEvent(User newUser)
    {
        System.out.println("Search Events For Keyword: \t");
        String query = scanner.nextLine();
        HashMap<Integer, Event> events = newUser.searchEvents(query);
        if (events.size() > 0)
        {
            System.out.println("----------THESE WERE THE EVENTS FOUND----------");
            for(Entry<Integer, Event> e: events.entrySet())
            {
                System.out.println("  EVENT ID: " + e.getKey() + "  EVENT TITLE: " + e.getValue().getEventInfo().getTitle());
            }
        }
        else
        {
            System.out.println("There were no events that matched your query.");
        }
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
        
    }
    void addUserToEvent(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select A Calendar: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        displayAllEventsForCalendarMenu(newUser, calId);
        System.out.print("Type Selection: \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        System.out.print("Please Enter the Id of The User that Will Be Added: \t");
        int userId = Integer.parseInt(scanner.nextLine());
        User newU = new User();
        newU.setUserID(userId);
        Calendar myCal = newUser.getCalendar(calId);
        myCal.getEvent(eventId).addUser(newU);
        System.out.println("A User has Been Successfully Added to Event:" + myCal.getEvent(eventId).getEventInfo().getTitle());
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        } 
        
    }
    void addToInterestedEvents(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select a Calendar: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the name of the Category you wish to name your list of Interested Events \n \t Example: Birthday Parties");
        String category = scanner.nextLine();
        Calendar myCal = newUser.getCalendar(calId);
        myCal.addCategory(category.toLowerCase());
        System.out.println("Category name: " + category.toLowerCase() + " made successfully.");
        displayAllEventsForCalendarMenu(newUser, calId);
        System.out.println("Type Selection for Event to be added to Category " + category.toLowerCase() +": \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        myCal.addEventToCategory(eventId, category.toLowerCase());
        System.out.println("Event:" + myCal.getEvent(eventId).getEventInfo().getTitle() + " added to Category: " + category.toLowerCase());
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }       
        
    }
    void viewInterestedEvents(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select a Calendar: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calId);
        System.out.println("THESE ARE THE AVAILABLE CATEGORIES FOR THIS CALENDAR");
        for(Entry<String, ArrayList<Integer>> e: myCal.categories.entrySet())
        {
            System.out.println(e.getKey());
        }
        System.out.println("Please enter the name of category which you would like to view: ");
        String category = scanner.nextLine();
        System.out.println("The following Events were found: :");
        for(Integer eventId: myCal.getCategory(category.toLowerCase()))
        {
            System.out.println(" ID: " + eventId + " TITLE: " + myCal.getEvent(eventId).getEventInfo().getTitle());
        }
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        } 
        
    }
    void changeCalendarView(User newUser)
    {
        displayAllCalendarMenu(newUser);
        System.out.print("Select A Calendar: \t");
        int calId = Integer.parseInt(scanner.nextLine());
        displayCalendarScreenSettings(newUser, calId);
        System.out.println("The Following Calendar ID: " + calId + " View Settings have been changed." );
        System.out.print("Press 'M' to return to Main Menu \t");
        String mainMenu = scanner.nextLine();
        switch(mainMenu.toLowerCase())
        {
            case ("m"):
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }   
    }
    
    //menu displays

    void displayEvent(Calendar myCal, int eventId)
    {
        Event myEvent = myCal.getEvent(eventId);
        EventInfo myInfo = myEvent.getEventInfo();
        System.out.println("---------EVENT INFORMATION-------");
        System.out.println("   EVENT TITLE: " + myInfo.getTitle() );
        System.out.println("   START TIME: " + myInfo.getStartTime());
        System.out.println("   END TIME: " + myInfo.getEndTime());
        for (Entry<Month, Integer> e: myInfo.getStartDate().entrySet())
        {
            System.out.println( "   START DATE: " + e.getKey().name + " " + e.getValue());
        } 
        for (Entry<Month, Integer> e: myInfo.getEndDate().entrySet())
        {
            System.out.println( "   END DATE: " + e.getKey().name + " " + e.getValue());
        } 
        System.out.println("---------------------------------");
        if (myEvent.hasEventTimer())
        {
            Timer myTimer = myEvent.getTimer();
            myTimer.display();
        }
    }
    void displayEventMenu(User newUser)
    {
        // handles what an event can do
        //display event menu
        //get menu id
        displayAllCalendarMenu(newUser);
        System.out.print("Type Selection: \t");
        int calID = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calID);
        displayAllEventsForCalendarMenu(newUser, calID);
        System.out.print("Type Selection: \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        Event myEvent = myCal.getEvent(eventId);
        //add Timer
        System.out.println("Would you like to keep a timer for this Event?");
        System.out.println( "        Y: Yes                N: No          ");
        System.out.print("Type Selection: \t");
        String choice = scanner.nextLine();
        switch(choice.toLowerCase())
        {
            case("y"):
                //call add Timer
                myEvent.getEventInfo().setStartDateTimeObject();
                myEvent.getEventInfo().setEndDateTimeObject();
                myEvent.addTimer(myEvent.getEventInfo()); 
                break;
            case("n"):
                break;       
        }

    }
    void displayEventInfoUpdateMenu(User newUser)
    {
        
        //System.out.println("What Change to Your Event Would You Like To Make? ");
        displayAllCalendarMenu(newUser);
        System.out.println("Type Selection for Calendar in which the Event Will Be Updated: \t");
        int calID = Integer.parseInt(scanner.nextLine());
        Calendar myCal = newUser.getCalendar(calID);
        displayAllEventsForCalendarMenu(newUser, calID);
        System.out.println("Type Selection for Event That Will Be Update: \t");
        int eventId = Integer.parseInt(scanner.nextLine());
        Event myEvent = myCal.getEvent(eventId);
        System.out.println("What Change to Your Event Would You Like To Make? ");
        System.out.println("\t\t\t 1: Change Event Title\n\t\t\t 2: Change Start Time\n\t\t\t 3: Change End Time\n");
        System.out.println("Type Selection: \t");
        EventInfo myInfo = myEvent.getEventInfo();
        System.out.println("THIS IS WHAT IS THE END DATE OBJECT: " + myInfo.endDateObject.toString());
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice)
        {
            case (1):
                System.out.println("Enter Event Title:\t");
                String title = scanner.nextLine();
                myInfo.setTitle(title);
                break;
            case (2):
                System.out.println("Enter Start Time for Event\n\t( format -> hh:ss:mm a -> 12:00:00 pm )\n\t( format -> hh:ss:mm a -> 01:00:00 am :\t");
                String startTime = scanner.nextLine();
                myInfo.setStartTime(startTime); 
                break;
            case (3):
                System.out.println("Enter End Time for Event\n\t( format -> hh:ss:mm a -> 12:00:00 pm )\n\t( format -> hh:ss:mm a -> 01:00:00 am :\t");
                String endTime = scanner.nextLine();
                myInfo.setEndTime(endTime);
                break;

            //didn't have enough time to go through and add changeStartDate/changeEndDate     
        }
    }
    void displayEventInfoMenu(User newUser)
    {
        EventInfo EI = new EventInfo();
        displayAllCalendarMenu(newUser);
        System.out.println("Type Selection for Calendar in which the Event Will Be Added: \t");
        int calID = Integer.parseInt(scanner.nextLine());
        //newUser.getCalendar(calID).addEvent(EI, false); // sets darkTheme to false at first
        
        //set Event Title
        System.out.println("Enter Event Title:\t");
        String title = scanner.nextLine();
        EI.setTitle(title);
        
        //set Start Time
        System.out.println("Enter Start Time for Event\n\t( format -> hh:ss:mm a -> 12:00:00 pm )\n\t( format -> hh:ss:mm a -> 01:00:00 am :\t");
        String startTime = scanner.nextLine();
        EI.setStartTime(startTime);

        
        //set End Time
        System.out.println("Enter End Time for Event\n\t( format -> hh:ss:mm a -> 12:00:00 pm )\n\t( format -> hh:ss:mm a -> 01:00:00 am :\t");
        String endTime = scanner.nextLine();
        EI.setEndTime(endTime);
        
        //set Start Date
        System.out.println("Enter Start Date for Event\n\t ( format -> month day -> March 26 )\n\t ( format -> June 12) :\t");
        String input = scanner.nextLine();
        String s[] = input.split(" ");
        String monthName = s[0];
        int monthDay = Integer.parseInt(s[1]);
        Month myMonth = new Month(monthName);
        HashMap<Month, Integer> startDate = new HashMap<>();
        startDate.put(myMonth, monthDay);
        EI.startDate = startDate;
        EI.setStartDate(startDate);
        EI.setStartDateTimeObject();
        
        //set End Date
        System.out.println("Enter End Date for Event\n\t ( format -> month day -> March 26 )\n\t ( format -> June 12) :\t");
        String input2 = scanner.nextLine();
        String s2[] = input2.split(" ");
        String monthN = s2[0];
        int monthD = Integer.parseInt(s2[1]);
        Month myM = new Month(monthN);
        HashMap<Month, Integer> endDate = new HashMap<>();
        endDate.put(myM, monthD);
        EI.endDate = endDate;
        EI.setEndDate(endDate);
        EI.setEndDateTimeObject();
        
        newUser.getCalendar(calID).addEvent(EI, false); // sets darkTheme to false at first
        
        //set RepeatWeekly
        //System.out.println("Would you like for this event to be repeated weekly?");
        

    }
    void displayAllCalendarMenu(User newUser)
    {
       //menu that displays all of the user's calendars and their ids so that 
        // they can acess infromation for that calendar on main menu
        HashMap<Integer, Calendar> calendars  = newUser.getCalendars();
        System.out.println("---------- CALENDARS AVAILABLE -----------");
        for(Integer key: calendars.keySet())
        {
            System.out.println("                CALENDAR ID: " + key);
        }
        System.out.println("----------------------------------------");
        
    }
    void displayAllEventsForCalendarMenu(User newUser, int calID)
    {
        //displays all events in a calendar
        System.out.println("-------------EVENTS IN CALENDAR----------");
        System.out.println("    EVENT-ID               EVENT NAME    ");      
        for (Entry<Integer, Event> e: newUser.getCalendar(calID).getEvents().entrySet())
        {
            System.out.println("       " + e.getKey() + "           "+e.getValue().getEventInfo().getTitle());
        }
        System.out.println("-----------------------------------------");
    }
    void displayUserMenu()
    {
        System.out.println("-------------------------------------------");
        System.out.println("       Welcome to The Calendars App        ");
        System.out.println("Instructions: Select Key corresponding to  ");
        System.out.println("    the instruction you would like to do.  ");
        System.out.println("Ex: Press 'A' on keyboard to Add an Account");
        System.out.println("                                           ");
        System.out.println("                 MAIN MENU                 ");
        System.out.println("                                           ");
        System.out.println("            A: Add User Account            ");
        System.out.println("            E: Exit Calendars              ");
        System.out.println("                                           ");
        System.out.println("-------------------------------------------");
   
    }
    void showMainMenu()
    {
        System.out.println("-------------------------------------------");
        System.out.println("              USER MAIN MENU               ");
        System.out.println("                                           ");
        System.out.println(" CALENDAR OPTIONS ---                      ");
        System.out.println("             A: Add Calendar               ");
        System.out.println("             D: Delete Calendar            ");
        System.out.println("             U: Update Calendar            ");
        System.out.println("             C: Change Calendar View       ");
        System.out.println("             X: View Calendar              ");
        System.out.println("                                           ");
        System.out.println(" EVENT OPTIONS ---                         ");
        System.out.println("             E: Add Event                  ");
        System.out.println("             P: Update Event               ");
        System.out.println("             V: Delete Event               ");
        System.out.println("             S: Search for Event           ");
        System.out.println("             L: View Shared Events -N/A    ");
        System.out.println("             O: View Event                 ");
        System.out.println("             Q: Add To Interested Events   ");
        System.out.println("             K: View Interested Events     ");
        System.out.println("             Y: Add User to Event          ");
        System.out.println("-------------------------------------------");
        
        
    }
    void handleMainMenuChoices(User newUser)
    {
        showMainMenu();
        System.out.print(" Make Menu Selection: \t");
        String input2 = scanner.nextLine();
        switch(input2.toLowerCase())
        {
            case ("a"): //done
                addCalendar(newUser); 
                break;
            case ("d"): //done
                deleteCalendar(newUser);
                break;
            case ("u"): //done
                updateCalendar(newUser);
                break;
            case ("e"):
                addEvent(newUser); // done
                break;
            case ("p"):
                updateEvent(newUser); //done
                break;
            case ("v"):
                deleteEvent(newUser); // done
                break;
            case ("s"):
                searchForEvent(newUser); //done
                break;
            case ("l"):
                //viewSharedEvents();
                break;
            case ("c"): // done
                changeCalendarView(newUser);
                break;
            case ("x"): //done
                viewCalendar(newUser);
                break;
            case("o"): //done
                viewEvent(newUser);
                break;
            case("q"):
                addToInterestedEvents(newUser);
                break;
            case("k"):
                viewInterestedEvents(newUser);
                break;
            case("y"): // done
                addUserToEvent(newUser);
                break;
        }
    }
    void handleUserMenuChoices()
    {
        displayUserMenu();
        System.out.print(" Make Menu Selection: \t");
        String input1 = scanner.nextLine();
        switch(input1.toLowerCase())
        {
            case("a"):
                
                int userId = IDGen.generateNewID('U');
                User newUser = new User();
                newUser.setUserID(userId);
                handleMainMenuChoices(newUser);
                break;
            default:
                System.exit(0);
        }
    }
    
}