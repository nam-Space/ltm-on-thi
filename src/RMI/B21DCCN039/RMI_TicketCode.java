package RMI.B21DCCN039;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;

import RMI.ObjectService;
import RMI.Ticket;

public class RMI_TicketCode {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		Ticket ticket = (Ticket) sv.requestObject("B21DCCN039", "d09159Lp");
		System.out.println(ticket);
		String res = "";
		String eventName = ticket.getEventName();
		System.out.println(eventName);
		res += Character.toUpperCase(eventName.charAt(0)) + "" + Character.toUpperCase(eventName.charAt(eventName.length() - 1));
		System.out.println(res);
		String saleDate = ticket.getSaleDate();
		System.out.println(saleDate);
		String []arrDate = saleDate.split("\\/");
		String day = arrDate[0];
		String mon = arrDate[1];
		String year = arrDate[2];
		res += mon + day;
		int nho = 2000000000, lon = -2000000000;
		int []cnt = new int[10];
		for (char x : saleDate.toCharArray()) {
			if (Character.isDigit(x)) {
				cnt[Integer.parseInt(x + "")]++;
			}
		}
		for (int i = 0; i < 10; i++) {
			if (cnt[i] == 0) {
				nho = i;
			}
		}
		for (int i = 9; i >= 0; i--) {
			if (cnt[i] == 0) {
				lon = i;
			}
		}
		System.out.println(lon);
		System.out.println(nho);
		
		res += nho + "" + lon;
		System.out.println(res);
		ticket.setTicketCode(res);
		
		sv.submitObject("B21DCCN039", "d09159Lp", ticket);
	}
}
