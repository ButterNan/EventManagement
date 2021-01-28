import java.util.List;

public class Meeting extends Event{



	public Meeting(String location, String owner,  String title,List<String> userLst) {
		super(location,owner,title, userLst);
//		location = location;
//		title = title;
//		owner = owner;
//		userLst = userLst;
	}
	public String getLocation() {
		return super.location;
	}
	public String getTitle() {
		return super.title;
	}
	public String getOwner() {
		return super.owner;
	}
	public List<String> getUserLst() {
		return super.userLst;
	}
	@Override
	public void createEvent() {
		// TODO Auto-generated method stub
		
	}
}
