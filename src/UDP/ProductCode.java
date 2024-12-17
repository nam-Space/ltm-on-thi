package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ProductCode {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2209;
		
		String code = ";B21DCCN509;yxVxODkM";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[2048];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String rqId = new String(dpNhan.getData(), 0, 8);
		System.out.println(rqId);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Product product = (Product) ois.readObject();
		System.out.println(product);
		
		String name = product.getName();
		String []arrName = name.split("\\s+");
		String newName = arrName[arrName.length - 1] + " ";
		for (int i = 1; i < arrName.length - 1; i++) {
			newName += arrName[i] + " ";
		}
		newName += arrName[0];
		System.out.println(newName);
		product.setName(newName);
		
		String quantity = product.getQuantity() + "";
		String newQuantity = "";
		for (int i = quantity.length() - 1; i >= 0; i--) {
			newQuantity += quantity.charAt(i);
		}
		System.out.println(newQuantity);
		product.setQuantity(Integer.parseInt(newQuantity));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(product);
		
		byte[]sendData = new byte[8 + baos.size()];
		System.arraycopy(rqId.getBytes(), 0, sendData, 0, 8);
		System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
		DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length, sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
