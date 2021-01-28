import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QueryClass {
	static Scanner scanner;
	static EventScheduler sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new EventScheduler();
		
		
		performOperation(); //API calls
		

	}


	
	public static void performOperation() {
		while(true) {
			System.out.println(" 1 for create Event 2 for update Event 3 or cancle event");
			scanner = new Scanner(System.in);
			int i = scanner.nextInt();
			
			// wee can have 
		if(i==1) {
			//INPUT FROM SCANNER
			System.out.println(" select the event type 1 for meeting 2 for birthday");
			int j = scanner.nextInt();
			System.out.println(" enter location");
			String location = scanner.next();
			System.out.println("enter owner");
			String owner = scanner.next();
			System.out.println("enter title");
			String title = scanner.next();
			List<String>userList=new ArrayList<String>();
			System.out.println(" add user list one by one");
			String userLst = scanner.next();
			userList.add(userLst);
			
			//FACTORY pattern to create types of event either meeting , birthday 
			FactoryEvent factory = new FactoryEvent();
			Event eventType = factory.getEvent(j,location,owner,title,userList);
			
			System.out.println("Enter the time slot in such format startDate 03/01/2013 08:00");  
			String startDate = scanner.next();
			System.out.println("Enter the time slot in such format endDate 03/01/2013 08:30");
			String endDate = scanner.next();
			
			
			//TIMESLOT CREATION
			TimeSlot timeSlot = TimeSlot.createNewSlot("03/01/2013 08:00", "03/01/2013 08:30");
			sc.createEvent(eventType, timeSlot);
			
			HashMap<TimeSlot,Event> eventList = sc.getEventsList();
			for (Map.Entry<TimeSlot,Event> entry : eventList.entrySet())  {
				TimeSlot time = entry.getKey();
				System.out.println(" start time"+time.getBeginDate()+" "+time.getEndDate());
				Event ev = entry.getValue();
				System.out.println(" event "+ev.toString());
			}
		}
		
		else if(i==2) {
			System.out.println(" select the time slot to update");
			boolean status = sc.updateEvent("03/01/2013 08:00", "03/01/2013 08:30", "03/01/2013 10:00","03/01/2013 10:30");
			System.out.println(" update status "+status);
		}
		
		else if(i==3) {
			System.out.println(" select the time slot to cancel");
			boolean status = sc.cancelEvent("03/01/2013 08:00", "03/01/2013 08:30");
			System.out.println(" update status "+status);
		}
		
		}
	
	}
	
}
