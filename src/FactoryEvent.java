import java.util.List;

public class FactoryEvent {

	public static Event getEvent(int type,String location,String owner, String title,List<String> userList) {
		if(type==1) {
			return new Meeting(location,owner,title,userList);
		}
		else if(type ==2) {
			return new Birthday(location,owner,title,userList);
		}
		return null;
	}
}
