package UDP;

import java.io.*;
import java.net.*;

public class StudentCode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2209;
		
		String code = ";B21DCCN028;i2fESreM";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[2048];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String rqId = new String(dpNhan.getData(), 0, 8);
		System.out.println(rqId);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Student student = (Student) ois.readObject();
		System.out.println(student);
		
		String name = student.getName();
		String []arrName = name.split("\\s+");
		String newName = "";
		for (String x : arrName) {
			newName += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";
		}
		newName = newName.trim();
		System.out.println(newName);
		student.setName(newName);
		
		String newEmail = arrName[arrName.length - 1].toLowerCase();
		for (int i = 0; i < arrName.length - 1; i++) {
			newEmail += arrName[i].substring(0, 1).toLowerCase();
		}
		newEmail += "@ptit.edu.vn";
		System.out.println(newEmail);
		student.setEmail(newEmail);
		
		System.out.println(student);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(student);
		oos.flush();
		
		byte[] sendData = new byte[8 + baos.size()];
		System.arraycopy(rqId.getBytes(), 0, sendData, 0, 8);
		System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
		DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
