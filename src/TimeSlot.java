import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeSlot {
private Date beginDate;
private Date endDate;

public TimeSlot(Date start,Date end) {
	this.beginDate  = start;
	this.endDate = end;
}

public Date getBeginDate() {
	return beginDate;
}

public Date getEndDate() {
	return endDate;
}

public boolean collidesWith(TimeSlot timeSlot) {
	
	if (timeSlot.beginDate.getTime() > beginDate.getTime()
			&& timeSlot.beginDate.getTime() < endDate.getTime())
	{
		return true;
	}
	
	if (timeSlot.endDate.getTime() > beginDate.getTime()
			&& timeSlot.endDate.getTime() < endDate.getTime())
	{
		return true;
	}
	return false;
}

public static TimeSlot createNewSlot(String beginDate, String endDate)
{
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
	try {
		return new TimeSlot(format.parse(beginDate), format.parse(endDate));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;
}
}
