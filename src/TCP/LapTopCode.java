package TCP;

import java.io.*;
import java.net.*;

public class LapTopCode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket socket = new Socket("203.162.10.109", 2209);
		ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN028;SLHyR3Vn";
		os.writeObject(code);
		os.flush();
		
		Laptop laptop = (Laptop) is.readObject();
		System.out.println(laptop);
		
		String name = laptop.getName();
		String []arrName = name.split("\\s+");
		String newName = "";
		newName = arrName[arrName.length - 1] + " ";
		for (int i = 1; i < arrName.length - 1; i++) {
			newName += arrName[i] + " ";
		}
		newName += arrName[0];
		System.out.println(newName);
		laptop.setName(newName);
		
		String soLuong = laptop.getQuantity() + "";
		String newSoLuong = "";
		for (int i = soLuong.length() - 1; i >= 0; i--) {
			newSoLuong += soLuong.charAt(i);
		}
		System.out.println(newSoLuong);
		laptop.setQuantity(Integer.parseInt(newSoLuong));
		
		os.writeObject(laptop);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
