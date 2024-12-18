package RMI.B21DCCN048;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.Event;
import RMI.ObjectService;

public class EventCode {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		String studentCode = "B21DCCN048", qCode = "W0ibMCdB";
		Event event = (Event) sv.requestObject(studentCode, qCode);
		System.out.println(event);
		int expectedAttendance = event.getExpectedAttendance();
		String newEventCode = "";
		if (expectedAttendance >= 1000) {
			newEventCode += "L";
		}
		else if (expectedAttendance >= 500 && expectedAttendance <= 999) {
			newEventCode += "M";
		}
		else {
			newEventCode += "S";
		}
		String eventName = event.getEventName();
		System.out.println(eventName);
		newEventCode += eventName.substring(0, 1).toUpperCase() + Character.toUpperCase(eventName.charAt(eventName.length() - 1));
		String eventDate = event.getEventDate();
		System.out.println(eventDate);
		String []arrDate = eventDate.split("\\-");
		newEventCode += arrDate[arrDate.length - 1] + arrDate[arrDate.length - 2];
		System.out.println(newEventCode);
		event.setEventCode(newEventCode);
		
		sv.submitObject(studentCode, qCode, event);
	}
}
