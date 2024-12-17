package UDP;

import java.io.*;
import java.net.*;

public class CustomerCode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2209;
		
		String code = ";B21DCCN553;iw9BF7pb";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[2048];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String rqId = new String(dpNhan.getData(), 0, 8);
		System.out.println(rqId);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Customer customer = (Customer) ois.readObject();
		System.out.println(customer);
		
		String name = customer.getName();
		System.out.println(name);
		String []arrName = name.split("\\s+");
		String newName = arrName[arrName.length - 1].toUpperCase() + ", ";
		for (int i = 0; i < arrName.length - 1; i++) {
			newName += arrName[i].substring(0, 1).toUpperCase() + arrName[i].substring(1).toLowerCase() + " ";
		}
		newName = newName.substring(0, newName.length() - 1);
		System.out.println(newName);
		customer.setName(newName);
		
		String date = customer.getDayOfBirth();
		String []arrDate = date.split("\\-");
		String newDate = arrDate[1] + "/" + arrDate[0] + "/" + arrDate[2];
		System.out.println(newDate);
		customer.setDayOfBirth(newDate);
		
		String newTk = "";
		for (int i = 0; i < arrName.length - 1; i++) {
			newTk += arrName[i].substring(0, 1).toLowerCase();
		}
		newTk += arrName[arrName.length - 1].toLowerCase();
		System.out.println(newTk);
		customer.setUserName(newTk);
		System.out.println(customer);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(customer);
		oos.flush();
		
		byte[] sendData = new byte[8 + baos.size()];
		System.arraycopy(rqId.getBytes(), 0, sendData, 0, 8);
		System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
		DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
