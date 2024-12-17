package UDP;

import java.io.*;
import java.net.*;

public class UDP_Xoa_Chuoi_1_Trong_Chuoi_2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2208;
		
		String code = ";B21DCCN039;ZbXsY34E";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte []buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.split("\\;");
		String rq = arrStr[0];
		String chuoi1 = arrStr[1];
		String chuoi2 = arrStr[2];
		String res = "";
		for (char x : chuoi1.toCharArray()) {
			if (!chuoi2.contains(x + "")) res += x;
		}
		System.out.println(rq);
		System.out.println(chuoi1);
		System.out.println(chuoi2);
		System.out.println(res);
		String ans = rq + ";" + res;
		System.out.println(ans);
		DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
