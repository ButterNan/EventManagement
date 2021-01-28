import java.util.List;

public abstract class Event {

	public String location;
	public String title;
	public String owner;
	public List<String> userLst;
	public Event(String location, String owner, String title, List<String> userLst) {
		location = location;
		title = title;
		owner = owner;
		userLst = userLst;
	}
	public abstract void createEvent();
}
