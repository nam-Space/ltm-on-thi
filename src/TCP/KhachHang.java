package TCP;

import java.io.*;
import java.net.*;

public class KhachHang {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket socket = new Socket("203.162.10.109", 2209);
		ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN509;uTZHN0EU";
		os.writeObject(code);
		os.flush();
		
		Customer customer = (Customer) is.readObject();
		System.out.println(customer);
		
		String name = customer.getName();
		System.out.println(name);
		
		String []arrStr = name.split("\\s+");
		String newName = arrStr[arrStr.length - 1].toUpperCase() + ", ";
		for (int i = 0; i < arrStr.length - 1; i++) {
			newName += arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1).toLowerCase() + " ";
		}
//		newName += arrStr[0].substring(0, 1).toUpperCase() + arrStr[0].substring(1).toLowerCase();
		newName = newName.substring(0, newName.length() - 1);
		System.out.println(newName);
		customer.setName(newName);
		
		String date = customer.getDayOfBirth();
		String []arrDate = date.split("\\-");
		String newDate = arrDate[1] + "/" + arrDate[0] + "/" + arrDate[arrDate.length - 1];
		System.out.println(newDate);
		customer.setDayOfBirth(newDate);
		
		String newTk = "";
		for (int i = 0; i < arrStr.length - 1; i++) {
			newTk += arrStr[i].substring(0, 1).toLowerCase();
		}
		newTk += arrStr[arrStr.length - 1].toLowerCase();
		System.out.println(newTk);
		customer.setUserName(newTk);
		
		System.out.println(customer);
		os.writeObject(customer);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
