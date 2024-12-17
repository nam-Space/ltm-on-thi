package UDP;

import java.io.*;
import java.net.*;

public class UDP_Loai_bo_ky_tu_dac_biet_va_trung {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2208;
		
		String code = ";B21DCCN509;0vJz0IP3";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.split("\\;");
		String rqId = arrStr[0];
		char []data = arrStr[1].toCharArray();
		int []cnt = new int[301];
		for (int i = 0; i < 301; i++) cnt[i] = 0;
		String res = "";
		for (char x : data) {
			if (Character.isAlphabetic(x)) {
				cnt[x]++;
			}
		}
		for (char x : data) {
			if (cnt[x] >= 1) {
				res += x;
				cnt[x] = 0;
			}
		}
		res = rqId + ";" + res;
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
