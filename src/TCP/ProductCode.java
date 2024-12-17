package TCP;

import java.io.*;
import java.net.*;

public class ProductCode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket socket = new Socket("203.162.10.109", 2209);
		ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN553;rbZmuFMF";
		os.writeObject(code);
		os.flush();
		
		Product product = (Product) is.readObject();
		System.out.println(product);
		
		int price = (int) product.getPrice();
		System.out.println(price);
		
		int sum = 0;
		for (char x : (price + "").toCharArray()) {
			sum += Integer.parseInt(x + "");
		}
		System.out.println(sum);
		
		product.setDiscount(sum);
		
		os.writeObject(product);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
