import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class EventScheduler {

	private HashMap<TimeSlot,Event> eventsList;
	
	public EventScheduler() {
		super();
		eventsList = new HashMap<>();
	}

	public boolean createEvent(Event event, TimeSlot timeslot) {
		for(TimeSlot slot : eventsList.keySet())
		{
			if (slot.collidesWith(timeslot))
			{
				return false;
			}
		}
		eventsList.put(timeslot, event);
		return true;
	}
	
	public HashMap<TimeSlot, Event> getEventsList() {
		return eventsList;
	}

	public boolean updateEvent(String oldbeginDate, String oldEndDate, String beginDate ,String endDate) {
		//here update can be time or maybe title or location.
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		TimeSlot newtime=null;
		TimeSlot oldtime=null;
		try {
			newtime = new TimeSlot(format.parse(beginDate), format.parse(endDate));
			oldtime = new TimeSlot(format.parse(oldbeginDate), format.parse(oldEndDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		if(eventsList.containsKey(oldtime)) {
			Event eve = eventsList.get(oldtime);
			eventsList.remove(oldtime);
			eventsList.put(newtime, eve);
			return true;
		}
		return false;
	}
	
	public boolean cancelEvent(String beginDate ,String endDate) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		TimeSlot time=null;
		try {
			time = new TimeSlot(format.parse(beginDate), format.parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cancel is based on time slot
		if(eventsList.containsKey(time)) {
			eventsList.remove(time); 
			return true;
		}
		return false;
	}
}

