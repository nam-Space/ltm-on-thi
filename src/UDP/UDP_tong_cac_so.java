package UDP;

import java.io.*;
import java.net.*;

public class UDP_tong_cac_so {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2207;
		
		String code = ";B21DCCN039;3EnOHtLx";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String [] arrStr = s.trim().split("\\;");
		String rqId = arrStr[0];
		String num = arrStr[1];
		System.out.println(num);
		int sum = 0;
		for (char x : num.toCharArray()) {
			sum += Integer.parseInt(x + "");
		}
		String res = rqId + ";" + sum;
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
